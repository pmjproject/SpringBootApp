package com.mangalyaJayakody.springBootApp;

import com.mangalyaJayakody.springBootApp.dao.impl.StudentDaoImpl;
import com.mangalyaJayakody.springBootApp.model.Student;

import java.util.List;


public class App {
    public static void main(String[] args) {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        studentDaoImpl.saveStudent(new Student());

        List <Student> students = studentDaoImpl.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
    }
}
