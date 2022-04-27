package com.iss.program.speedOfTheISS.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iss.program.speedOfTheISS.ISSLocation;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RequiredArgsConstructor
public class IssClient {

    private static final String URL = "http://api.open-notify.org/iss-now.json";

    private final ISSResponseMapper issResponseMapper;

    private final ObjectMapper objectMapper;

    public Optional<ISSLocation> getIssLocation(float latitude, float longitude) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(String.format(URL, latitude, longitude)))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            ISSResponse issResponse = objectMapper.readValue(responseBody, ISSResponse.class);

            return issResponse.getIssPositionList().stream()
                    .map(issResponseMapper::issLocation)
                    .findFirst();

        } catch (Exception e) {
            return Optional.empty();
        }

    }

}
