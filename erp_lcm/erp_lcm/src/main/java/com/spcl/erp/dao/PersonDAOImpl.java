
package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spcl.erp.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = sessionFactory.openSession();
		session.save(p);
		logger.info("Person saved successfully, Person Details="+p);
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void updatePerson(Person p) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(p);
			tx.commit();
			session.close();
			logger.info("Person updated successfully, Person Details="+p);
			}
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = sessionFactory.openSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = sessionFactory.openSession();	
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			Person p = (Person) session.load(Person.class, new Integer(id));
			if(null != p){
				session.delete(p);
				tx.commit();
				session.close();
				logger.info("Person deleted successfully, person details="+p);
			}
		 }
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		
	}

}
