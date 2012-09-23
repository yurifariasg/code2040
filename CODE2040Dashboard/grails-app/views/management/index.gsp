<!DOCTYPE html>
<html>
	<head>
		<title>CODE:2040 - Staff</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_login.css')}" />
		<g:javascript src="login.js" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">Staff</h1>
			<h2 class="page_title">CODE:2040</h2>
		</div>
		<g:if test='${message}'>
			<div class='login_message'>Message: ${message}</div>
		</g:if>
		<g:if test='${error_message}'>
			<div class='login_message'
			style="background-color: #FF0000; color: #FFFFFF">Error: ${error_message}</div>
		</g:if>
		<div class="content">
			<div class="reg container" id="regCon">
				<h3 class="reg title">Register</h3>
				<form class="reg submission" action="create" method="post">
					<div class="elem_containter">
						<label for="reg_fname">First Name:</label><br/>
						<input type="text" id="reg_fname" name="firstname"/>
					</div>
					<div class="elem_containter">
						<label for="reg_lname">Last Name:</label><br/>
						<input type="text" id="reg_lname" name="lastname"/>
					</div>
					<div class="elem_containter">
						<label for="reg_email">Email:</label><br/>
						<input type="text" id="reg_email" name="email"/>
					</div>
					<div class="elem_containter">
						<label for="reg_password">Password:</label><br/>
						<input type="password" id="reg_password" name="password"/>
					</div>
					<div class="elem_containter">
						<label for="reg_retype">Retype password:</label><br/>
						<input type="password" id="reg_retype" name="retry"/>
					</div>
					<div class="elem_containter">
						<a href="login" id="switch_log">Already registered?</a>
						<input type="submit" value="Register"/>
					</div>
				</form>
			</div>	
		</div>
	</body>
</html>