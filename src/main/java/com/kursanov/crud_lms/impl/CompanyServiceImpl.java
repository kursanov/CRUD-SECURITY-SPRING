package com.kursanov.crud_lms.impl;

import com.kursanov.crud_lms.entity.Company;
import com.kursanov.crud_lms.entity.Course;
import com.kursanov.crud_lms.repository.CompanyRepository;
import com.kursanov.crud_lms.server.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {


    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }



    @Override
    public Company updateCompany(Long id, Company newCompany) {
        Company company = findById(id).get();
        company.setCompanyName(newCompany.getCompanyName());
        company.setLocatedCounty(newCompany.getLocatedCounty());
        return companyRepository.save(company);
    }



    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

}