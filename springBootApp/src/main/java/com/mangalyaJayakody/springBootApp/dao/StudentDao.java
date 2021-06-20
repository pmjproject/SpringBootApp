package com.mangalyaJayakody.springBootApp.dao;

import com.mangalyaJayakody.springBootApp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    void saveStudent(Student student);

    List<Student> getStudents();

    void updateStudent(Student newStudentData);

    void deleteStudent(Integer id);

    Optional<Student> getStudentByID(Integer id);
}
