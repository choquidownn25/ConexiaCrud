package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.programmingfree.model.Factura;
import com.programmingfree.service.*;
import com.programmingfree.utility.DBUtility;
public class CrudFactura implements IFactura{

	private Connection connection;

	public CrudFactura() {
		connection = DBUtility.getConnection();
	}
	
	@Override
	public List<Factura> getFacturas() {
		// TODO Auto-generated method stub
		List<Factura> facturas = new ArrayList<Factura>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Factura");
			while (rs.next()) {
				Factura factura = new Factura();
				factura.setIdFactura(rs.getInt("IdFactura"));
				factura.setIdCliente(rs.getInt("IdCliente"));
				factura.setIdMesa(rs.getInt("IdMesa"));		
				factura.setFechaFactura(rs.getDate("FechaFactura"));
			
				facturas.add(factura);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return facturas;
	}

	@Override
	public Factura getFacturaById(int id) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Factura where IdFactura=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				factura.setIdFactura(rs.getInt("IdFactura"));
				factura.setIdCliente(rs.getInt("IdCliente"));
				factura.setIdCliente(rs.getInt("IdCliente"));
				factura.setIdMesa(rs.getInt("IdMesa"));		
				factura.setFechaFactura(rs.getDate("FechaFactura"));
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factura;
	}

	@Override
	public Factura addNewFactura(Factura factura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Camarero(IdCamarero, Nombre, Apellido1, Apellido2) values (?,?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, factura.getIdFactura());
			preparedStatement.setInt(2, factura.getIdCliente());
			preparedStatement.setInt(3, factura.getIdCamarero());
			preparedStatement.setInt(4, factura.getIdMesa());			
			preparedStatement.setDate(5, factura.getFechaFactura());
			preparedStatement.executeUpdate();
			

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return factura;
	}

	@Override
	public Factura updateFactura(Factura factura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Factura set FechaFactura=?,IdMesa=?,IdCamarero=?,IdCliente=?" +
							"where IdFactura=?");
			// Parameters start with 1			
			preparedStatement.setDate(1, factura.getFechaFactura());
			preparedStatement.setInt(2, factura.getIdMesa());
			preparedStatement.setInt(3, factura.getIdCamarero());
			preparedStatement.setInt(4, factura.getIdCliente());
			preparedStatement.setInt(5, factura.getIdFactura());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factura;
	}

	@Override
	public void deleteFactura(Factura factura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Mesa where IdMesa=?");
			// Parameters start with 1
			preparedStatement.setInt(1, factura.getIdFactura());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
