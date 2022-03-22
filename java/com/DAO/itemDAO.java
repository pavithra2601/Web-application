package com.DAO;

import com.entity.ItemDetails;

public interface itemDAO {

	public boolean userRegister(ItemDetails us);
	
	public ItemDetails login(String email,String password);
	
	
	
	
	
}
