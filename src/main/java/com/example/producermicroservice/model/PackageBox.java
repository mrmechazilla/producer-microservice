package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageBox {
    private Long boxId;
    private int boxCode;
    private int boxQuantity;
    private String boxDescription;
    @OneToMany(mappedBy = "packagebox")
    private List<Package> packages;
    @ManyToOne
    private PackageProcessor packageprocessor;
}
