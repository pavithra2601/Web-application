package com.admin.servlet;

import java.io.IOException;

import com.DAO.itemDAOImpl;
import com.DB.DBConnect;
import com.entity.ItemDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/edititems")

public class edititemServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			int id=Integer.parseInt(req.getParameter("id"));
			String ItemName=req.getParameter("itemname");
			String price=req.getParameter("price");
			String status=req.getParameter("status");
			
			ItemDetails I=new ItemDetails();
			I.setItemId(id);
			I.setItemName(ItemName);
			I.setPrice(price);
			I.setStatus(status);
			
			itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditItems(I);
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("succMsg","Item Updated Successfull");
				resp.sendRedirect("admin/all_items.jsp");
				
			}else {
				session.setAttribute("failedMsg","Something went wrong");
				resp.sendRedirect("admin/all_items.jsp");
				
				
			}
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	
	}
}
