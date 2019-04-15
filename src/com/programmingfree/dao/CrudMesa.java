package com.programmingfree.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.programmingfree.utility.DBUtility;
import com.programmingfree.model.Mesa;
import com.programmingfree.service.IMesa;


public class CrudMesa implements IMesa{

	
	private Connection connection;

	public CrudMesa() {
		connection = DBUtility.getConnection();
	}

	@Override
	public  List<Mesa> getMesas() {
		List<Mesa> mesas = new ArrayList<Mesa>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Mesa");
			while (rs.next()) {
				Mesa mesa = new Mesa();
				mesa.setIdMesa(rs.getInt("idMesa"));
				mesa.setNumMaxComensaja(rs.getInt("NumMaxComensaja"));
				mesa.setUbicacion(rs.getString("lastname"));			
			
				mesas.add(mesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mesas;
	}

	@Override
	public Mesa getMesaById(int id) {
		
		Mesa mesa = new Mesa();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Mesa where IdMesa=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				mesa.setIdMesa(rs.getInt("IdMesa"));
				mesa.setNumMaxComensaja(rs.getInt("NumMaxComensaja"));
				mesa.setUbicacion(rs.getString("Ubicacion"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesa;
	}

	@Override
	public Mesa addNewMesa(Mesa mesa) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Mesa(IdMesa, NumMaxComensaja, Ubicacion) values (?,?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, mesa.getIdMesa());
			preparedStatement.setInt(2, mesa.getNumMaxComensaja());
			preparedStatement.setString(3, mesa.getUbicacion());			
			
			preparedStatement.executeUpdate();
			

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mesa;
	}

	@Override
	public Mesa updateMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Mesa set NumMaxComensaja=?,Ubicacion=?" +
							"where IdMesa=?");
			// Parameters start with 1			
			preparedStatement.setString(1, mesa.getUbicacion());
			preparedStatement.setInt(2, mesa.getNumMaxComensaja());			
			preparedStatement.setInt(3, mesa.getIdMesa());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesa;
	}

	@Override
	public void deleteMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Mesa where IdMesa=?");
			// Parameters start with 1
			preparedStatement.setInt(1, mesa.getIdMesa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
