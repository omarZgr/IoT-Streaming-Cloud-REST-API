package com.application.withoutesp321.controller;

import com.application.withoutesp321.service.RandomDataService;
import com.application.withoutesp321.service.RealDataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DataController {

    private final RandomDataService randomDataService;
    private final RealDataService realDataService;

    public DataController(RandomDataService randomDataService, RealDataService realDataService) {
        this.randomDataService = randomDataService;
        this.realDataService = realDataService;
    }

    // Streaming random data with Server-Sent Events (SSE)
    @GetMapping(value = "/data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getData() {
        // Currently using the random data stream; later you can switch to real data
        return randomDataService.getRandomDataStream();
    }
}
