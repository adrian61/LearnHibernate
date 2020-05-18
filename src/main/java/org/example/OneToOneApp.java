package org.example;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToOneApp {
	public static void main(String[] args) {
		Instructor instructor = new Instructor("a", "b", "c");
		InstructorDetail instructorDetail = new InstructorDetail("a", "d");

		instructor.setInstructorDetail(instructorDetail);
		SessionFactory sessionFactory = new Configuration().configure("hibernateOneToOne.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.save(instructor);
		Instructor newInstructor = session.get(Instructor.class, 1);
		// delete all records
//		List<Instructor> instructorList = session.createQuery("from Instructor ").getResultList();
//		for (Instructor instructor1 :
//				instructorList) {
//			session.remove(instructor1);
//		}
		session.getTransaction().commit();
		InstructorDetail instructorDetail1 = newInstructor.getInstructorDetail();
		System.out.println(newInstructor);
	}
}
