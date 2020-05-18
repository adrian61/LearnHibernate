package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "youtube_channel")
	String youtubeChannel;

	@Column(name ="hobby")
	String hobby;

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	public InstructorDetail(){}

	@Override
	public String toString() {
		return "InstructorDetail{" +
				"id=" + id +
				", youtubeChannel='" + youtubeChannel + '\'' +
				", hobby='" + hobby + '\'' +
				'}';
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}