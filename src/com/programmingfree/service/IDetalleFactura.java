package com.programmingfree.service;

import java.util.List;

import com.programmingfree.model.DetalleFactura;


public interface IDetalleFactura {
	public List<DetalleFactura> getDetalleFacturas();
	public DetalleFactura getDetalleFacturaById(int id);
	public DetalleFactura addNewDetalleFactura(DetalleFactura detalleFactura);
	public DetalleFactura updateDetalleFactura(DetalleFactura detalleFactura);
	public void deleteDetalleFactura(DetalleFactura detalleFactura);
}
