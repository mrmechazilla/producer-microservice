package com.example.producermicroservice.producer;

import com.example.producermicroservice.model.*;
import com.example.producermicroservice.model.Package;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/send")
    public String sendObject(){
        return producerService.sendRandomObjects();
    }
}

