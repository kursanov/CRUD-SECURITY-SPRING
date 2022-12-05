package com.kursanov.crud_lms.server;

import com.kursanov.crud_lms.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllTeacher();

    Teacher saveTeacher(Teacher teacher,Long id);

    Teacher findByIdTeacher(Long id);

    Teacher updateTeacher(Long id,Teacher teacher);

    void deleteByIdTeacher(Long id);
}
