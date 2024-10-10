package com.application.withoutesp321.controller;

import com.application.withoutesp321.service.PredictionService;
import com.application.withoutesp321.service.SubscriptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("process")
public class DataControllerSubsribe {

    private final SubscriptionService subscriptionService;

    private final PredictionService predictionService;

    public DataControllerSubsribe(SubscriptionService subscriptionService,PredictionService predictionService) {
        this.subscriptionService = subscriptionService;
        this.predictionService = predictionService;

    }

    // Start the random data stream and subscribe to it
    @PostMapping("/start")
    public String startStream() {
        subscriptionService.startRandomDataStream();
        return "Data stream started!";
    }

    // Streaming data with Server-Sent Events (SSE)
    @GetMapping(value = "/data", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getData() {
        return subscriptionService.getStream();
    }

    // Cancel the subscription to the data stream
    @PostMapping("/cancel")
    public String cancelStream() {
        subscriptionService.cancelSubscription();
        return "Subscription canceled!";
    }


    // Endpoint to predict future sensor data for a given number of hours
    @GetMapping("/predict")
    public Map<String, Object> predict(@RequestParam int hours) {
        return predictionService.predictForHours(hours);
    }
}
