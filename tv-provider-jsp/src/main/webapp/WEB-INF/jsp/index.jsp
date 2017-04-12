<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>TV Provider</title>
    
    <link rel="stylesheet" href='<c:url value="static/css/bootstrap.min.css"/>' type="text/css">
    <link rel="stylesheet" href='<c:url value="static/css/style.css"/>' type="text/css">
    <!-- <link href="static/css/bootstrap.min.css" rel="stylesheet" /> -->
    <!-- <link href="static/css/style.css" rel="stylesheet" /> -->
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">TV Provider</a>			
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/all-clients">Client List</a></li>
					<li><a href="/all-transactions">Transaction List</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container text-center" id="homeDiv">
				<div class="jumbotron text-center">
					<img src="<c:url value='static/images/tv.jpg'/>" 
							class="img-rounded img-responsive" />
					<h3>TV Provider is your best guide in this wild world</h3>
					
					<div class="bttns">
					    <button class="btn client_list"
					    		onclick="window.location.href='/all-clients'">Client List</button>
					    <button class="btn transaction_list"
					    		onclick="window.location.href='/all-transactions'">Transaction List</button>
					</div>
				</div>
				
				
			</div>	
		</c:when>
		
		<c:when test="${mode == 'MODE_CLIENTS'}">
		<div class="container text-left" id="clientDiv">
		<h3>Client List</h3>
			<div class="container">
		    <div class="row">
		        <div class="panel panel-primary filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Clients</h3>
		            </div>
				<div class="table-responsive">
				<table class="table table-striped table-bordered text-left">
					<thead>
						<tr>
							<th>Id</th>
							<th>Client Name</th>
							<th>Client Email</th>
							<th>Tariff</th>
							<th>Manage Account</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="client" items="${clients}">
						<tr>
							<td>${client.clientId}</td>
							<td>${client.name}</td>
							<td>${client.email}</td>
							<td>${client.tariff}</td>
							<th><a href="update-client?id=${client.clientId}">
								<span class="glyphicon glyphicon-eye-open"></span></a>
								<%-- <a href="delete-client?id=${client.clientId}">
								<span class="glyphicon glyphicon-trash"></span></a> --%>
								</th>
						</tr>						
					</c:forEach>
					</tbody>					
				</table>
		<hr>
			<a href="new-client?id=${client.clientId}"><input type="submit" class="btn btn-add" value="Add New Client"></a>
			</div>
	        </div>
		</div>
		</div>
		</div>
		
		</c:when>

		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
		<div class="container text-center">
		<h3>Manage Client's Account</h3>
			<form class="well form-horizontal" method="post" action="save-client">
				<fieldset>
				<input type="hidden" name="clientId" value="${client.clientId}">
				
				<div class="form-group">
				  <label class="col-md-4 control-label">Name</label>  
				  <div class="col-md-4 inputGroupContainer">
				  <div class="input-group">
				  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				  <input  name="name" placeholder="name" class="form-control" value="${client.name}" type="text">
				    </div>
				  </div>
				</div>

				<div class="form-group">
				  <label class="col-md-4 control-label">Email</label>  
				    <div class="col-md-4 inputGroupContainer">
				    <div class="input-group">
				        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
				  <input name="email" placeholder="Email Address" class="form-control" value="${client.email}" type="text">
				    </div>
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label">Avalable Money</label>  
				    <div class="col-md-4 inputGroupContainer">
				    <div class="input-group">
				        <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
				  <input name="money" placeholder="Avalable Money" class="form-control" value="${client.money}" type="text">
				    </div>
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label">Tariff</label>  
				    <div class="col-md-4 inputGroupContainer">
				    <div class="input-group">
				        <span class="input-group-addon" style="border-right: 1px solid #bcbcbc"><i class="glyphicon glyphicon-paperclip"></i></span>
				  	<input type="radio" class="col-sm-2" name="tariff" value="STANDART" checked="checked">
							<div class="col-sm-5">STANDART</div>
					<input type="radio" class="col-sm-2" name="tariff" value="VIP">
							<div class="col-sm-1">VIP</div>
				    </div>
				  </div>
				</div>
			<hr>
				<div class="form-group">
				  <label class="col-md-4 control-label"></label>
				  <div class="col-md-4">
				      <button type="submit" class="btn btn-save">SAVE</button>
				  </div>
				</div>				
				</fieldset>
			</form>			
		</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_TRANSACTIONS'}">
		<div class="container" id="transactionDiv"> 
		<h3>Transaction List</h3>
	    <div class="row">
	        <div class="panel panel-primary filterable">
	            <div class="panel-heading">
	                <h3 class="panel-title">Transactions</h3>
	                <div class="pull-right">
	                    <button class="btn btn-filter">
	                    	<span class="glyphicon glyphicon-search"></span> Filter</button>
	                </div>
	            </div>
	            <div class="table-responsive">
            	<table class="table table-striped table-bordered">
                <thead>
                    <tr class="filters">
                        <th><input type="text" class="form-control" name="id" placeholder="ID" disabled></th>
                        <th><input type="text" class="form-control" name="clientId" placeholder="Client ID" disabled></th>
                        <th><input type="text" class="form-control" name="name" placeholder="Client Name" disabled></th>
                        <th><input type="text" class="form-control" name="action" placeholder="Type of Action" disabled></th>
                        <th><input type="text" class="form-control" name="date" placeholder="Transaction Time" disabled></th>
                    </tr>
                </thead>

				<tbody>
				<c:forEach var="transaction" items="${transactions}" >
					<tr>
						<td>${transaction.id}</td>
						<td>${transaction.client.clientId}</td>
						<td>${transaction.client.name}</td>
						<td>${transaction.action}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" 
									value="${transaction.date}"/></td>					
					</tr>
				</c:forEach>
				
				</tbody>
				</table>	
	        </div>
		</div>	
		</div>
			<hr>
		</div>
		</c:when>		
	</c:choose>

    <div class="footer navbar-fixed-bottom">
      <span>&copy; TV Provider. 2017</span>
    </div>
   
</body>

	<script src="static/js/jquery-3.2.0.min.js" type="text/javascript"></script>    
    <script src="static/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="static/js/jquery.placeholder.js" type="text/javascript"></script>
    <script src="static/js/script.js" type="text/javascript"></script>
</html>
