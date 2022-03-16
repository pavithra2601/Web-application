package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.DAO.itemDAOImpl;
import com.DB.DBConnect;
import com.entity.ItemDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
@WebServlet("/addItems")
@MultipartConfig

public class addItems extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			
			String ItemName=req.getParameter("itemname");
			String price=req.getParameter("price");
			String status=req.getParameter("status");
			Part part=req.getPart("image");
			String fileName=part.getSubmittedFileName();
			String ItemCategory=req.getParameter("ItemCategory");
			ItemDetails I=new ItemDetails(ItemName,price,status,fileName,ItemCategory,"admin");
			
			
			
			
			itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
			
	
			
			boolean f=dao.addItems(I);
			HttpSession session=req.getSession();
			if(f) {
				String path=getServletContext().getRealPath("")+ "items";
				
				File file=new File(path);
				
				part.write(path + File.separator + fileName);
				
				
				
				session.setAttribute("succMsg","Item Add sucessfully");
				resp.sendRedirect("admin/add_items.jsp");
			}else {
				session.setAttribute("failedMsg","Something wrong on Server");
				resp.sendRedirect("admin/add_items.jsp");
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
