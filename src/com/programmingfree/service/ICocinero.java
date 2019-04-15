package com.programmingfree.service;

import java.util.List;

import com.programmingfree.model.Cocinero;


public interface ICocinero {
	public List<Cocinero> getCocineros();
	public Cocinero getCocineroById(int id);
	public Cocinero addNewCocinero(Cocinero cocinero);
	public Cocinero updateCocinero(Cocinero cocinero);
	public void deleteCocinero(Cocinero cocinero);
}
