package com.mangalyaJayakody.springBootApp.service;

import com.mangalyaJayakody.springBootApp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    String saveStudent(Student studentData);

    List<Student> findAllStudents();

    String updateStudent(Student newStudentData);

    String deleteStudent(Integer id);

    Optional<Student> getStudentByID(Integer id);
}
