<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>CODE:2040 - Application</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_app.css')}" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Step 1: Fill out application</h2>
		</div>
		<div class="content">
			<h3 class="form title">The Facts</h3>
			<form class="app submission" action="" method="post">
				<div class="float">
					<div class="row">
						<label for="app_fname">First Name:</label><br/>
						<input type="text" id="app_fname"/>
					</div>
					<div class="row">
						<label for="app_school">College:</label><br/>
						<input type="text" id="app_school"/>
					</div>
					<div class="row">
						<label for="app_state">Home state:</label><br/>
						<input type="text" id="app_state"/>
					</div>
					<div class="row">
						<label for="app_phone">Phone:</label><br/>
						<input type="text" id="app_phone"/>
					</div>
				</div>
				<div class="float">
					<div class="row">
						<label for="app_lname">Last Name:</label><br/>
						<input type="text" id="app_lname"/>
					</div>
					<div class="row">
						<label for="app_grad_yr">Expected graduation year:</label><br/>
						<input type="text" id="app_grad_yr" />
					</div>
					<div class="row">
						<label for="app_country">Home country:</label><br/>
						<input type="text" id="app_country"/>				
					</div>	
				</div>
				<div class="float">
					<div class="row">
						<label for="app_gender">Gender:</label><br/>
						<select id="app_gender">
							<option>Male</option>
							<option>Female</option>
							<option>Prefer not to say</option>
						</select>
					</div>
					<div class="row">
						<label>Race:</label><br/>
						<input type="checkbox" id="white" name="race" value="white"/>
						<label for="white">White</label><br/>
						<input type="checkbox" id="black" name="race" value="black"/>
						<label for="black">Black or African American</label><br/>
						<input type="checkbox" id="latino" name="race" value="latino"/>
						<label for="latino">Hispanic or Latino</label><br/>
						<input type="checkbox" id="native" name="race" value="native"/>
						<label for="native">American Indian or Alaska Native </label><br/>
						<input type="checkbox" id="asian" name="race" value="asian"/>
						<label for="asian">Asian</label><br/>
						<input type="checkbox" id="hawaiian" name="race" value="hawaiian"/>
						<label for="hawaiian">Native Hawaiian and Other Pacific Islander</label><br/>
						<input type="checkbox" id="other" name="race" value="other"/>
						<label for="other">Some other race</label><br/>
						<input type="checkbox" id="mixed" name="race" value="mixed"/>
						<label for="mixed">Two or more races</label>
					</div>
				</div>
				<div class="row" id="formButton">
					<input type="submit" value="Save Form" />
					<input type="submit" value="Submit"/>
				</div>
			</form>
		</div>
	</body>
</html>