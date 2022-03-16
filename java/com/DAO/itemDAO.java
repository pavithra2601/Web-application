package com.DAO;

import java.util.List;

import com.entity.ItemDetails;

public interface itemDAO {

	public boolean addItems(ItemDetails I);
	
	public List<ItemDetails> getAllItems();
	
	public ItemDetails getItemByID(int id);
	
	public boolean updateEditItems(ItemDetails I);
	
	public boolean deleteItems( int id);
	
	public List<ItemDetails> getCakeItems();
	
	public List<ItemDetails> getDesignerItems();
	
	
	
	
}
