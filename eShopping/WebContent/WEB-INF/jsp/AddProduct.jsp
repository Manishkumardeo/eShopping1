<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>
<script >
$("document").ready(function(){
$("#addForm").submit(function(e){
	e.preventDefault();
	 $.ajax( {
	      url: 'addProduct',
	      type: 'POST',
	      data: new FormData( this ),
	      processData: false,
	      contentType: false,
	      success: function (data1) {
                $("#resultdata").text(data1);
                
            }
	    } );
return false;});

});
</script>
	<form method="POST" id="addForm"
		action="addProduct" enctype="multipart/form-data">
		Product name<input type="text" name="productName"><br>
		Product brand<input type="text" name="brand"><br> Product
		color<input type="text" name="color"><br> Product
		description<textarea rows="4" cols="50" name="description"></textarea><br>
		Product price<input type="text" name="price"><br> Product
		image1<input type="file" name="image1"><br>
		Product image2<input type="file" name="image2"><br>
		Product image3<input type="file" name="image3"><br>
		Product image4<input type="file" name="image4"><br>
		No of Item<input type="text" name="itemCount"><br>
		<input type="submit" value ="add product"> 
	</form>


</body>
</html>