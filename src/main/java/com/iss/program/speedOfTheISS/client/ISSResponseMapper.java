package com.iss.program.speedOfTheISS.client;

import com.iss.program.speedOfTheISS.ISSLocation;

public class ISSResponseMapper {

    public ISSLocation issLocation(ISSResponse.ISSPosition issPosition) {
        ISSLocation issLocation = new ISSLocation();

        issLocation.setLatitude(issPosition.getLatitude());
        issLocation.setLongitude(issPosition.getLongitude());

        return issLocation;

    }
}
