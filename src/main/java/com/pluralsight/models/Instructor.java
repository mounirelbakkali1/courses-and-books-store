package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
   @OneToMany(mappedBy = "instructor")
    @Fetch(value = FetchMode.SUBSELECT)
   @JsonIgnore
    private List<Course> courses= new ArrayList<>();
    @NotBlank
    private String name ;
    private  String bio;

    public Instructor( String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
}