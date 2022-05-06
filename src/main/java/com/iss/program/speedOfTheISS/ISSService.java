package com.iss.program.speedOfTheISS;

import com.iss.program.speedOfTheISS.client.IssClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ISSService {

    private final IssClient issClient;

    private final ISSRepository issRepository;


    protected ISSLocation generateLocation(ISSLocation issLocation) {
        ISSLocation issLocationService = issLocation;

        issLocationService.setLatitude(issLocation.getLatitude());
        issLocationService.setLongitude(issLocation.getLongitude());

        return issRepository.save(issLocationService);
    }


}
