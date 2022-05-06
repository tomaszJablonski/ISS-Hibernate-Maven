package com.iss.program.speedOfTheISS;

import com.iss.program.speedOfTheISS.client.ISSResponse;
import com.iss.program.speedOfTheISS.client.IssClient;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class ISSService {

    private final IssClient issClient;
    private final ISSRepository issRepository;


    protected ISSLocation generateLocation(ISSLocation issLocation) throws IOException, InterruptedException {
        ISSResponse.ISSPosition issLocationService = issClient.getIssLocation();

        issLocationService.setLatitude(issLocation.getLatitude());
        issLocationService.setLongitude(issLocation.getLongitude());

        return issRepository.save(issLocation);
    }


}
