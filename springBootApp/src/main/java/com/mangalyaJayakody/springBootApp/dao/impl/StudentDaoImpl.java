package com.mangalyaJayakody.springBootApp.dao.impl;

import com.mangalyaJayakody.springBootApp.config.HibernateConfig;
import com.mangalyaJayakody.springBootApp.dao.StudentDao;
import com.mangalyaJayakody.springBootApp.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class StudentDaoImpl implements StudentDao {
    public void saveStudent(Student student) {
        log.info("============Log start for saving student===========================");
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(student);
            log.info("============Saved ===========================");
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
        log.info("============Log end for saving student ===========================");
    }

    @Override
    public void updateStudent(Student newStudentData) {
        log.info("============Log start for updating student ===========================");
        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // update the student object
            if (newStudentData != null) {
                session.update(newStudentData);
                log.info("============Updated===========================");
            } else {
                log.info("============Update is not successful==========================");
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
        log.info("============Log end for updating student ===========================");
    }

    @Override
    public void deleteStudent(Integer id) {
        log.info("============Log start for deleting student ===========================");
        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a persistent object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                log.info("============Deleted ===========================");
            } else {
                log.info("============student is not exist===========================");
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
        log.info("============Log end for deleting student ===========================");
    }

    @Override
    public Optional<Student> getStudentByID(Integer id) {
        log.info("============Log start for getting student by ID ===========================");
        Transaction transaction = null;
        Student student = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // get Student entity using get() method
            if (id != null) {
                student = session.get(Student.class, id);
            } else {
                log.info("============Student is not exist  ===========================");
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
        log.info("============Log end for getting student by ID ===========================");
        return Optional.of(student);

    }

    public List<Student> getStudents() {
        log.info("============Log start for getting all students ===========================");
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            log.info("============Log end for getting all students ===========================");
            return session.createQuery("from Student", Student.class).list();
        }

    }
}
