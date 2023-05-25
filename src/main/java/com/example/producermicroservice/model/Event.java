package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor @AllArgsConstructor @ToString
//@Entity
public class Event {
    private Long eventId;
    private Date eventDate;
    private boolean extracted;
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "event")
    private List<Package> packages;
}
