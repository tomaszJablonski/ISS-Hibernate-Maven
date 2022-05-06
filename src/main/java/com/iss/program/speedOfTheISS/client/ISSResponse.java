package com.iss.program.speedOfTheISS.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ISSResponse {

    @JsonProperty("iss_position")
    private ISSPosition issPosition;

    @Data
    public static class ISSPosition {
        @JsonProperty("latitude")
        private float latitude;
        @JsonProperty("longitude")
        private float longitude;


    }
    }
