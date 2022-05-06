package com.iss.program.speedOfTheISS;

import com.iss.program.speedOfTheISS.client.IssClient;
import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ISSService {

    private final IssClient issClient;

    private final ISSRepository issRepository;


    protected ISSLocation generateLocation(ISSLocation issLocation) {
        ISSLocation issLocationService = issClient.getIssLocation(issLocation.getLatitude(), issLocation.getLongitude())
                .orElseThrow(() -> new InternalException("Location cannot be generated" + issLocation.getLatitude() + "" + issLocation.getLongitude()));

        return issRepository.save(issLocationService);
    }


}
