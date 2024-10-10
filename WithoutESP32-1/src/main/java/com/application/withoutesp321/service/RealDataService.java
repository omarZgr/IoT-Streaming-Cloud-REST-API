package com.application.withoutesp321.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RealDataService {

    // This method would consume data from the MQTT broker
    public Flux<String> getRealDataStream() {
        return Flux.just("Real data is not available yet.");
    }
}
