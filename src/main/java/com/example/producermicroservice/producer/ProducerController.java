package com.example.producermicroservice.producer;

import com.example.producermicroservice.model.*;
import com.example.producermicroservice.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC_NAME = "X";

    @GetMapping("/send")
    public String sendObject(){
        for (int i = 1; i <= 100; i++) {

            // Client class
            Client client = new Client(
                    (long) i,
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 8),
                    "123456789",
                    new Date(),
                    UUID.randomUUID().toString().substring(0, 8));

            // Event class
            Event event = new Event(
                    (long) i,
                    new Date(),
                    false);

            // Package class
            Package apackage = new Package(
                    (long) i,
                    10.5,
                    2.0,
                    2.5,
                    20.0,
                    ShippingTierEnum.PREMIUM);

            // PackageBox class
            PackageBox packageBox = new PackageBox(
                    (long) i,
                    12345,
                    2,
                    "Box for fragile items");

            // Package Processor class
            PackageProcessor packageProcessor = new PackageProcessor(
                    (long) i,
                    UUID.randomUUID().toString().substring(0, 8),
                    UUID.randomUUID().toString().substring(0, 12));


            kafkaTemplate.send(TOPIC_NAME, client);
            kafkaTemplate.send(TOPIC_NAME, event);
            kafkaTemplate.send(TOPIC_NAME, apackage);
            kafkaTemplate.send(TOPIC_NAME, packageBox);
            kafkaTemplate.send(TOPIC_NAME, packageProcessor);

        }

        return "Data sent successfully...";
    }
}

