package com.iss.program.speedOfTheISS;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ISSController {

    private final ISSMapper issMapper;

    private final ObjectMapper objectMapper;

}
