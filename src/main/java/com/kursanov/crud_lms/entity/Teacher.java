package com.kursanov.crud_lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "teachers_courses", joinColumns = @JoinColumn(name = "teachers_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id"))
    @JsonIgnore
    private Course course;
    @Transient
    Long courseId;
}
