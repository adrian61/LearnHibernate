package org.example;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernateOneToOne.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 9);
			//to check eager or lazy use debug code.
			// console if lazy
			// Hibernate: select instructor0_.id as id1_1_0_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, instructor1_.id as id1_2_1_, instructor1_.hobby as hobby2_2_1_, instructor1_.youtube_channel as youtube_3_2_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?

			//System.out.println(tempInstructor.getCourseList());
			// added if lazy
			//Hibernate: select courselist0_.instructor_id as instruct3_0_0_, courselist0_.id as id1_0_0_, courselist0_.id as id1_0_1_, courselist0_.instructor_id as instruct3_0_1_, courselist0_.title as title2_0_1_ from course courselist0_ where courselist0_.instructor_id=?

			session.getTransaction().commit();

			// Uncomment to test lazy loading after close session.
			System.out.println(tempInstructor.getCourseList());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
