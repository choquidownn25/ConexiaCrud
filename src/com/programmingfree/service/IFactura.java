package com.programmingfree.service;

import java.util.List;

import com.programmingfree.model.Factura;

public interface IFactura {

	public List<Factura> getFacturas();
	public Factura getFacturaById(int id);
	public Factura addNewFactura(Factura factura);
	public Factura updateFactura(Factura factura);
	public void deleteFactura(Factura factura);
}
