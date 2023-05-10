package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageBox {
    private Long boxId;
    private int boxCode;
    private int boxQuantity;
    private String boxDescription;
}
