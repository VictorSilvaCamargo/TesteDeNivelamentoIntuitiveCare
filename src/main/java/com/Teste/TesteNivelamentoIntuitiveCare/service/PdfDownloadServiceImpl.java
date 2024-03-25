package com.Teste.TesteNivelamentoIntuitiveCare.service;

import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfDownloadServiceImpl implements PdfDownloadService {
    @Override
    public void downloadPdf(String pdfUrl, String pdfFileName, String targetDirectory) throws IOException {
        createDirectory(targetDirectory);
        try (InputStream in = new URL(pdfUrl).openStream();
             OutputStream out = new FileOutputStream(targetDirectory + "/" + pdfFileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    private void createDirectory(String directoryPath) throws IOException {
        Path targetDirectoryPath = Paths.get(directoryPath);
        if (!Files.exists(targetDirectoryPath)) {
            Files.createDirectories(targetDirectoryPath);
        }
    }
}