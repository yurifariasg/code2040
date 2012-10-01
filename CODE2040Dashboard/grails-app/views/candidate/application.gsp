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
						<select id="app_school" class="short_ddm" name="school" onchange="javascript: checkSelection(this, 'app_school_other')"></select>
						<label class="hidden" for="app_school_other">Please indicate specifics:</label><br />
						<input class="hidden" type="text" id="app_school_other" name="schoolOther" />  
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
							<option value="January">January</option>
							<option value="February">February</option>
							<option value="March">March</option>
							<option value="April">April</option>
							<option value="May">May</option>
							<option value="June">June</option>
							<option value="July">July</optino>
							<option value="August">August</option>
							<option value="September">September</option>
							<option value="October">October</option>
							<option value="November">November</option>
							<option value="December">December</option>
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
						<select id="app_prevSchool" class="short_ddm" name="prevschool" onchange="javascript: checkSelection(this, 'app_prevschool_other')"></select>
						<label class="hidden" for="app_prevschool_other">Please indicate specifics:</label><br />
						<input class="hidden" type="text" id="app_prevschool_other" name="prevschoolOther" />
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
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Other">Prefer not to say</option>
							</select>
						</div>
					</div>
					<div class="float">
						<div class="row">
							<label for="app_state">Home state:</label><br/>
							<select id="app_state" name="state">
								<option value="Alabama">Alabama</option>
								<option value="Alaska">Alaska</option>
								<option value="Arizona">Arizona</option>
								<option value="Arkansas">Arkansas</option>
								<option value="California">California</option>
								<option value="Colorado">Colorado</option>
								<option value="Connecticut">Connecticut</option>
								<option value="Delaware">Delaware</option>
								<option value="Florida">Florida</option>
								<option value="Georgia">Georgia</option>
								<option value="Hawaii">Hawaii</option>
								<option value="Idaho">Idaho</option>
								<option value="Illinois">Illinois</option>
								<option value="Indiana">Indiana</option>
								<option value="Iowa">Iowa</option>
								<option value="Kansas">Kansas</option>
								<option value="Kentucky">Kentucky</option>
								<option value="Louisiana">Louisiana</option>
								<option value="Maine">Maine</option>
								<option value="Maryland">Maryland</option>
								<option value="Massachusetts">Massachusetts</option>
								<option value="Michigan">Michigan</option>
								<option value="Minnesota">Minnesota</option>
								<option value="Mississippi">Mississippi</option>
								<option value="Missouri">Missouri</option>
								<option value="Montana">Montana</option>
								<option value="Nebraska">Nebraska</option>
								<option value="Nevada">Nevada</option>
								<option value="New Hampshire">New Hampshire</option>
								<option value="New Jersey">New Jersey</option>
								<option value="New Mexico">New Mexico</option>
								<option value="New York">New York</option>
								<option value="North Carolina">North Carolina</option>
								<option value="North Dakota">North Dakota</option>
								<option value="Ohio">Ohio</option>
								<option value="Oklahoma">Oklahoma</option>
								<option value="Oregon">Oregon</option>
								<option value="Pennsylvania">Pennsylvania</option>
								<option value="Rhode Island">Rhode Island</option>
								<option value="South Carolina">South Carolina</option>
								<option value="South Dakota">South Dakota</option>
								<option value="Tennessee">Tennessee</option>
								<option value="Texas">Texas</option>
								<option value="Utah">Utah</option>
								<option value="Vermont">Vermont</option>
								<option value="Virginia">Virginia</option>
								<option value="Washington">Washington</option>
								<option value="West Virginia">West Virginia</option>
								<option value="Wisconsin">Wisconsin</option>
								<option value="Wyoming">Wyoming</option>
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
							<select id="app_country" name="country" class="short_ddm" onchange="javascript: checkSelection(this, 'app_country_other')"></select>
							<label class="hidden" for="app_country_other">Please indicate specifics:</label><br/>
							<input class="hidden" type="text" id="app_country_other" name="countryOther" />  				
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
						<input type="checkbox" id="pub_code2040" name="pub" value="code2040_connection" onclick="javascript: showOrHideHiddenInput(this, 'app_pub_cc')"/>
						<label for="pub_code2040" >I met someone involved with CODE2040</label><br/>
						<input type="checkbox" id="pub_other" name="pub" value="other" onclick="javascript: showOrHideHiddenInput(this, 'app_pub_other')"/>
						<label for="pub_other" >Other</label>
						<label class="hidden" for="app_pub_secondary">Please indicate specifics:</label><br/>
						<input class="hidden" type="text" id="app_pub_cc" name="pub_secondary_cc" />
						<input class="hidden" type="text" id="app_pub_other" name="pub_secondary_other" />    
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