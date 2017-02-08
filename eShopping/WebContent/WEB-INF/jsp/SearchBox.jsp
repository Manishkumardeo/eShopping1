<!DOCTYPE html>
<html>
<head>
<style> 
input[type=text] {
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
}

input[type=text]:focus {
    width: 100%;
}
</style>

<script>
$(document).ready(function(){
		 console.log("ub search product")
		
			$("#searchProductSubmit").click(function(e){
				e.preventDefault();
				var x = $("#productNameId").val();
				console.log(x);
			    $.post("/eShopping/SearchProduct/"+x,function(data){
			    });
			    return false;
			});

		
	});
</script>
</head>
<body>

<form class="searchProduct" method="post"">
  <input type="text" name="productName" placeholder="Search product and brand.." id="productNameId">
  <input type ="submit" value="submit" id="searchProductSubmit">
</form>

</body>
</html>
