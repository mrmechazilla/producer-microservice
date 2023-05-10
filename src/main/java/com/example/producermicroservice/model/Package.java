package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



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
    private ShippingTierEnum shippingTier;
}
