
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
<title>Admin: Allitems</title>
<%@include file="allcss.jsp" %>
</head>

<body>
<%@include file="navbar.jsp" %>
<h3 class="text-center">Hello Admin</h3>


<c:if test="${not empty succMsg}">
<p class="text-center text-success" >${succMsg}</p>
<c:remove car="succMsg" scope="session"/>
</c>
</c:if>

<c:if test="${not empty failedMsg}">
<p class="text-center text-danger" >${failedMsg}</p>
<c:remove car="failesMsg" scope="session"/>
</c>
</c:if>
<table class="table table-striped ">
  <thead class="bg-primary text-white">
    <tr>
    <th scope="col">ID</th>
      <th scope="col">Image</th>
      <th scope="col">Item Name</th>
      <th scope="col">Price</th>
      <th scope="col">Status</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  
  <tbody>
  <%
 itemDAOImpl dao=new itemDAOImpl(DBConnect.getConn());
  List <ItemDetails> list=dao.getAllItems();
  for(ItemDetails item:list){
  %>
  <tr>
      <td><%=item.getItemId()%></td>
      <td><img src="../items/<%=item.getPhotoName()%>"
      style="width:50px;height:50px;"></td>
      <td><%=item.getItemName()%></td>
      <td><%=item.getPrice()%></td>
      <td><%=item.getStatus()%></td>
      <td>
      <a href="edit_items.jsp?id=<%=item.getItemId() %>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i>Edit</a>
      <a href="../delete?id=<%=item.getItemId() %>" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>Delete</a>
      </td>
       
    </tr>
    
    <%
    } 
    %>
    
    
  </tbody>
</table>
 
  
  
  
  


 
 
 
  
  
  
  

    
       
    
    




</body>
</html>