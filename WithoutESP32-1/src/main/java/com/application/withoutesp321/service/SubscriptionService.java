package com.application.withoutesp321.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.Random;

@Service
public class SubscriptionService {

    private final Random random = new Random();
    private final Sinks.Many<String> sink;
    private Flux<String> flux;

    public SubscriptionService() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
        this.flux = sink.asFlux().cache(0);
    }

    // Start streaming random data one by one (separately)
    public void startRandomDataStream() {
        Flux.interval(Duration.ofSeconds(3))
                .flatMap(i -> Flux.just(
                        "Temperature = " + (20 + random.nextInt(15)) + "°C",
                        "Humidity = " + (30 + random.nextInt(40)) + "%"
                ))
                .doOnNext(sink::tryEmitNext)
                .subscribe();
    }

    // Return the Flux stream for consumption
    public Flux<String> getStream() {
        return flux;
    }

    // Cancel subscription by resetting the Flux and sink
    public void cancelSubscription() {
        this.sink.emitComplete(Sinks.EmitFailureHandler.FAIL_FAST);
        this.flux = Flux.empty();
    }
}
