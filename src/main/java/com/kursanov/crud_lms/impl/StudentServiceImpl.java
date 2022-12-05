package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Group;
import com.kursanov.crud_lms.entity.Student;
import com.kursanov.crud_lms.repository.GroupRepository;
import com.kursanov.crud_lms.repository.StudentRepository;
import com.kursanov.crud_lms.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findByIdStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student saveStudent(Student student, Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        student.setGroup(group);
        return studentRepository.save(student);
    }


    @Override
    public Student updateStudent(Student newStudent, Long id) {
        Student student = findByIdStudent(id).get();
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());
        student.setStudyFormat(newStudent.getStudyFormat());
        student.setGroupId(newStudent.getGroupId());
        return studentRepository.save(student);
    }

    @Override
    public Long countById(Long id) {
        return studentRepository.count();
    }

    @Override
    public Long countByIdT(Long id) {
        return studentRepository.countByIdT(id);
    }

    @Override
    public List<Student> findStudentWithSort(String sorting) {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,sorting));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
