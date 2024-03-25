package com.Teste.TesteNivelamentoIntuitiveCare.controller;

import com.Teste.TesteNivelamentoIntuitiveCare.service.PdfDownloadService;
import com.Teste.TesteNivelamentoIntuitiveCare.service.WebScrapplingService;
import com.Teste.TesteNivelamentoIntuitiveCare.service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/scrappling")
public class WebScrapplingController {

    private final WebScrapplingService webScrapplingService;
    private final PdfDownloadService pdfDownloadService;

    @Autowired
    public WebScrapplingController(WebScrapplingService webScrapplingService, PdfDownloadService pdfDownloadService) {
        this.webScrapplingService = webScrapplingService;
        this.pdfDownloadService = pdfDownloadService;
    }

    @GetMapping("/download-pdfs")
    public void downloadAndZipPdfs() {
        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
        List<String> pdfLinks = webScrapplingService.extractPdfLinks(url);
        String tempDir = "temp";

        for (String pdfLink : pdfLinks) {
            String pdfFileName = pdfLink.substring(pdfLink.lastIndexOf("/") + 1);
            try {
                pdfDownloadService.downloadPdf(pdfLink, pdfFileName, tempDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String zipFilePath = "arquivo.zip";
        ZipService.zipDirectory(tempDir, zipFilePath);

        System.out.println("Arquivo ZIP criado com sucesso em: " + zipFilePath);
    }
}