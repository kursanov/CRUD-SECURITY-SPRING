package com.kursanov.crud_lms.controller;

import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.entity.Teacher;
import com.kursanov.crud_lms.server.CourseService;
import com.kursanov.crud_lms.server.StudentService;
import com.kursanov.crud_lms.server.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping("/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourse();
    }

    @GetMapping
    public List<Teacher> findAllTeacher() {
        return teacherService.findAllTeacher();
    }

    @GetMapping("/{id}")
    public Teacher findByIdTeacher(@PathVariable("id") Long id) {
        return teacherService.findByIdTeacher(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher, teacher.getCourseId());
    }

    @PatchMapping("/update/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id) {
        return teacherService.updateTeacher(id, teacher);
    }
    //localhost:9090/api/teacher/count/1  бир мугалимдин канча студенти бар айди менен мугалимдин
    @GetMapping("/count/{id}")
    public Long countByIdT(@PathVariable("id") Long id) {
        teacherService.findByIdTeacher(id);
        return studentService.countByIdT(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacherById(@PathVariable("id") Long id) {
        teacherService.deleteByIdTeacher(id);
    }
}
