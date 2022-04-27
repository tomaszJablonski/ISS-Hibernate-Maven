package com.iss.program.speedOfTheISS.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ISSResponse {

    private List<ISSPosition> issPositionList;

    @Data
    public static class ISSPosition {
        @JsonProperty("iss_position")
        private ISSPositionLatLong issPositionLatLong;

        @Data
        public static class ISSPositionLatLong {
            @JsonProperty("longitude")
            private float longitude;
            @JsonProperty("latitude")
            private float latitude;

        }
    }
}