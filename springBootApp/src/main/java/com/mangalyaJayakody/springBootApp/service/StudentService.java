package com.mangalyaJayakody.springBootApp.service;

import com.mangalyaJayakody.springBootApp.model.Student;

import java.util.List;

public interface StudentService {

    String saveStudent(Student studentData);

    List<Student> findAllStudents();

    String updateStudent(Student newStudentData);

    void findById(Integer id);
}
