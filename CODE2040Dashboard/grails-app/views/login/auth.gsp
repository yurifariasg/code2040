<!DOCTYPE html>
<html>
	<head>
		<title>CODE:2040 - Login</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_login.css')}" />
		<g:javascript src="login.js" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Applicant</h2>
		</div>
		<div class="content">
			<div class="log container" id="logCon">
				<h3 class="log title">Login</h3>
				<g:if test='${flash.message}'>
					<div class='login_message'>${flash.message}</div>
				</g:if>
				<form class="log submission" action="${postUrl}" method="post">
					<div class="elem_containter">
						<label for="log_email">Email:</label><br/>
						<input type="text" id="log_email" name="j_username"/>
					</div>
					<div class="elem_containter">	
						<label for="log_password">Password:</label><br/>
						<input type="password" id="log_password" name="j_password"/>
					</div>
					<div class="elem_containter">	
						<a href="/CODE2040Dashboard/candidate/index" id="switch_reg">Need to register?</a>
						<input type="submit" value="Login"/>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>