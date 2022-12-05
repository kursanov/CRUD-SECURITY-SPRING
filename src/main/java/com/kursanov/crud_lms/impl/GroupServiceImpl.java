package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.entity.Student;
import com.kursanov.crud_lms.repository.CourseRepository;
import com.kursanov.crud_lms.repository.GroupRepository;
import com.kursanov.crud_lms.repository.StudentRepository;
import com.kursanov.crud_lms.server.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public GroupServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group saveGroup(Group group, Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        group.setCourse(Collections.singletonList(course));
        return groupRepository.save(group);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group updateGroup(Group newGroup, Long courseId) {
        Group group = findById(courseId);
        group.setGroupName(newGroup.getGroupName());
        group.setDateOfStart(newGroup.getDateOfStart());
        group.setDateOfFinish(newGroup.getDateOfFinish());
        group.setCourseId(newGroup.getCourseId());
        return groupRepository.save(group);
    }
    @Override
    public List<Student> findByStudents(String search) {
        if (search !=null){
            return groupRepository.findByStudents(search);
        }
        return  studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }
}
