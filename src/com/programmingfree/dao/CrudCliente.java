package com.programmingfree.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.programmingfree.model.Cliente;
import com.programmingfree.service.*;
import com.programmingfree.utility.DBUtility;

public class CrudCliente implements ICliente {

	private Connection connection;

	public CrudCliente() {
		connection = DBUtility.getConnection();
	}
	
	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Cliente");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("IdCliente"));
				cliente.setNombre(rs.getString("Nombre"));
				cliente.setApellido1(rs.getString("Apellido1"));		
				cliente.setApellido2(rs.getString("Apellido2"));	
				cliente.setObservaciones(rs.getString("Observaciones"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clientes;
	}

	@Override
	public Cliente getUserById(int id) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Cliente where IdCliente=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				cliente.setIdCliente(rs.getInt("IdCliente"));
				cliente.setNombre(rs.getString("Nombre"));
				cliente.setApellido1(rs.getString("Apellido1"));
				cliente.setApellido2(rs.getString("Apellido2"));
				cliente.setObservaciones(rs.getString("Observaciones"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente addNewUser(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Cliente set Nombre=?,Apellido1=?,Apellido2=?,Observaciones=?" +
							"where IdCliente=?");
			// Parameters start with 1		
			preparedStatement.setString(1, cliente.getObservaciones());
			preparedStatement.setString(2, cliente.getApellido1());
			preparedStatement.setString(3, cliente.getNombre());
			preparedStatement.setString(4, cliente.getApellido2());
			preparedStatement.setInt(5, cliente.getIdCliente());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Camarero where IdCamarero=?");
			// Parameters start with 1
			preparedStatement.setInt(1, cliente.getIdCliente());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
