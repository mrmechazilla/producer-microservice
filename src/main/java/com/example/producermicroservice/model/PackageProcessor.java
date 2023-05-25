package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageProcessor {
    private Long processorId;
    private String fullname;
    private String description;
    @OneToMany(mappedBy = "packageprocessor")
    private List<PackageBox> packageBoxes;
}
