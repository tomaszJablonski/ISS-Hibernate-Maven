package com.iss.program.locationOfTheISS;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ISSController {

    private final ISSMapper issMapper;
    private final ObjectMapper objectMapper;
    private final ISSService issService;

    public String getISSLocation() {
        try {
            ISSLocation issLocation = issService.generateLocation();
            ISSLocationDTO locationDTO = issMapper.issLocationDTO(issLocation);
            return objectMapper.writeValueAsString(locationDTO);

        } catch (Exception e) {
            return String.format("{\"status\": \"error\", \"message\": \"%s\"}", e.getMessage());

        }

    }


}
