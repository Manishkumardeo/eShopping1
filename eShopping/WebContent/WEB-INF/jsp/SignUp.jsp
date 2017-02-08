<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
		 console.log("ub form submit")
			$("#signUpSubmit").click(function(e){
				e.preventDefault();
				console.log('ff');
			    $.post("/eShopping/signUpService/", $("#signUpForm").serialize() ,function(data){
			    });
			    return false;
			});

		});
	
</script>

</head>
<body>

<body>
	<form method="POST" id="signUpForm">
	Enter First name<input type="text" name="fName"><br>
	Enter Last name<input type="text" name="lName"><br> 
	Enter Mobile<input type="text" name="mobile"><br> 
	Enter email<input type="text" name="email"><br>
	Enter password<input type="password" name="password"><br> 
				  <input type="submit" value ="SignUp " id="signUpSubmit"> 
	</form>


</body>
</html>