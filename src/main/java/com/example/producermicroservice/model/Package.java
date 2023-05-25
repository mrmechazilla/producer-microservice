package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Package {
    private Long packageId;
    private double packageWeight;
    private double packageHeight;
    private double packageWidth;
    private double packagePrice;
    @Enumerated(EnumType.STRING)
    private ShippingTierEnum shippingTier;
    private String departureAddress;
    private String arrivalAddress;
    @ManyToOne
    private Event event;
    @ManyToOne
    private PackageBox packagebox;
}
