package com.java.hibernate.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import com.java.hibernate.entity.Message;
import com.java.hibernate.util.HibernateUtil;

@Path("/persist")
public class MessageService {

	@GET
	@Path("{message}")
	public Response persistMessageinDB(@PathParam("message") String message) {
        persistMessage(message);
		return Response.status(200).entity("persistMessageinDB :: message persisted successfully " + message)
				.build();

	}
	public void persistMessage(String lmessage){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message = new Message(lmessage);
		session.save(message);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully Completed");
	}

	
	
}