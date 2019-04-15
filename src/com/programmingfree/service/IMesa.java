package com.programmingfree.service;

import java.util.List;
import com.programmingfree.model.*;

public interface IMesa {
	public List<Mesa> getMesas();
	public Mesa getMesaById(int id);
	public Mesa addNewMesa(Mesa mesa);
	public Mesa updateMesa(Mesa mesa);
	public void deleteMesa(Mesa mesa);
}
