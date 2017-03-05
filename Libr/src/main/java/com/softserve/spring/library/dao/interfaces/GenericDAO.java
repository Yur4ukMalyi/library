package com.softserve.spring.library.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E,T extends Serializable> {

	public void addElement(E element);
    public void updateElement(E element);
    public E getElementByID(T elementId);
    public List<E> getAllElements();
    public void deleteElement(E element);

}
