package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.programmingfree.model.Cocinero;
import com.programmingfree.service.ICocinero;
import com.programmingfree.utility.DBUtility;

public class CrudCocinero implements ICocinero{

	private Connection connection;

	public CrudCocinero() {
		connection = DBUtility.getConnection();
	}
	
	@Override
	public List<Cocinero> getCocineros() {
		// TODO Auto-generated method stub
		List<Cocinero> cocineros = new ArrayList<Cocinero>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Cocinero");
			while (rs.next()) {
				Cocinero cocinero = new Cocinero();
				cocinero.setIdCocinero(rs.getInt("IdCocinero"));
				cocinero.setNombre(rs.getString("Nombre"));
				cocinero.setApellido1(rs.getString("Apellido1"));		
				cocinero.setApellido2(rs.getString("Apellido2"));	
			
				cocineros.add(cocinero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cocineros;
	}

	@Override
	public Cocinero getCocineroById(int id) {
		// TODO Auto-generated method stub
		Cocinero cocinero = new Cocinero();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Cocinero where IdCocinero=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				cocinero.setIdCocinero(rs.getInt("IdCocinero"));
				cocinero.setNombre(rs.getString("Nombre"));
				cocinero.setApellido1(rs.getString("Apellido1"));
				cocinero.setApellido2(rs.getString("Apellido2"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cocinero;
	}

	@Override
	public Cocinero addNewCocinero(Cocinero cocinero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Cocinero(IdCocinero, Nombre, Apellido1, Apellido2) values (?,?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, cocinero.getIdCocinero());
			preparedStatement.setString(2, cocinero.getNombre());
			preparedStatement.setString(3, cocinero.getApellido1());			
			preparedStatement.setString(4, cocinero.getApellido2());
			preparedStatement.executeUpdate();
			

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cocinero;
	}

	@Override
	public Cocinero updateCocinero(Cocinero cocinero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Camarero set Nombre=?,Apellido1=?,Apellido2=?" +
							"where IdCocinero=?");
			// Parameters start with 1			
			preparedStatement.setString(1, cocinero.getApellido1());
			preparedStatement.setString(2, cocinero.getNombre());
			preparedStatement.setString(3, cocinero.getApellido2());
			preparedStatement.setInt(4, cocinero.getIdCocinero());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cocinero;
	}

	@Override
	public void deleteCocinero(Cocinero cocinero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Cocinero where IdCocinero=?");
			// Parameters start with 1
			preparedStatement.setInt(1, cocinero.getIdCocinero());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
