package com.mangalyaJayakody.springBootApp.controller;


import com.mangalyaJayakody.springBootApp.model.Student;
import com.mangalyaJayakody.springBootApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/all")
    public List<Student> allStudent() {
        return studentService.findAllStudents();
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student studentData) {
        return studentService.saveStudent(studentData);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student newStudentData) {
        return studentService.updateStudent(newStudentData);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("findById/{Id}")
    public Optional<Student> getStudentByID(@PathVariable Integer Id) {
        return studentService.getStudentByID(Id);
    }


}
