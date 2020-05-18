package org.example;

import org.example.entity.Instructor;
import org.example.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {
	public static void main(String[] args) {
		Instructor instructor = new Instructor("a", "b", "c");
		InstructorDetail instructorDetail2 = new InstructorDetail("a", "d");

		instructor.setInstructorDetail(instructorDetail2);
		SessionFactory sessionFactory = new Configuration().configure("hibernateOneToOne.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();
			session.save(instructor);
			Instructor newInstructor = session.get(Instructor.class, 9);
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 9);
			// delete all records
//		List<Instructor> instructorList = session.createQuery("from Instructor ").getResultList();
//		for (Instructor instructor1 :
//				instructorList) {
//			session.remove(instructor1);
//		}

			session.remove(session.get(Instructor.class,10));
			session.getTransaction().commit();
			InstructorDetail instructorDetail1 = newInstructor.getInstructorDetail();
			System.out.println(instructorDetail == instructorDetail1);
			System.out.println(newInstructor);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
