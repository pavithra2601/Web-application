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
@WebServlet("/register")
public class registerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			
			//System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
			
			ItemDetails us=new ItemDetails();
			us.setName(name);
			us.setemail(email);
			us.setPhno(phno);
			us.setPassword(password);
			HttpSession session=userRegister(us);
			if(check!=null) {
			
			itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
			boolean f=dao.userRegister(us);
			if(f) {
				//System.out.println("User Register Sucess...");
				session.setAttribute("succMsg", "Registration Success");
				resp.sendRedirect("register.jsp");
			}else {
				//System.out.println("Something went wrong.....");
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("register.jsp");
			}
			}else {
				//System.out.println("Please Check Agree & Terms Condition");
				session.setAttribute("failedMsg","Please Check Agree Terms and Condition");
				resp.sendRedirect("register.jsp");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private HttpSession userRegister(ItemDetails us) {
		// TODO Auto-generated method stub
		return null;
	}

}
