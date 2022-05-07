package com.iss.program.locationOfTheISS;

import com.iss.program.locationOfTheISS.client.ISSResponse;
import com.iss.program.locationOfTheISS.client.IssClient;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class ISSService {

    private final IssClient issClient;
    private final ISSRepository issRepository;

    protected ISSLocation generateLocation(ISSLocation issLocation) throws IOException, InterruptedException {
        ISSResponse.ISSPosition clientIssLocation = issClient.getIssLocation();

        issLocation.setLatitude(clientIssLocation.getLatitude());
        issLocation.setLongitude(clientIssLocation.getLongitude());

        return issRepository.save(issLocation);
    }


}
