package com.iss.program.locationOfTheISS;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ISSMapper {

    protected ISSLocationDTO issLocationDTO(ISSLocation issLocation) {
        return ISSLocationDTO.builder()
                .latitude(issLocation.getLatitude())
                .longitude(issLocation.getLongitude())
                .build();
    }
}

