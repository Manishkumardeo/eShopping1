<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>

 <style>
.myimgbut{
	position:absolute;
	display:none;
	margin:auto;
	left:90px;
		top:80px;
	} 
div.img1 {
     position: relative;
}

div.img2:hover img{
   opacity: 0.5;   
  
}

div.img2:hover  .myimgbut{
   display:block;
  
}
 
div.desc {
    padding: 15px;
    text-align: center;
}
 div.img1 img {
    width: 250px;
    height: 150px;
}


.hidden {display: none;}

.selected{
background-color: #49ba8e
}


</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	console.log('ready');
$.getJSON("addDetailsProductJson/", function(data){ 
	console.log('manish for');
	for(i=0; i< data.length; i++){
		 console.log(i);
			var div1=$("<div class='col-md-4 ' />");
			var div2=$("<div class='img1 img-thumbnail' />");
			div2.append("<div class='img2'><img class='img-rounded mybmi' src= viewProduct/"+data[i]['productName'] + 
				" width='900' height='700'></div><div class='desc'><a  class='btn btn-link' href=viewProduct</a></div>")
				
				 console.log(data[i]);
	 	div1.append(div2);
		$(".myrow1").append(div1);
		} 
				   
	/* div2.append("<div class='img2'><img class='img-rounded mybmi' src=displayimage/"+data[k]['movieid']+" width='900' 
			height='700'><a  class='btn btn-danger myimgbut' href=bookshow/"+data[k]['movieid']+">Book Now</a></div><div class='desc'><a  class='btn btn-link' href=displayimage/"
			+data[k]['moviename']+">"+data[k]['moviename']+"</a></div>") */


	})
});
	
</script>
<!-- ****************For View Json *************************-->
<script>
 $(document).ready(function(){
    $("#abcButton").click(function(){
        $("#abc").load("http://localhost:8080/eShopping/addDetailsProductJson");
    });
});
 </script>
 <!--***************************************************************  -->
<body>

<a href="addItem">Add product</a>  &nbsp &nbsp  
<!-- <a href="viewProduct" id="viewProduct">View Product</a>  &nbsp  &nbsp  -->
 <a href="">Kids's Item</a>

<div class="row myrow1">
<%@include file="SearchBox.jsp"%>
</div>

<!-- ****************For View Json *************************-->
	<div id="abc"></div>
   <button id="abcButton">Button for view Json</button>
   <!--*******************************************************  -->
</body>

</html>