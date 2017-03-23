<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	    
    
    
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.3/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.3/angular-animate.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.3/angular-resource.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.3/angular-route.min.js"></script>
	
    <title>My Sofia AngularJS App</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="/resources/components/phone-list/phone-list.module.js"></script>
    <script src="/resources/components/phone-list/phone-list.component.js"></script>
    
    <script src="/resources/components/phone-detail/phone-detail.module.js"></script>
    <script src="/resources/components/phone-detail/phone-detail.component.js"></script>
    
    <script src="/resources/app.module.js"></script>
    <script src="/resources/app.config.js"></script>
    
    <style>
    	.icon-bar {
		  color: #337ab7;
		  border-color: #337ab7;
		  background-color: #337ab7;
		}
    </style>
    
</head>
<body>
	<header class="navbar header" style="border-bottom: 1px solid #337ab7;">
		<div class="container-fluid">
			
			<div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" aria-expanded="false">
		        <span class="sr-only">Toggle menu navigation</span>
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>        
		      </button>		       
		   </div>
		   <div class="collapse navbar-collapse navbar-responsive-collapse" id="nav">
		    <ul class="nav navbar-nav navbar-right">
		    	<c:if test="${pageContext.request.userPrincipal.name != null}">		
		    		<li style="margin-top: 15px;color: #337ab7;">
			    		Welcome ${pageContext.request.userPrincipal.name}
			    	</li>	    	
	           		<li>           		
						<a href="#" onclick="document.getElementById('logoutForm').submit();">
							Logout
						</a>
						
						<form id="logoutForm" action="<c:url value="/logout" />" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
	          		</li>
	          		
          		</c:if>
          	</ul>
			
		   </div>
	    </div>
    </header>
	<div class="container-fluid" ng-app="sofiaApp">
	
		<div ng-view></div>
	</div>
	<!-- /container -->

</body>
</html>
