package com.iss.program.locationOfTheISS.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ISSResponse {

    @JsonProperty("iss_position")
    private ISSPosition issPosition;
    @JsonProperty("message")
    private String message;
    @JsonProperty("timestamp")
    private Long timestamp;

    @Data
    public static class ISSPosition {
        @JsonProperty("latitude")
        private float latitude;
        @JsonProperty("longitude")
        private float longitude;

    }
}
