package com.entity;

public class  ItemDetails {
	private int ItemId;
	private String ItemName;
	private String price;
	private String status;
	private String photoName;
	private String email;
	private String ItemCategory;
	
	
	
	public ItemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDetails(String itemName, String price, String status, String photoName, String email, String ItemCategory) {
		super();
		
		ItemName = itemName;
		this.price = price;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
		this.ItemCategory=ItemCategory;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getItemCategory() {
		return ItemCategory;
	}
	public void setItemCategory(String itemCategory) {
		ItemCategory = itemCategory;
	}
	@Override
	public String toString() {
		return "ItemDetails [ItemId=" + ItemId + ", ItemName=" + ItemName + ", price=" + price + ", status=" + status
				+ ", photoName=" + photoName + ", email=" + email + ", ItemCategory=" + ItemCategory + "]";
	}
	
	
	
	
	

}
