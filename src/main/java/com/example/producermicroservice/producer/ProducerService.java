package com.example.producermicroservice.producer;

import com.example.producermicroservice.model.*;
import com.example.producermicroservice.model.Package;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC_NAME = "X";
    public String sendRandomObjects(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        AtomicInteger recordsSent = new AtomicInteger(0);
        executor.scheduleAtFixedRate(() -> {
            for (int i = 1; i <= 200; i++) {

                // Client class
                Client client = new Client(
                        (long) i,
                        new Faker().name().firstName(),
                        new Faker().name().lastName(),
                        new Faker().lorem().characters(8),
                        new Date(),
                        new Faker().address().cityName() + ", " + new Faker().address().country(),
                        null);


                // Event class
                Event event = new Event(
                        (long) i,
                        new Faker().date().past(30, TimeUnit.DAYS),
                        false,
                        client,
                        null);


                // Package Processor class
                PackageProcessor packageProcessor = new PackageProcessor(
                        (long) i,
                        new Faker().name().firstName(),
                        "to be shipped",
                        null);


                // PackageBox class
                PackageBox packageBox = new PackageBox(
                        (long) i,
                        (int) (Math.random() * 7),
                        (int) (Math.random() * 50),
                        "Box of items",
                        null,
                        packageProcessor);


                // Package class
                com.example.producermicroservice.model.Package apackage = new Package(
                        (long) i,
                        new Faker().number().randomDouble(2, 0, 100),
                        new Faker().number().randomDouble(2, 0, 100),
                        new Faker().number().randomDouble(2, 0, 100),
                        0.0,
                        ShippingTierEnum.valueOf(new Faker().options().option("STANDARD", "PREMIUM", "VIP")),
                        new Faker().address().cityName() + ", " + new Faker().address().country(),
                        new Faker().address().cityName() + ", " + new Faker().address().country(),
                        event,
                        packageBox);

                kafkaTemplate.send(TOPIC_NAME, client);
                kafkaTemplate.send(TOPIC_NAME, event);
                kafkaTemplate.send(TOPIC_NAME, apackage);
                kafkaTemplate.send(TOPIC_NAME, packageBox);
                kafkaTemplate.send(TOPIC_NAME, packageProcessor);

                int totalRecordsSent = recordsSent.incrementAndGet();
                if (totalRecordsSent == 5000) {
                    executor.shutdown();
                    break;
                }

            }
        }, 0, 10, TimeUnit.SECONDS);

        return "Data sending scheduled successfully...";
    }
}
