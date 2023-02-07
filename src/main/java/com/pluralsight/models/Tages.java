package com.pluralsight.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;


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