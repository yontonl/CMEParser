package com.quant360;


import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.quant360.parser.MBOParser;
import com.quant360.util.GZipUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String dir = args[0];

        Pattern pattern = Pattern.compile(".*31_130.*00000\\.gz");
        File path = new File(dir);

        ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(args[1]));
        List<File> destFiles = new ArrayList<>();
        for (File file : path.listFiles()) {
            if (pattern.matcher(file.getName()).matches()) {
                destFiles.add(GZipUtil.gunzip(file));
            }
        }
        List<Future<List<MBOParser.MBO>>> futures = destFiles.stream().map(file -> executorService.submit(() -> {
            MBOParser parser = new MBOParser(file.getAbsolutePath());
            return parser.parse();
        })).collect(Collectors.toList());

        List<List<MBOParser.MBO>> results = new ArrayList<>();
        futures.parallelStream().forEach(future -> {
            try {
                results.add(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();

        results.sort((o1, o2) -> {
            if (o1.size() > 0 && o2.size() > 0) {
                return (int) (o1.get(0).sequence_number - o2.get(0).sequence_number);
            } else if (o1.size() == 0) {
                return -1;
            } else {
                return 1;
            }
        });

        List<MBOParser.MBO> result = new ArrayList<>();
        results.forEach(result::addAll);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(MBOParser.MBO.class).withHeader();
        try (
                FileOutputStream fos = new FileOutputStream("/home/ytliu/20220817.CME_GBX.NYMEX.31_130.A.04.MBO");
        ) {
            mapper.writer(schema).writeValues(fos).writeAll(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        destFiles.forEach(file -> {
            if (file.delete()) {
                System.out.println("File deleted: " + file.getAbsolutePath());
            } else {
                System.out.println("File delete failed: " + file.getAbsolutePath());
            }
        });
    }
}
