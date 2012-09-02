<!DOCTYPE html>
<html>
	<head>
		<title>CODE:2040 - Staff</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'mlist.css')}" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">Master List</h1>
			<h2 class="page_title">CODE:2040</h2>
		</div>
		<div>
			<div>
				<h3 class="title inline">I want to sort by</h3>
				<select class="content">
					<option>First name</option>
					<option>Last name</option>
					<option>School</option>
				</select>
				<h3 class="title inline">in</h3>
				<select class="content">
					<option>ascending</option>
					<option>descending</option>
				</select>
				<h3 class="title inline">order.</h3>
				<input type="button" value="Go" />				
			</div>
			<div>
				<input id="status_can" type="checkbox" checked="checked"/>
				<label class="checkBoxLabel" for="status_can">Candidate</label>
				<input id="status_fel" type="checkbox" checked="checked"/>
				<label class="checkBoxLabel" for="status_fel">Fellow</label>
				<input id="status_alu" type="checkbox" checked="checked"/>
				<label class="checkBoxLabel" for="status_alu">Alum</label>
			</div>
			<div class="table container">
				<table id="ml_results">
					<tr>
						<th>Name</th>
						<th>School</th>
						<th>Status</th>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>