package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ItemDetails;

public class itemDAOImpl implements itemDAO {
	
	private static final ArrayList<ItemDetails> Arraylist = null;
	private Connection conn;
    public itemDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addItems(ItemDetails I) {
		boolean f=false;
		try {
			String sql="insert into new_table(itemname,price,status,email,photo) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,I.getItemName() );
			ps.setString(2,I.getPrice());
			ps.setString(3,I.getStatus() );
			ps.setString(4,I.getEmail());
			ps.setString(5,I.getPhotoName());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return f;
	}

	public List<ItemDetails> getAllItems() {
		List<ItemDetails> list=new ArrayList<ItemDetails>();
		ItemDetails I=null;
		
		try {
			String sql="select* from new_table";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				I=new ItemDetails();
				I.setItemId(rs.getInt(1));
				I.setItemName(rs.getString(2));
				I.setPrice(rs.getString(3));
				I.setStatus(rs.getString(4));
				I.setEmail(rs.getString(5));
				I.setPhotoName(rs.getString(6));
				list.add(I);
				
				
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	
		return list;
	}

	
	public ItemDetails getItemByID(int id) {
		ItemDetails I=null;
		try {
			String sql="select * from new_table where id";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				I=new ItemDetails();
				I.setItemId(rs.getInt(1));
				I.setItemName(rs.getString(2));
				I.setPrice(rs.getString(3));
				I.setStatus(rs.getString(4));
				I.setEmail(rs.getString(5));
				I.setPhotoName(rs.getString(6));
			}
			}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return I;
	}

	
	public boolean updateEditItems(ItemDetails I) {
		boolean f=false;
		try {
			String sql="update new_table set itemname=?,price=?,status=? where Id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,I.getItemName());
			ps.setString(2,I.getPrice());
			ps.setString(3,I.getStatus());
			ps.setInt(5,I.getItemId() );
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
			
		}catch(Exception e) {
			
		}
	
		return f;
	}

	
	public boolean deleteItems(int id) {
		boolean f=false;
		try {
			String sql="delete from new_table where Id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	
	public List<ItemDetails> getCakeItems() {
		List<ItemDetails> list =new ArrayList<ItemDetails>();
		ItemDetails I=null;
		try {
			String sql="select * from new_table where status=? order by Id DESC ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,"Active" );
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				I=new ItemDetails();
				I.setItemId(rs.getInt(1));
				I.setItemName(rs.getString(2));
				I.setPrice(rs.getString(3));
				I.setStatus(rs.getString(4));
				I.setEmail(rs.getString(5));
				I.setPhotoName(rs.getString(6));
				list.add(I);
				i++;
			}
}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return list;
	}

	
	public List<ItemDetails> getDesignerItems() {
		List<ItemDetails> list =new ArrayList<ItemDetails>();
		ItemDetails I=null;
		try {
			String sql="select * from new_table where status=? order by Id DESC ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,"New" );
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next() && i<=4) {
				I=new ItemDetails();
				I.setItemId(rs.getInt(1));
				I.setItemName(rs.getString(2));
				I.setPrice(rs.getString(3));
				I.setStatus(rs.getString(4));
				I.setEmail(rs.getString(5));
				I.setPhotoName(rs.getString(6));
				list.add(I);
				i++;
			}
}catch(Exception e) {
			e.printStackTrace();
			
		}
	
		return list;
	}
	
	
	
	
	

			
	
	}

	
	

	
	
