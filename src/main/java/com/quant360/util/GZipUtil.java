package com.quant360.util;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;

public class GZipUtil {
    public static File unzip(File gzFile) {
        File destFile = new File(gzFile.getAbsoluteFile().toString().replace(".gz", ""));

        try (
                GZIPInputStream gzIos = new GZIPInputStream(Files.newInputStream(gzFile.toPath()));
                FileOutputStream fos = new FileOutputStream(destFile);
        ) {
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            while (true) {
                int read = gzIos.read(buffer);
                if (read == -1) {
                    break;
                }
                fos.write(buffer, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return destFile;
    }

    public static void main(String[] args) {
        String dir = args[0];
        File path = new File(dir);
        for (File file : path.listFiles()) {
            if (file.getName().endsWith(".gz")) {
                unzip(file);
            }
        }
    }
}
