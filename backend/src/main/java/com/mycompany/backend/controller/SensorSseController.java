/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backend.controller;

import com.mycompany.backend.model.SensorReading;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
@RestController
@CrossOrigin(origins = "*")
public class SensorSseController {

    private final Random random = new Random();


    @GetMapping(path = "/sse/sensors", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SensorReading> streamSensorReadings() {
        
        return Flux.interval(Duration.ofSeconds(2))
        .map(seq -> {
            
            String sensorId = "sensor-" + (1 + random.nextInt(3));
            double temp = 18 + random.nextDouble() * 12;
            double hum = 30 + random.nextDouble() * 50;
            long ts = Instant.now().toEpochMilli();
            SensorReading reading = new SensorReading(sensorId, round(temp,2), round(hum,2), ts);
            System.out.println("[SSE] Emitting: " + reading);
            return reading;
            
        });
        
    }


    private static double round(double value, int places) {
        
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
        
    }
}
