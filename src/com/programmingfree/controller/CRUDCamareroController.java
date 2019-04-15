package com.programmingfree.controller;

import java.io.IOException;
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
import com.programmingfree.dao.CrudCamarero;

import com.programmingfree.model.Camarero;

import com.programmingfree.model.User;

public class CRUDCamareroController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CrudCamarero dao;
    
    public CRUDCamareroController() {
        dao=new CrudCamarero();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Camarero> lstUser=new ArrayList<Camarero>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstUser=dao.getCamareros();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<User>>() {}.getType());
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
				Camarero user=new Camarero();
				if(request.getParameter("IdCamarero")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("IdCamarero"));
				   user.setIdCamarero(userid);
				}
				if(request.getParameter("Nombre")!=null){
					String numMaxComensaja=(String)request.getParameter("Nombre");
					user.setNombre(numMaxComensaja);
				}
				if(request.getParameter("Apellido1")!=null){
				   String ubicacion=(String)request.getParameter("Apellido1");
				   user.setApellido1(ubicacion);
				}
				if(request.getParameter("Apellido2")!=null){
					   String ubicacion=(String)request.getParameter("Apellido2");
					   user.setApellido2(ubicacion);
					}
			
				try{											
					if(action.equals("create")){//Create new record
						dao.addNewCamarero(user);					
						lstUser.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateCamarero(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					Camarero user=new Camarero();
					if(request.getParameter("IdCocinero")!=null){
						String userid=(String)request.getParameter("IdCocinero");
						dao.deleteCamarero(user);
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
