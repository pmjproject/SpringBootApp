package com.mangalyaJayakody.springBootApp.service.serviceImpl;

import com.mangalyaJayakody.springBootApp.dao.StudentDao;
import com.mangalyaJayakody.springBootApp.model.Student;
import com.mangalyaJayakody.springBootApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public String saveStudent(Student studentData) {
        studentDao.saveStudent(studentData);
        return "Data Saved";
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> allstudents = studentDao.getStudents();
        return allstudents;
    }

    @Override
    public String updateStudent(Student newStudentData) {
        String msg = null;
        if (newStudentData.getId() != 0) {
            studentDao.updateStudent(newStudentData);
            msg = "Updated";
        } else {
            msg = "error";
        }

        return msg;
    }

    @Override
    public void findById(Integer id) {
//        return studentDao.findByIdStudent(Id);
    }
}
