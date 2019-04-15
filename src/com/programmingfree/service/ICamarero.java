package com.programmingfree.service;

import java.util.List;

import com.programmingfree.model.Camarero;


public interface ICamarero {
	public List<Camarero> getCamareros();
	public Camarero getCocineroById(int id);
	public Camarero addNewCamarero(Camarero camarero);
	public Camarero updateCamarero(Camarero camarero);
	public void deleteCamarero(Camarero camarero);
}
