package com.Teste.TesteNivelamentoIntuitiveCare.service;

import java.util.List;

public interface WebScrapplingService {
    List<String> extractPdfLinks(String url);
}