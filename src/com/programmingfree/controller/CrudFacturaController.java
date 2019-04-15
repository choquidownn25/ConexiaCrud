package com.programmingfree.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import com.programmingfree.dao.CrudFactura;

import com.programmingfree.model.Factura;
import com.programmingfree.model.User;

public class CrudFacturaController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private CrudFactura dao;
    
    public CrudFacturaController() {
        dao=new CrudFactura();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Factura> lstUser=new ArrayList<Factura>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstUser=dao.getFacturas();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<Factura>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Factura user=new Factura();
				if(request.getParameter("idFactura")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("idFactura"));
				   user.setIdFactura(userid);
				}
				if(request.getParameter("IdCliente")!=null){
					int idCliente=Integer.parseInt(request.getParameter("IdCliente"));

					user.setIdCliente(idCliente);
				}
				if(request.getParameter("IdMesa")!=null){
					int idMesa=Integer.parseInt(request.getParameter("IdMesa"));

				   user.setIdMesa(idMesa);
				}
				if(request.getParameter("FechaFactura")!=null){
					   Date ubicacion=Date.valueOf(request.getParameter("FechaFactura"));
					   user.setFechaFactura(ubicacion);
					}
			
				try{											
					if(action.equals("create")){//Create new record
						dao.addNewFactura(user);					
						lstUser.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateFactura(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					Factura user=new Factura();
					if(request.getParameter("IdCocinero")!=null){
						String userid=(String)request.getParameter("IdCocinero");
						dao.deleteFactura(user);
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 }
  }

	

}
