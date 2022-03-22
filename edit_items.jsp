<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.itemDAOImpl"%>
<%@page import="com.DAO.itemDAO" %>
<%@page import="java.util.*"%>
<%@page import="com.entity.ItemDetails"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Additems</title>
<%@include file="allcss.jsp" %>
</head>
<body style="background-color:#f0f1f2;">
<%@include file="navbar.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h4 class="text-center">Edit Items</h4>



<%
int id=Integer.parseInt(request.getParameter("id"));
itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
ItemDetails I=dao.getItemByID(id);
%>


<form action="../edititems" method="post" >
<input type="hidden" name="id" value="<%=I.getItemId()%>">

<div class="form-group">
<label for="exampleInputEmail">Item Name</label><input name="itemname" type="text" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" value="<%=I.getItemName()%>">
</div>

<div class="form-group">
<label for="exampleInputEmail">Price</label><input name="price" type="text" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" value="<%=I.getPrice()%>">
</div>

<div class="form-group">
<label for="inputState">Item Status</label>
<select id="inputState" name="status" class="form-control">
<%if("Active".equals(I.getStatus())){
	%>
	<option value="Active">Available</option>
	<option value="Active">NotAvailable</option>
	<% 
	}else{
	%>
<option value="Active">Available</option>
<option value="Active">NotAvailable</option>
<%
}%>

</select>
</div>

<button type="submit" class="btn btn-primary">Update</button>
</form>
</div>
</div></div></div></div>

</body>
</html>