package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tages")
@Data
@NoArgsConstructor
public class Tages {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skillsCovered")
    @JsonIgnore
    private Course skillsCovered;
    @ManyToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "studentPreference")
    @JsonIgnore
    private Student studentPreference;

    public Tages(String name) {
        this.name = name;
    }
}