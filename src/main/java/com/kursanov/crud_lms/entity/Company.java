package com.kursanov.crud_lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "companies")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String locatedCounty;


    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH}, mappedBy = "company")
    @JsonIgnore
    private List<Course> course;

}
