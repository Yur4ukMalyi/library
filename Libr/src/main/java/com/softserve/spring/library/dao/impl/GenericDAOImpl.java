 package com.softserve.spring.library.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.dao.interfaces.GenericDAO;



@Repository
@Transactional
public class GenericDAOImpl<E, T extends Serializable> implements GenericDAO<E, T> {

	 @Autowired
	 protected SessionFactory sessionFactory;
	
	private Class<E> genericClass;

	 
	public GenericDAOImpl() {
		super();
	}

	public GenericDAOImpl(Class<E> genericClass) {
		this.genericClass = genericClass;
	}

	@Override
	public void addElement(E element) {
		Session session = null;
			session = sessionFactory.getCurrentSession();
			session.save(element);
		

	}

	public void updateElement(E element) {
		Session session = null;
			session = sessionFactory.getCurrentSession();
			session.update(element);

	}

	@Override
	public E getElementByID(T elementId) {
		Session session = null;
		E element = null;
		
			session = sessionFactory.getCurrentSession();
			element = (E) session.get(genericClass, elementId);
		
		return element;

	}

	@Override
	public List<E> getAllElements() {
		Session session = null;
		List<E> elements = new ArrayList<E>();
			
			session = sessionFactory.getCurrentSession();		
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(genericClass);
			criteria.from(genericClass);
			elements = session.createQuery(criteria).getResultList();
		
		return elements;

	}

	@Override
	public void deleteElement(E element) {
		Session session = null;
			session = sessionFactory.getCurrentSession();
			session.delete(element);
	}



}
