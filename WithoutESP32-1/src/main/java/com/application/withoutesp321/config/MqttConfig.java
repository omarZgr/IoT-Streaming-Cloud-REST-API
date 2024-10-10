package com.application.withoutesp321.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MqttConfig {

    // Uncomment these lines when ready to use real MQTT broker
    // @Bean
    // public MqttClient mqttClient() throws Exception {
    //     MqttClient client = new MqttClient("tcp://localhost:1883", "esp32_simulator", new MemoryPersistence());
    //     MqttConnectOptions options = new MqttConnectOptions();
    //     options.setCleanSession(true);
    //     client.connect(options);
    //     return client;
    // }
}
