package com.mangalyaJayakody.springBootApp.dao.impl;

import java.util.List;

import com.mangalyaJayakody.springBootApp.dao.StudentDao;
import com.mangalyaJayakody.springBootApp.model.Student;
import com.mangalyaJayakody.springBootApp.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDaoImpl implements StudentDao {
    public void saveStudent(Student student) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Override
    public void updateStudent(Student newStudentData) {
        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(newStudentData);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Student> getStudents() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
