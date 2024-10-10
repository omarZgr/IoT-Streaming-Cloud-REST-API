package com.application.withoutesp321.controller;

import com.application.withoutesp321.service.MqttService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {

    private final MqttService mqttService;

    public MqttController(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @GetMapping("/temperature")
    public String getTemperature() {
        return "Current temperature: " + mqttService.getLastTemp();
    }

    @GetMapping("/humidity")
    public String getHumidity() {
        return "Current humidity: " + mqttService.getLastHum();
    }
}

