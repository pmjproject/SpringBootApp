package com.mangalyaJayakody.springBootApp.dao.impl;

import java.util.List;
import java.util.Optional;

import com.mangalyaJayakody.springBootApp.dao.StudentDao;
import com.mangalyaJayakody.springBootApp.model.Student;
import com.mangalyaJayakody.springBootApp.config.HibernateConfig;
import org.hibernate.Hibernate;
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
            // update the student object
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

    @Override
    public void deleteStudent(Integer id) {
        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a persistent object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
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
    public Optional<Student> getStudentByID(Integer id) {
        return Optional.empty();
    }


    public List<Student> getStudents() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
