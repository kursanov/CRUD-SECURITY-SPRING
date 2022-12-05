package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.entity.Teacher;
import com.kursanov.crud_lms.repository.CourseRepository;
import com.kursanov.crud_lms.repository.TeacherRepository;
import com.kursanov.crud_lms.server.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher,Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        teacher.setCourse(course);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findByIdTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("hfhfhf")));
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher newTeacher) {
        Course course = courseRepository.findById(id).get();
        Teacher teacher = findByIdTeacher(id);
        teacher.setFirstName(newTeacher.getFirstName());
        teacher.setLastName(newTeacher.getLastName());
        teacher.setEmail(newTeacher.getEmail());
        teacher.setCourseId(newTeacher.getCourseId());
        teacher.setCourse(course);
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteByIdTeacher(Long id) {
        teacherRepository.deleteById(id);

    }
}
