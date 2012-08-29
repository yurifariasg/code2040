<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>CODE:2040 - Staff</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'dashboard.css')}" />
		<g:javascript src="login.js" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">Dashboard</h1>
			<h2 class="page_title">CODE:2040</h2>
		</div>
		<div class="content">
			<div class="search row">
				<h3 class="title">Search profiles</h3>
				<input type="text" name="query" />
				<button type="button">Search</button><br/>
				<a href="master">Give me all profiles</a>
				<div class="hidden">
					<table class="search_results">
					</table>
				</div>
			</div>
			<div class="progress_report row">
				<div class="step float">
					<div class="step_header">
						<h3>Review application</h3>
						<h5>Step 1</h5>
						<div class="action_item_count">

						</div>
					</div>
				</div>
				<div class="step float">
					<h3>Review application</h3>
					<h5>Step 1</h5>
				</div>
			</div>
		</div>
	</body>
</html>