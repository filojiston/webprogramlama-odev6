package com.seid.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Path("/users")
public class UserController {
	// we add SuppressWarnings("unchecked") because if we don't 
	// allUsers = session.createQuery("from User").getResultList(); this line throws a warning
	// and asks for casting all objects to type of user manually. We don't need that.
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		List<User> allUsers = null;
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		allUsers = session.createQuery("from User").getResultList();
		transaction.commit();
		
		return allUsers;
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getOne(@PathParam("id") int id) {
		User user = null;
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		user = session.get(User.class, id);
		transaction.commit();
		
		return user;
		
	}
	
	@POST
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addOne(User user) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(user);
		transaction.commit();
		
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateOne(User user) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(user);
		transaction.commit();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_XML)
	public void deleteOne(@PathParam("id") int id) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		User user = session.get(User.class, id);
		if (user != null) 	session.delete(user);
		transaction.commit();
			
	}

}
