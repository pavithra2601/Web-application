package com.DAO;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.ItemDetails;
 public class itemDAOImpl implements itemDAO{
	 private Connection conn;

	public itemDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegister(ItemDetails us) {
		boolean f=false;
		try {
			String sql="insert into new_table(name,email,phno,password)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(1, us.getemail());
			ps.setString(1, us.getPhno());
			ps.setString(1, us.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	
	public ItemDetails login(String email,String password) {
		ItemDetails us=null;

	try {
		String sql="select * from user where email=? and password=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			us=new ItemDetails();
			us.setId(rs.getInt(1));
			us.setName(rs.getString(2));
			us.setemail(rs.getString(3));
			us.setPhno(rs.getString(4));
			us.setPassword(rs.getString(5));
			us.setAddress(rs.getString(6));
			us.setLandmark(rs.getString(7));
			us.setCity(rs.getString(8));
			us.setState(rs.getString(9));
			us.setPincode(rs.getString(10));
			
			
		}
		
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
		
		return us;
	}

	
	 
 }
	

	
	
