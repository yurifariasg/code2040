<!DOCTYPE html>
<html>
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
			<g:if test='${message}'>
				<div class='login_message'>Message: ${message}</div>
			</g:if>
			<g:if test='${error_message}'>
				<div class='login_message'
				style="background-color: #FF0000; color: #FFFFFF">Error: ${error_message}</div>
			</g:if>
		</div>
		<div class="content">
			<div class="float" id="about">
				<h3 class="title">Apply Now</h3>
				<p id="intro"><span class="bold">Welcome to CODE2040!</span> If you're into computer science -- or just an awesome coder -- and interested in the fast-paced world of Silicon Valley startups, then you're in the right place.</p>
				<p><span class="bold">Here's a quick overview of the program:</span></p>
				<span>If you are a:</span>
				<ul>
					<li>Black or Latino/a</li>
					<li>An awesome coder/computer engineer looking for a challenging, fast-paced summer internship</li>
					<li>Ready to meet some of the most innovative people in Silicon Valley</li>
				</ul>
				<span>Apply to the CODE2040 fellowship to get:</span>
				<ul>
					<li>a paid internship with a top startup</li>
					<li>individual mentoring from successful entrepreneurs</li>
					<li>intimate discussions with tech leaders</li>
					<li>company visits</li>
					<li>interactive workshops</li>
					<li>executive coaching</li>
				</ul>
				<p>For more, check out this <a href="http://www.bloomberg.com/video/new-code-2040-internship-helps-diversify-workforce-e4sOlmWXSmKq4TMRLrLukg.html">short feature on us on Bloomberg TV.</a></p>
				<p><span class="bold">What's with the name?</span>  The year 2040 is the year in which people of color will become the majority in the US. We want to make sure people of color are well represented in America's most innovative economies, like Silicon Valley, by that same year.</p>
				<p><span class="bold">Apply now!</span>  Sign in to start the written part of the application, and take the coding exam when you're ready. We look forward to getting to know you!</p>
			</div>
			<sec:ifNotLoggedIn>
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
			</sec:ifNotLoggedIn>
			<sec:ifLoggedIn>
				Hello World</br>
				<a href="logout" id="switch_log">Logout</a>
			</sec:ifLoggedIn>
		</div>
	</body>
</html>