package com.iss.program.locationOfTheISS;

import com.iss.program.locationOfTheISS.client.IssClient;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class ISSService {

    private final IssClient issClient;
    private final ISSRepository issRepository;

    protected ISSLocation generateLocation() throws IOException, InterruptedException {
        var response = issClient.getIssLocation();

        return issRepository.save(new ISSLocation(response.getLatitude(), response.getLongitude()));
    }


}
