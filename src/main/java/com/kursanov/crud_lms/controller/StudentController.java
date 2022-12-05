package com.kursanov.crud_lms.controller;

import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.entity.Student;
import com.kursanov.crud_lms.server.GroupService;
import com.kursanov.crud_lms.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public List<Group> findAllGroup() {
        return groupService.findAllGroups();
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }


    //localhost:9090/api/student/firstName эгер сортту аты менен жасай турган болсо
    @GetMapping("/{sort}")
    public String sortStudent(@PathVariable String sort) {
        return studentService.findStudentWithSort(sort).toString();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student, student.getGroupId());
    }

    @PatchMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }
}
