package com.kursanov.crud_lms.server;

import com.kursanov.crud_lms.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {



    List<Course> findAllCourse();

    Optional<Course> findById(Long id);

    Course saveCourse(Course course, Long companyId);

    Course updateCourse(Course newCourse, Long id);

    void deleteById(Long id);
}
