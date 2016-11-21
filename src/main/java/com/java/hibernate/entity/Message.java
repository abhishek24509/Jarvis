package com.java.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/course/242180/activities/?ids=2594248
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "message_seq")
	private Long id;
	

	@Column(name="TEXT")	
	private String text;
	
	public Message() {}
	public Message(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}	
	
}












