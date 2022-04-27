package com.iss.program.speedOfTheISS.client;

import com.iss.program.speedOfTheISS.ISSLocation;

public class ISSResponseMapper {

    public ISSLocation issLocation(ISSResponse.ISSPosition issPosition) {
        ISSLocation issLocation = new ISSLocation();

        issLocation.setPosition(issPosition.getIssPositionLatLong().getLatitude());
        issLocation.setPosition(issPosition.getIssPositionLatLong().getLongitude());

        return issLocation;

    }
}
