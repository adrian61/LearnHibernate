package org.example.entity;

import javax.persistence.*;
@Entity
@Table(name = "course")
public class Course {
	// id title instuctor id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course(String title) {
		this.title = title;
	}

	public Course() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course{" +
				"title='" + title + '\'' +
				'}';
	}
}
