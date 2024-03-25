package com.Teste.TesteNivelamentoIntuitiveCare.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipService {

    public static void zipDirectory(String sourceDir, String zipFilePath) {
        File directory = new File(sourceDir);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("O diretório de origem não existe ou não é um diretório válido.");
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            zipFiles(directory, sourceDir, zos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFiles(File directory, String baseName, ZipOutputStream zos) throws IOException {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("O diretório está vazio.");
            return;
        }
        byte[] buffer = new byte[1024];
        int bytesRead;
        for (File file : files) {
            if (file.isDirectory()) {
                zipFiles(file, baseName, zos);
                continue;
            }
            FileInputStream fis = new FileInputStream(file);
            String zipFilePath = file.getPath().substring(baseName.length() + 1);
            ZipEntry zipEntry = new ZipEntry(zipFilePath);
            zos.putNextEntry(zipEntry);
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }
            fis.close();
        }
    }
}

