package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.Camarero;
import com.programmingfree.service.ICamarero;
import com.programmingfree.utility.DBUtility;

public class CrudCamarero implements ICamarero{

	private Connection connection;

	public CrudCamarero() {
		connection = DBUtility.getConnection();
	}
	
	@Override
	public List<Camarero> getCamareros() {
		// TODO Auto-generated method stub
		List<Camarero> camareros = new ArrayList<Camarero>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Camarero");
			while (rs.next()) {
				Camarero camarero = new Camarero();
				camarero.setIdCamarero(rs.getInt("IdCamarero"));
				camarero.setNombre(rs.getString("Nombre"));
				camarero.setApellido1(rs.getString("Apellido1"));		
				camarero.setApellido2(rs.getString("Apellido2"));	
			
				camareros.add(camarero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return camareros;
	}

	@Override
	public Camarero getCocineroById(int id) {
		// TODO Auto-generated method stub
		Camarero camarero = new Camarero();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Camarero where IdCamarero=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				camarero.setIdCamarero(rs.getInt("IdCamarero"));
				camarero.setNombre(rs.getString("Nombre"));
				camarero.setApellido1(rs.getString("Apellido1"));
				camarero.setApellido2(rs.getString("Apellido2"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camarero;
	}

	@Override
	public Camarero addNewCamarero(Camarero camarero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Camarero(IdCamarero, Nombre, Apellido1, Apellido2) values (?,?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, camarero.getIdCamarero());
			preparedStatement.setString(2, camarero.getNombre());
			preparedStatement.setString(3, camarero.getApellido1());			
			preparedStatement.setString(4, camarero.getApellido2());
			preparedStatement.executeUpdate();
			

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return camarero;
	}

	@Override
	public Camarero updateCamarero(Camarero camarero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Camarero set Nombre=?,Apellido1=?,Apellido2=?" +
							"where IdCamarero=?");
			// Parameters start with 1			
			preparedStatement.setString(1, camarero.getApellido1());
			preparedStatement.setString(2, camarero.getNombre());
			preparedStatement.setString(3, camarero.getApellido2());
			preparedStatement.setInt(4, camarero.getIdCamarero());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camarero;
	}

	@Override
	public void deleteCamarero(Camarero camarero) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Camarero where IdCamarero=?");
			// Parameters start with 1
			preparedStatement.setInt(1, camarero.getIdCamarero());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
