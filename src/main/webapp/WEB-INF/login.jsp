<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Log in with your account</title>
    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	body {
			background: #eee !important;	
		}
		
		.wrapper {	
			margin-top: 80px;
		  margin-bottom: 80px;
		}

		.form-signin {
		  max-width: 380px;
		  padding: 15px 35px 45px;
		  margin: 0 auto;
		  background-color: #fff;
		  border: 1px solid rgba(0,0,0,0.1);  		  
		}
		
		.form-signin-heading, .checkbox {
			  margin-bottom: 30px;
		}
		
		.form-control {
		  position: relative;
		  font-size: 16px;
		  height: auto;
		  padding: 10px;
		}

		input[type="text"] {
		  margin-bottom: 10px;
		  border-bottom-left-radius: 0;
		  border-bottom-right-radius: 0;
		}
	
		input[type="password"] {
		  margin-bottom: 20px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
}
    	
    </style>
</head>
<body>
	<div class="wrapper">
		<form method="POST" action="/login" class="form-signin">
	        <h2 class="form-signin-heading">Please login</h2>
	
	        <div class="form-group">
	            <input name="username" type="text" class="form-control" placeholder="Username" autofocus/>
	            <input name="password" type="password" class="form-control" placeholder="Password"/>
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	        </div>
	
	    </form>
    </div>
    
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	    

</html>