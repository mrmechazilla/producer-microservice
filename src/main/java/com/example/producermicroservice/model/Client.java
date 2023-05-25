package com.example.producermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor @ToString
//@Entity
public class Client {
    private Long clientId;
    private String firstname;
    private String lastname;
    private String idNumber;
    private Date dateOfBirth;
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Event> events;

}
