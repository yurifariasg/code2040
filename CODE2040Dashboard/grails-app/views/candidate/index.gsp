<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>CODE:2040 - Applicant</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_reg.css')}" />
		<g:javascript src="login.js" />
	<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Welcome!</h2>
		</div>
		<div class="content">
			<div class="float" id="about">
				<h3 class="title">About CODE:2040</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in odio eu est porttitor pulvinar. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis felis ante, vel suscipit nibh. Nulla facilisi. Morbi ultrices vestibulum tortor ut posuere. Quisque a lorem massa. Pellentesque volutpat congue massa nec cursus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque sit amet sodales ante. Mauris fermentum nunc quis elit luctus eget pharetra dui malesuada. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent elementum, enim eget aliquet aliquam, nibh dui molestie metus, sed egestas libero nibh porta neque.</p>
			</div>
			<div class="reg float container" id="regCon">
				<h3 class="reg title">Register</h3>
				<form class="reg submission" action="create" method="post">
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
						<a href="login" id="switch_log">Need to login?</a>
						<input type="submit" value="Register"/>
					</div>
				</form>
			</div>	
		</div>
	</body>
</html>