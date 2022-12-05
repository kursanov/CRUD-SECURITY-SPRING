package com.kursanov.crud_lms.controller;

import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.server.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courserService;

    @GetMapping
    public List<Course> findAllCourse() {
        return courserService.findAllCourse();
    }

    @GetMapping("/{id}")
    public Optional<Course> findById(@PathVariable("id") Long id) {
        return courserService.findById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course) {
        return courserService.saveCourse(course, course.getCompanyId());
    }

    @PatchMapping("/update/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable("id") Long companyId) {
        course.setCompanyId(companyId);
        return courserService.updateCourse(course,course.getCompanyId());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCoursesById(@PathVariable("id") Long id) {
        courserService.deleteById(id);
    }
}
