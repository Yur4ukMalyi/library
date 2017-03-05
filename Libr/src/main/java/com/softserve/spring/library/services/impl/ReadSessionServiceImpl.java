package com.softserve.spring.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.spring.library.dao.interfaces.ReadSessionDAO;
import com.softserve.spring.library.entity.ReadSession;
import com.softserve.spring.library.services.ReadSessionService;

@Service
public class ReadSessionServiceImpl implements ReadSessionService {
	
	@Autowired
	ReadSessionDAO readSessionDAO;

	public void addReadSession(ReadSession readSession){
		readSessionDAO.addElement(readSession);
	}
	
	public void updateReadSession(ReadSession readSession){
		readSessionDAO.updateElement(readSession);
	}
	
	public ReadSession getReadSessionById(Integer id){
		return readSessionDAO.getElementByID(id);
	}
	
	public void deleteReadSession(ReadSession readSession){
		readSessionDAO.deleteElement(readSession);
	}
	
	public List<ReadSession> getAllReadSessions() {
		return readSessionDAO.getAllElements();
	}

}

