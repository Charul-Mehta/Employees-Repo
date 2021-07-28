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
@Table(name = "designations")
public class Designations{
    @Id
    private UUID id=UUID.randomUUID();
    private String name;

    public Designations(){}

    public Designations(String name) {
        this.name = name;
    }
}
