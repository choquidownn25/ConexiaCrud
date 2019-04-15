package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.DetalleFactura;

import com.programmingfree.service.IDetalleFactura;
import com.programmingfree.utility.DBUtility;

public class CrudDetalleFactura implements IDetalleFactura{

	private Connection connection;

	public CrudDetalleFactura() {
		connection = DBUtility.getConnection();
	}
	@Override
	public List<DetalleFactura> getDetalleFacturas() {
		// TODO Auto-generated method stub
		List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from DetalleFactura");
			while (rs.next()) {
				DetalleFactura detalleFactura = new DetalleFactura();
				detalleFactura.setIdFactura(rs.getInt("IdFactura"));
				detalleFactura.setIdDetalleFactura(rs.getInt("IdDetalleFactura"));
				detalleFactura.setIdCocinero(rs.getInt("IdCocinero"));		
				detalleFactura.setIdCocinero(rs.getInt("Importe"));
				detalleFactura.setPlato(rs.getString("Plato"));
			
				detalleFacturas.add(detalleFactura);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleFacturas;
	}

	@Override
	public DetalleFactura getDetalleFacturaById(int id) {
		// TODO Auto-generated method stub
		DetalleFactura detalleFactura = new DetalleFactura();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from DetalleFactura where IdDetalleFactura=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				detalleFactura.setIdFactura(rs.getInt("IdFactura"));
				detalleFactura.setIdDetalleFactura(rs.getInt("IdDetalleFactura"));
				detalleFactura.setIdCocinero(rs.getInt("IdCocinero"));		
				detalleFactura.setIdCocinero(rs.getInt("Importe"));
				detalleFactura.setPlato(rs.getString("Plato"));
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalleFactura;
	}

	@Override
	public DetalleFactura addNewDetalleFactura(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into DetalleFactura(IdDetalleFactura, IdFactura, IdCocinero, Plato, Importe) values (?,?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, detalleFactura.getIdFactura());
			preparedStatement.setInt(2, detalleFactura.getIdDetalleFactura());
			preparedStatement.setInt(3, detalleFactura.getIdCocinero());
			preparedStatement.setString(4, detalleFactura.getPlato());			
			preparedStatement.setInt(5, detalleFactura.getImporte());
			preparedStatement.executeUpdate();
			

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return detalleFactura;
	}

	@Override
	public DetalleFactura updateDetalleFactura(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update DetalleFactura set IdFactura=?,IdCocinero=?,Plato=?,Importe=?" +
							"where IdDetalleFactura=?");
			// Parameters start with 1			
			preparedStatement.setInt(1, detalleFactura.getIdFactura());
			preparedStatement.setInt(2, detalleFactura.getIdDetalleFactura());
			preparedStatement.setInt(3, detalleFactura.getIdCocinero());
			preparedStatement.setString(4, detalleFactura.getPlato());			
			preparedStatement.setInt(5, detalleFactura.getImporte());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalleFactura;
	}

	@Override
	public void deleteDetalleFactura(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from DetalleFactura where IdDetalleFactura=?");
			// Parameters start with 1
			preparedStatement.setInt(1, detalleFactura.getIdDetalleFactura());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
