package com.iss.program.speedOfTheISS.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ISSResponse {

    private List<ISSPosition> issPositionList;

    @Data
    public static class ISSPosition {
        @JsonProperty("latitude")
        private float latitude;
        @JsonProperty("longitude")
        private float longitude;


    }
    }
