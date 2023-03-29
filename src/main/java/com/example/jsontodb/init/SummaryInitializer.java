package com.example.jsontodb.init;

import com.example.jsontodb.domain.Country;
import com.example.jsontodb.domain.Global;
import com.example.jsontodb.domain.Summary;
import com.example.jsontodb.services.SummaryService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class SummaryInitializer {

    private final SummaryService summaryService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public SummaryInitializer(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = new URL("https://api.covid19api.com/summary");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream inputStream = connection.getInputStream();
        JsonNode rootNode = objectMapper.readTree(inputStream);

        String globalId = rootNode.path("ID").asText();
        Global global = objectMapper.treeToValue(rootNode.path("Global"), Global.class);
        List<Country> countries = objectMapper.readerForListOf(Country.class).readValue(rootNode.path("Countries"));

        Summary summary = new Summary(globalId, "", global, countries);
        summaryService.saveCovidData(summary);
    }
}
