package com.quant360;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.quant360.parser.MBOParser;
import com.quant360.parser.Message;
import com.quant360.parser.PacketParser;
import com.quant360.parser.SnapshotParser;
import com.quant360.util.GZipUtil;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String PROGRAM_NAME = "CMEParser";

    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("t", "type", true, "parser type");
        options.addOption("o", "out", true, "output file name");
        options.addOption("n", "thread", true, "number of threads used to parse pcap files");
        options.addOption("k", "keep", false, "keep unzipped file");
        options.addOption("h", "help", false, "help");

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        if (commandLine.hasOption("h")) {
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp(
                    "java -jar " +
                            PROGRAM_NAME +
                            ".jar [OPTIONS] <pcap file>/<pcap file directory>",
                    options);
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(commandLine.getOptionValue("n", "1")));

        String type = commandLine.getOptionValue("t", "MBO");
        Class<? extends PacketParser> parserClass;

        switch (type) {
            case "MBO": parserClass = MBOParser.class; break;
            case "Snapshot": parserClass = SnapshotParser.class; break;
            default: System.out.println("Unknown parser type: " + type); return;
        }

        Pattern filenamePattern = (Pattern) parserClass.getField("FILENAME_PATTERN").get(null);
        System.out.println(filenamePattern);

        List<File> inputFiles = new ArrayList<>();
        File inputDir = new File(commandLine.getArgs()[0]);
        if (inputDir.isDirectory()) {
            inputFiles.addAll(
                    Arrays.asList(Objects.requireNonNull(
                            inputDir.listFiles(filename -> filenamePattern.matcher(filename.getName()).matches())
                    ))
            );
        } else {
            inputFiles.add(inputDir);
        }

        List<File> unzippedFiles = inputFiles.stream().map(GZipUtil::unzip).collect(Collectors.toList());

        List<Future<List<Message>>> futures = unzippedFiles.stream().map(file -> executor.submit(() -> {
            PacketParser parser = parserClass.getConstructor(String.class).newInstance(file.getAbsolutePath());
            return parser.parse();
        })).collect(Collectors.toList());

        List<List<Message>> results = new ArrayList<>();
        futures.parallelStream().forEach(future -> {
            try {
                results.add(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();

        results.sort((o1, o2) -> {
            if (o1.size() > 0 && o2.size() > 0) {
                return (int) (o1.get(0).sequence_number - o2.get(0).sequence_number);
            } else if (o1.size() == 0) {
                return -1;
            } else {
                return 1;
            }
        });

        List<Message> sortedMessages = new ArrayList<>();
        results.forEach(sortedMessages::addAll);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(parserClass.getClasses()[0]).withHeader().withoutQuoteChar();

        File output = new File(commandLine.getOptionValue("o", "output.csv"));
        File outputFilename;
        if (output.isDirectory()) {
            outputFilename = new File(output, "output.csv");
        } else {
            outputFilename = output;
        }

        try (
                FileOutputStream fos = new FileOutputStream(outputFilename)
                ) {
            mapper.writer(schema).writeValues(fos).writeAll(sortedMessages);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!commandLine.hasOption("k")) {
            unzippedFiles.forEach(file -> {
                if (file.delete()) {
                    System.out.println("File deleted: " + file.getAbsolutePath());
                } else {
                    System.out.println("File delete failed: " + file.getAbsolutePath());
                }
            });
        }
    }
}
