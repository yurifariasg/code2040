<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>CODE:2040 - Applicant</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_login.css')}" />
		<g:javascript src="login.js" />
		<script type="text/javascript" src="login.js"></script>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Applicant</h2>
		</div>
		<div class="content">
			<div class="log container" id="logCon">
				<h3 class="log title">Login</h3>
				<form class="log submission" action="" method="post">
					<div class="elem_containter">
						<label for="log_email">Email:</label><br/>
						<input type="text" id="log_email"/>
					</div>
					<div class="elem_containter">	
						<label for="log_password">Password:</label><br/>
						<input type="password" id="log_password"/>
					</div>
					<div class="elem_containter">	
						<a href="index" id="switch_reg">Need to register?</a>
						<input type="submit" value="Login"/>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>