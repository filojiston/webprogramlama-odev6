package helpers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserController {
	// we add SuppressWarnings("unchecked") because if we don't 
	// allUsers = session.createQuery("from User").getResultList(); this line throws a warning
	// and asks for casting all objects to type of user manually. We don't need that.
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		List<User> allUsers = null;
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		allUsers = session.createQuery("from User").getResultList();
		transaction.commit();
		
		return allUsers;
		
	}
	
	public User getOne(int id) {
		User user = null;
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		user = session.get(User.class, id);
		transaction.commit();
		
		return user;
		
	}
	
	public void addOne(User user) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(user);
		transaction.commit();
		
	}
	
	public void updateOne(User user) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(user);
		transaction.commit();
	}
	
	public void deleteOne(int id) {
		Transaction transaction = null;
		
		Session session = Hibernate.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		User user = session.get(User.class, id);
		if (user != null) 	session.delete(user);
		transaction.commit();
			
	}

}
