package com.mangalyaJayakody.springBootApp.dao;

import com.mangalyaJayakody.springBootApp.model.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);

    List<Student> getStudents();

    void updateStudent(Student newStudentData);
}
