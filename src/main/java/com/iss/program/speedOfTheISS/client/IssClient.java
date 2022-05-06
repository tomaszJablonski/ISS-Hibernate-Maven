package com.iss.program.speedOfTheISS.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class IssClient {

    private static final String URL = "http://api.open-notify.org/iss-now.json";

    private final ObjectMapper objectMapper;

    private final ISSResponseMapper issResponseMapper;

    public ISSResponse.ISSPosition getIssLocation() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format(URL)))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
//        try {
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = httpResponse.body();

        ISSResponse issResponse = objectMapper.readValue(responseBody, ISSResponse.class);

        return issResponse.getIssPosition();

//        } catch (Exception e) {
//            return System.out.println(e.getMessage());
//
//
//
//        }

    }

}
