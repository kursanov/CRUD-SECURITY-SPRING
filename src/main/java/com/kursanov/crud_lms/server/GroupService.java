package com.kursanov.crud_lms.server;

import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.entity.Student;

import java.util.List;

public interface GroupService {


    List<Group> findAllGroups();

    Group saveGroup(Group group, Long courseId);


    Group findById(Long id);

    Group updateGroup(Group group,Long courseId);

    List<Student> findByStudents(String  search);

    void deleteById(Long id);
}
