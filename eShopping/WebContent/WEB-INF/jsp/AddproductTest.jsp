<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="HeaderAdmin.jsp"%>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script >
  $(document).ready(function(){
	 /*  $(".addProductLink").unbind().click(function() {
	  	 console.log("ub addProductForm")
	  		$(".addProductForm").fadeIn(); */
	  		
	  		console.log("ub addProductForm")
	  		$("#productFormSubmit").click(function(e){
	  			e.preventDefault();
	  			//var x = $("#productNameId").val();
	  			console.log("x");
	  		   /*  $.post("/eShopping/addProduct/"+x, $(".addProductForm").serialize() ,function(data){
	  		    }); */
	  		    
	  		  $.ajax( {
			      url: '/eShopping/addProduct/',
			      type: 'POST',
			      data: new FormData( this ),
			      processData: false,
			      contentType: false,
			      success: function (data1) {
		              
		            }
			    } );
	  		    return false;
	  		});

	  	});
	 
  </script>
</head>
<body>

<div class="container">

  <form class="addProductForm"  method="POST" enctype="multipart/form-data">
  Product Name <br><input type="text" name="productName" > <br><br>
    <div class="form-group">
      <label for="productCategory">Select product Category</label>
      <select class="form-control" id="productCategory">
        <option value="baby">Baby</option>
        <option value="Beauty">Beauty</option>
        <option value="Book">Book</option>
        <option value="Car">Car</option>
        <option value="Electronics">Electronics</option>
        <option value="Furniture">Furniture</option>
        <option value="Mobile">Mobile</option>
        <option value="TV">TV</option>
      </select>
     </div>
     Product Brand <br><input type="text" name="brand"> <br><br>
     Color  <br><input type="text" name="color"> <br><br>
     Description <br> <textarea rows="4" cols="50"></textarea><br><br>
  	 price  <br><input type="text" name="price"> <br><br>
  	 Select Image for Front view  <br><input type="file" name="imagesAll"  multiple><br>
  	 Select Image for Bottom View  <br><input type="file" name="imagesAll"  multiple><br>
  	 Select Image for side view   <br><input type="file" name="imagesAll"  multiple><br>
  	 Select Image for back View  <br><input type="file" name="imagesAll"  multiple><br>
  	 Number of item <br><input type="text" name=count> <br><br>
     <input type ="submit" value ="Add Product" id="productFormSubmit">			 

  </form>
</div>

</body>
<%@include file="Footer.jsp" %>
</html>
