package com.programmingfree.model;

import java.sql.Date;



public class Factura {

	private int IdFactura;
	private int IdCliente;
	private int IdCamarero;
	private int IdMesa;
	private Date FechaFactura;
	public int getIdFactura() {
		return IdFactura;
	}
	public void setIdFactura(int idFactura) {
		IdFactura = idFactura;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public int getIdCamarero() {
		return IdCamarero;
	}
	public void setIdCamarero(int idCamarero) {
		IdCamarero = idCamarero;
	}
	public int getIdMesa() {
		return IdMesa;
	}
	public void setIdMesa(int idMesa) {
		IdMesa = idMesa;
	}
	public Date getFechaFactura() {
		return FechaFactura;
	}
	public void setFechaFactura(Date date) {
		FechaFactura = date;
	}
	
	
}
