package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Company;
import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.repository.CompanyRepository;
import com.kursanov.crud_lms.repository.CourseRepository;
import com.kursanov.crud_lms.server.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {

    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CompanyRepository companyRepository, CourseRepository courseRepository) {
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course, Long companyId) {
        Company company = companyRepository.findById(companyId).get();
        course.setCompany(company);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course newCourse, Long id ) {
        Course course = findById(id).get();
        course.setCourseName(newCourse.getCourseName());
        course.setDuration(newCourse.getDuration());
        course.setCompanyId(newCourse.getCompanyId());
        return courseRepository.save(course);

    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
