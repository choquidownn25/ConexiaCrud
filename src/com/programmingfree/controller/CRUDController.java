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
import com.programmingfree.dao.CrudDao;
import com.programmingfree.dao.CrudMesa;
import com.programmingfree.model.Mesa;
import com.programmingfree.model.User;


public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudMesa dao;
    
    public CRUDController() {
        dao=new CrudMesa();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<Mesa> lstUser=new ArrayList<Mesa>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstUser=dao.getMesas();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<Mesa>>() {}.getType());
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
				Mesa user=new Mesa();
				if(request.getParameter("IdMesa")!=null){				   
				   int userid=Integer.parseInt(request.getParameter("IdMesa"));
				   user.setIdMesa(userid);
				}
				if(request.getParameter("NumMaxComensaja")!=null){
					int numMaxComensaja=Integer.parseInt(request.getParameter("NumMaxComensaja"));
					user.setNumMaxComensaja(numMaxComensaja);
				}
				if(request.getParameter("Ubicacion")!=null){
				   String ubicacion=(String)request.getParameter("Ubicacion");
				   user.setUbicacion(ubicacion);
				}
			
				try{											
					if(action.equals("create")){//Create new record
						dao.addNewMesa(user);					
						lstUser.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateMesa(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					Mesa user=new Mesa();
					if(request.getParameter("userid")!=null){
						String userid=(String)request.getParameter("userid");
						dao.deleteMesa(user);
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
