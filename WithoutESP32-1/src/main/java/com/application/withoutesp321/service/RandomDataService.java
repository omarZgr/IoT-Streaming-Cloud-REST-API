package com.application.withoutesp321.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@Service
public class RandomDataService {

    private final Random random = new Random();

    public Flux<String> getRandomDataStream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> "Random Data: Temperature = " + (20 + random.nextInt(15)) + "°C, Humidity = " + (30 + random.nextInt(40)) + "%")
                .doOnNext(item-> System.out.println("received : "+item));
    }
}
