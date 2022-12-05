package com.kursanov.crud_lms.controller;

import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.server.CourseService;
import com.kursanov.crud_lms.server.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final CourseService courseService;
    private final GroupService groupService;

    @Autowired
    public GroupController(CourseService courseService, GroupService groupService) {
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @GetMapping("courses")
    public List<Course> getAllCourses() {
        return courseService.findAllCourse();
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.findAllGroups();
    }

    @GetMapping("/{id}")
    public Optional<Group> findByIdGroups(@PathVariable("id") Long id) {
        return Optional.ofNullable(groupService.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public Group saveGroups(@RequestBody Group group) {
        return groupService.saveGroup(group, group.getCourseId());
    }

    @PatchMapping("/update/{id}")
    public Group updateGroups(@RequestBody Group group, @PathVariable("id") Long courseId) {
        group.setCourseId(courseId);
        return groupService.updateGroup(group, courseId);
    }
    //localhost:9090/api/groups/search?student=Timur издоо жолу
    @GetMapping("/search")
    public String searchStudent(@RequestParam("student") String search) {
        return groupService.findByStudents(search).toString();


    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroupsById(@PathVariable("id") Long id) {
        groupService.deleteById(id);
    }
}
