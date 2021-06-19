package com.mangalyaJayakody.springBootApp.controller;


import com.mangalyaJayakody.springBootApp.model.Student;
import com.mangalyaJayakody.springBootApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   /* @GetMapping("findById/{Id}")
    public Optional<Student> findById(@PathVariable Integer Id){
        return  studentService.findById(Id);
    }*/


}
