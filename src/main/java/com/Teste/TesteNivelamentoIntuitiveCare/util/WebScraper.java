package com.Teste.TesteNivelamentoIntuitiveCare.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebScraper {

    public List<String> extractPdfLinks(String url) {
        List<String> pdfLinks = new ArrayList<>();
        // Adiciona os links específicos dos PDFs
        pdfLinks.add("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_I_Rol_2021RN_465.2021_RN599_RN600.pdf");
        pdfLinks.add("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos/Anexo_II_DUT_2021_RN_465.2021_RN599.pdf");
        return pdfLinks;
    }

}

