<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!--*********************Navigation Bar**********************************  -->
   
   <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >eShopping</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/eShopping/ProductFeatureOption">Home</a></li>
    <!--   <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li> -->
    </ul>
    <form class="navbar-form navbar-left">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search product">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
</nav>

<%@include file="NoBackLogout.jsp"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <form class="searchProduct" method="get">
	  <input type="text" name="productName" placeholder="Search product and brand.." id="ProductNameInSearch">
	  <input type ="submit" value="submit" id="searchProductSubmit">
	</form>

<style>

/* input[type=text] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    
    transition: width 0.4s ease-in-out;
} */

input[type=text]:focus {
    width: 100%;
}


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
    
  overflow:hidden;
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
			var div1=$("<div class='col-md-3 ' />");
			var div2=$("<div class='img1 img-thumbnail' />");
			div2.append("<div class='img2'><img class='img-rounded mybmi' class='img-responsive'  src= viewProduct/"+data[i]['productName'] + 
				" width='900' height='700'><a  class='btn btn-success myimgbut' href=buy/"+data[i]['productName']+
				">Buy</a></div>"
				+"<div class='desc'>Product name :"+data[i]['productName']+"</div>"
				+"<div class='desc'>Brand :"+data[i]['brand']+"</div>"
				+"<div class='desc'>color:"+data[i]['color']+"</div>"
				+"<div class='desc'>price:"+data[i]['price']+"</div>")
				
				/*  console.log(data[i]); */
	 	div1.append(div2);
		$(".myrow1").append(div1);
		} 
	})
});
	
</script>
<!-- ******************************************************* -->

<!-- ******************************************************* -->
<script>
$(document).ready(function(){
    $("#searchProductSubmit").click(function(){
       
        console.log('prodName 1 ');
        var prodName=$("#ProductNameInSearch").val();
        alert("The paragraph was clicked."+prodName);
        console.log('prodName 2 ');
        $.getJSON("searchDetailsProductJson/"+prodName, function(data){ 
        	console.log('manish Json');
        	for(i=0; i< data.length; i++){
        		  alert("The paragraph was clicked."+i);
        			var div1=$("<div class='col-md-4 ' />");
        			var div2=$("<div class='img1 img-thumbnail' />");
        			div2.append("<div class='img2'><img class='img-rounded mybmi' src= searchProduct/"+data[i]['productName'] +  
        				" width='900' height='700'><a  class='btn btn-success myimgbut' href=buy/"+data[i]['productName']+
        				">Buy</a></div>"
        				+"<div class='desc'>Product name :"+data[i]['productName']+"</div>"
        				+"<div class='desc'>Brand :"+data[i]['brand']+"</div>"
        				+"<div class='desc'>color:"+data[i]['color']+"</div>"
        				+"<div class='desc'>price:"+data[i]['price']+"</div>")
        				
        				 console.log(data[i]);
        	 	div1.append(div2);
        		$(".myrow1").append(div1);
        		} })
    });
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
<%-- <%@include file="SearchBox.jsp"%> --%>
</div>

<!-- ****************For View Json *************************-->
	<div id="abc"></div>
   <button id="abcButton">Button for view Json</button>
   
   
  
   
</body>
<%@ include file="LogOut.jsp"%>
</html>