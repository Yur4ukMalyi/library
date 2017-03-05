package com.softserve.spring.library.dao.impl;

import com.softserve.spring.library.entity.ReadSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.dao.interfaces.ReadSessionDAO;

@Repository
@Transactional
public class ReadSessionDAOImpl extends GenericDAOImpl<ReadSession, Integer> implements ReadSessionDAO {

	public ReadSessionDAOImpl() {
		super(ReadSession.class);
	}

	public ReadSessionDAOImpl(Class<ReadSession> genericClass) {
		super(genericClass);
		// TODO Auto-generated constructor stub
	}

}
