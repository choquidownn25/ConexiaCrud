package com.programmingfree.model;

public class DetalleFactura {
	
	private int IdFactura;
	private int IdDetalleFactura;
	private int IdCocinero;
	private String Plato;
	private int Importe;
	public int getIdFactura() {
		return IdFactura;
	}
	public void setIdFactura(int idFactura) {
		IdFactura = idFactura;
	}
	public int getIdCocinerogetIdCocinerogetIdCocinero() {
		return IdDetalleFactura;
	}
	public void setIdDetalleFactura(int idDetalleFactura) {
		IdDetalleFactura = idDetalleFactura;
	}
	
	public int getIdDetalleFactura() {
		return IdDetalleFactura;
	}
	
	public int getIdCocinero() {
		return IdCocinero;
	}
	public void setIdCocinero(int idCocinero) {
		IdCocinero = idCocinero;
	}
	public String getPlato() {
		return Plato;
	}
	public void setPlato(String plato) {
		Plato = plato;
	}
	public int getImporte() {
		return Importe;
	}
	public void setImporte(int importe) {
		Importe = importe;
	}
	
	

}
