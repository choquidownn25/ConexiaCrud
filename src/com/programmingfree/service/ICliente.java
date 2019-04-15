package com.programmingfree.service;

import java.util.List;

import com.programmingfree.model.Cliente;

public interface ICliente {

	public List<Cliente> getClientes();
	public Cliente getUserById(int id);
	public Cliente addNewUser(Cliente cliente);
	public Cliente updateCliente(Cliente cliente);
	public void deleteCliente(Cliente cliente);
}
