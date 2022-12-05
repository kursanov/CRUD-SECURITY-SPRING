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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "companies_id")
    @JsonIgnore
    private Company company;
    @Transient
    private Long companyId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "groups_id"))
    @JsonIgnore
    private List<Group> group;


    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinTable(name = "teachers_courses",joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "teachers_id"))
    @JsonIgnore
    private Teacher teacher;
}
