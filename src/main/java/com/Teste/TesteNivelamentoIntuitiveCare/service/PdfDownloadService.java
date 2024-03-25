package com.Teste.TesteNivelamentoIntuitiveCare.service;

import java.io.IOException;

public interface PdfDownloadService {
    void downloadPdf(String pdfUrl, String pdfFileName, String targetDirectory) throws IOException;
}