package com.Teste.TesteNivelamentoIntuitiveCare.service;

import com.Teste.TesteNivelamentoIntuitiveCare.util.WebScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebScrapplingServiceImpl implements WebScrapplingService {

    private final WebScraper webScraper;

    @Autowired
    public WebScrapplingServiceImpl(WebScraper webScraper) {
        this.webScraper = webScraper;
    }

    @Override
    public List<String> extractPdfLinks(String url) {
        return webScraper.extractPdfLinks(url);
    }
}
