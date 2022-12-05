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
@Table(name = "groups")
public class Group {


    @Id
    @GeneratedValue
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "groups_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id"))
    @JsonIgnore
    private List<Course> course;
    @Transient
    private Long courseId;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH},mappedBy = "groups")
    private List<Student> students;

}
