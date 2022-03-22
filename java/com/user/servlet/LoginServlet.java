package com.user.servlet;

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

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
			HttpSession session=req.getSession();
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				ItemDetails us=new ItemDetails();
				session.setAttribute("userobj",us);
				resp.sendRedirect("admin/home.jsp");
				
			}else {
				ItemDetails us=dao.login(email, password);
				if(us!=null)
				{
					session.setAttribute("userobj", us);
					resp.sendRedirect("home.jsp");
				}else {

					session.setAttribute("failedMsg","Email & Password Invalid");
					resp.sendRedirect("login.jsp");
					
				}
			
				resp.sendRedirect("home.jsp");
				}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
