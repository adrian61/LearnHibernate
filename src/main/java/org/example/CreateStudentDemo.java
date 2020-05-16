package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            Student newStudent = new Student("Paul", "Wall", "email");
//            Student newStudent2 = new Student("Pasul", "Wasll", "emasil");
//            Student newStudent3 = new Student("Paaul", "Waldl", "emaail");

            session.beginTransaction();
//            session.save(newStudent);
//            session.save(newStudent2);
//            session.save(newStudent3);
            Student student = session.get(Student.class, 1);

            List studentList = session.createQuery("from Student s where s.id > 1").getResultList();
            System.out.println(student.toString());

            student.setFirstName("newVal");
            System.out.println(student.toString());
            System.out.println(studentList.toString());

            Student student2 = session.get(Student.class, 2);
            session.delete(student2); // session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
