package org.example;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class OneToManyApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernateOneToOne.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		List<Course>courseList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			courseList.add(new Course("c"+i));
		}


		try {

			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class,9);
			for (Course c : courseList) {
				instructor.add(c);
				session.save(c);
			}

//			List<Course> courseList = session.createQuery("from Course ").getResultList();
//			for (Course c :
//					courseList) {
//				session.remove(c);
//			}
//			System.out.println(instructor.toString());
			session.getTransaction().commit();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}


	}
}
