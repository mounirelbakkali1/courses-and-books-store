package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tages")
@Getter
@Setter
@NoArgsConstructor
public class Tages {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;


    public Tages(String name) {
        this.name = name;
    }
}