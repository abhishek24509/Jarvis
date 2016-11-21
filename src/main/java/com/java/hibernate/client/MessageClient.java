package com.java.hibernate.client;

import org.hibernate.Session;

import com.java.hibernate.entity.Message;
import com.java.hibernate.util.HibernateUtil;

public class MessageClient {
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = new Message("New Message inserted as "+MessageClient.class.hashCode());
		session.save(message);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully Completed");
		System.exit(0);
	}

}
