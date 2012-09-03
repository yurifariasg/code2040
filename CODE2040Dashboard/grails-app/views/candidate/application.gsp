<!DOCTYPE html>
<html>
	<head>
		<title>CODE:2040 - Application</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'cv_app.css')}" />
		<g:javascript src="app.js" />
		<blueprint:resources/>
	</head>
	<body onLoad="javascript: onLoadHandler()">
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Step 1: Fill out application</h2>
		</div>
		<div class="content">
			<h3 class="form title">The Facts</h3>
			<g:if test='${error_message}'>
				<div class='login_message'
				style="background-color: #FF0000; color: #FFFFFF">Error: ${error_message}</div>
			</g:if>
			<form class="reg submission" action="" method="post">
				<div class="row">
				<div class="float">
					<div class="row">
						<label for="app_fname">First Name:</label><br/>
						<input type="text" id="app_fname" name="fname"/>
					</div>
					<div class="row">
						<label for="app_school">Current College or University:</label><br/>
						<select id="app_school" class="short_ddm" name="school"></select>
					</div>
					<div class="row">
						<label for="app_degree">Degree:</label><br/>
						<input type="text" id="app_degree" name="degree" />
					</div>
				</div>
				<div class="float">
					<div class="row">
						<label for="app_mname">Middle Name:</label><br/>
						<input type="text" id="app_mname" name="mname"/>
					</div>
					<div class="row">
						<label for="app_grad_mon">Expected Graduation Month:</label><br/>
						<select id="app_grad_mon" name="gradMonth">
							<option>January</option>
							<option>February</option>
							<option>March</option>
							<option>April</option>
							<option>May</option>
							<option>June</option>
							<option>July</optino>
							<option>August</option>
							<option>September</option>
							<option>October</option>
							<option>November</option>
							<option>December</option>
						</select>
					</div>
					<div class="row">
						<label for="app_grad_yr">Expected Graduation Year:</label>
						<input type="text" id="app_grad_yr" name="gradYr" />
					</div>
				</div>
				<div class="float">
				<div class="row">
						<label for="app_lname">Last Name:</label><br/>
						<input type="text" id="app_lname" name="lname"/>
					</div>
					<div class="row">
						<label for="app_major">Major(s):</label><br/>
						<textarea name="major" id="app_major" rows="3" cols="7" class="major_ta"></textarea>
					</div>
					</div>
				</div>
				<div class="row">
					<div class="float">
						<label for="app_prevSchool">Previous College:</label><br/>
						<select id="app_prevSchool" class="short_ddm" name="prevschool"></select>
					</div>
					<div class="float">
						<div class="row">
							<label for="app_pdegree">Degree:</label><br/>
							<input type="text" id="app_pdegree" name="prevdegree" />
						</div>
					</div>
					<div class="float">
						<div class="row">
							<label for="app_pmajor">Major(s):</label><br/>
							<textarea name="prevmajor" id="app_pmajor" rows="3" cols="7" class="major_ta"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="float">
						<div class="row">
							<label for="app_phone">Phone:</label><br/>
							<input type="text" id="app_phone" name="phone"/>
						</div>
						<div class="row">
							<label for="app_gender">Gender:</label><br/>
							<select id="app_gender" name="gender">
								<option>Male</option>
								<option>Female</option>
								<option>Prefer not to say</option>
							</select>
						</div>
					</div>
					<div class="float">
						<div class="row">
							<label for="app_state">Home state:</label><br/>
							<select id="app_state" name="state">
								<option>Alabama</option>
								<option>Alaska</option>
								<option>Arizona</option>
								<option>Arkansas</option>
								<option>California</option>
								<option>Colorado</option>
								<option>Connecticut</option>
								<option>Delaware</option>
								<option>Florida</option>
								<option>Georgia</option>
								<option>Hawaii</option>
								<option>Idaho</option>
								<option>Illinois</option>
								<option>Indiana</option>
								<option>Iowa</option>
								<option>Kansas</option>
								<option>Kentucky</option>
								<option>Louisiana</option>
								<option>Maine</option>
								<option>Maryland</option>
								<option>Massachusetts</option>
								<option>Michigan</option>
								<option>Minnesota</option>
								<option>Mississippi</option>
								<option>Missouri</option>
								<option>Montana</option>
								<option>Nebraska</option>
								<option>Nevada</option>
								<option>New Hampshire</option>
								<option>New Jersey</option>
								<option>New Mexico</option>
								<option>New York</option>
								<option>North Carolina</option>
								<option>North Dakota</option>
								<option>Ohio</option>
								<option>Oklahoma</option>
								<option>Oregon</option>
								<option>Pennsylvania</option>
								<option>Rhode Island</option>
								<option>South Carolina</option>
								<option>South Dakota</option>
								<option>Tennessee</option>
								<option>Texas</option>
								<option>Utah</option>
								<option>Vermont</option>
								<option>Virgina</option>
								<option>Washington</option>
								<option>West Virginia</option>
								<option>Wisconsin</option>
								<option>Wyoming</option>
							</select>
						</div>
						<div class="row">
							<label>Race:</label><br/>
							<input type="checkbox" id="white" name="race" value="white"/>
							<label for="white">White</label><br/>
							<input type="checkbox" id="black" name="race" value="black"/>
							<label for="black">Black or African American</label><br/>
							<input type="checkbox" id="latino" name="race" value="latino"/>
							<label for="latino">Hispanic or Latino/a</label><br/>
							<input type="checkbox" id="native" name="race" value="native"/>
							<label for="native">American Indian or Alaska Native </label><br/>
							<input type="checkbox" id="asian" name="race" value="asian"/>
							<label for="asian">Asian</label><br/>
							<input type="checkbox" id="hawaiian" name="race" value="hawaiian"/>
							<label for="hawaiian">Native Hawaiian and Other Pacific Islander</label><br/>
							<input type="checkbox" id="other" name="race" value="other"/>
							<label for="other">Other</label><br/>
						</div>
						</div>
					<div class="float">
						<div class="row">
							<label for="app_country">Home country:</label><br/>
							<select id="app_country" name="country" class="short_ddm"></select>				
						</div>
						<label>How did you hear about CODE2040?</label><br/>
						<input type="checkbox" id="pub_email" name="pub" value="email" />
						<label for="pub_email">An email blast</label><br/>
						<input type="checkbox" id="pub_job_board" name="pub" value="jobBoard" />
						<label for="pub_job_board">A job board</label><br/>
						<input type="checkbox" id="pub_friend" name="pub" value="friend" />
						<label for="pub_friend">A friend</label><br/>
						<input type="checkbox" id="pub_info_sess" name="pub" value="infoSess" />
						<label for="pub_info_sess">An info session</label><br/>
						<input type="checkbox" id="pub_code2040" name="pub" value="code2040" />
						<label for="pub_code2040" >I met someone involved with CODE2040</label><br/>
						<input type="checkbox" id="pub_other" name="pub" value="other" />
						<label for="pub_other" >Other</label>
					</div>
				</div>
				<div class="row">
					<div class="float half">
						<label for="q1">Why do you want to be a CODE2040 Fellow?</label>
						<textarea class="short_answer" id="q1" name="why_code2040" onKeyDown="limitText(this.form.why_code2040,this.form.countdown1,1500);" onKeyUp="limitText(this.form.why_code2040,this.form.countdown1,1500);"></textarea>
						<p class="helper_text">(Maximum characters: 1500)</p>
						<p class="helper_text">You have <input readonly type="text" name="countdown1" size="3" value="1500"> characters left.</p>
					</div>
					<div class="float half">
						<label for="q2">What do you hope to get out of the CODE2040 Fellows Program?</label>
						<textarea class="short_answer" id="q2" name="what_hopes_for_program" onKeyDown="limitText(this.form.what_hopes_for_program,this.form.countdown2,1500);" onKeyUp="limitText(this.form.what_hopes_for_program,this.form.countdown2,1500);"></textarea>
						<p class="helper_text">(Maximum characters: 1500)</p>
						<p class="helper_text">You have <input readonly type="text" name="countdown2" size="3" value="1500"> characters left.</p>
					</div>
				</div>
				<div class="row">
					<div class="float">
						<label for="app_resume">Please provide a link to your resume (e.g., Dropbox, GoogleDoc).</label><br/>
						<input type="text" id="app_resume" name="resumeLink"/><br/>
						<label for="links">Please provide any links to your online presence (twitter, website, blog, LinkedIn, etc).</label>
						<textarea class="short_answer" id="links" name="onlinePresence"></textarea>
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