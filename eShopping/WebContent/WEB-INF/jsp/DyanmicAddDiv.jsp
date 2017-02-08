<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
$(document).ready(function(){
		$("#viewProductLink").click( function(){
  			  $.getJSON("http://localhost:8080/eShopping/viewProduct")
  			  		$.each(data, function (index, item) {
  			   			 var eachrow = "<tr>"
    	                 + "<td>" + item.image1 + "</td>"
    	                 + "<td>" + item.productName + "</td>"
    	                 + "<td>" + item.brand + "</td>"
    	                 + "<td>" + item.description + "</td>"
    	                 + "<td>" + item.price + "</td>"
    	                 +"<td>"+'<button class="editButton" onclick="editClick('+item.bookId+')">Edit</button>'	                 
						+ "<td>"+'<button class="deleteButton" onclick="deleteClick('+item.bookId+')">Delete</button>'
    	                 + "</tr>";
    	 		    $('#tableHead').append(eachrow);
  			  });

				});
		});


</script>
</head>
<body>
<div class="container">
    <div class="well well-sm">
        <strong>Display</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
    <div id="products" class="productDivId">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group" src="item.image1" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                     item.productName</h4>
                    <p class="group inner list-group-item-text">
                        item.description
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                               item.price</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<a href="viewProduct" id="viewProductLink">View</a>



</body>
</html>