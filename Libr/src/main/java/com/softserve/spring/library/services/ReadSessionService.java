package com.softserve.spring.library.services;

import java.util.List;

import com.softserve.spring.library.entity.ReadSession;

public interface ReadSessionService {

	public void addReadSession(ReadSession readSession);
	
	public void updateReadSession(ReadSession readSession);
	
	public ReadSession getReadSessionById(Integer id);
	
	public void deleteReadSession(ReadSession readSession);
	
	public List<ReadSession> getAllReadSessions();
}
