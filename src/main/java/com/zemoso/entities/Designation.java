package com.zemoso.entities;

import lombok.*;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(name = "designation")
public class Designation {
    @Id
    private UUID id=UUID.randomUUID();
    private String name;

    public Designation(){}

    public Designation(String name) {
        this.name = name;
    }
}
