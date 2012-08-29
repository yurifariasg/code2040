<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>CODE:2040 - Task List</title>
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'app.css')}" />
		<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file:'tasks.css')}" />
		<blueprint:resources/>
	</head>
	<body>
		<div class="header">
			<h1 class="site_title">CODE:2040</h1>
			<h2 class="page_title">Task List: Take Action</h2>
		</div>
		<div class="content">
			<div class="task row">
				<r:img dir="images" file="arrow-closed.png" />						
				<h3 class="task_header inline">Step 1: Review application</h3>
				<h3 class="count inline">1</h3>
				<div class="row" id="hidden_content_step_one">
					<div class="row subaccordian">
						<div class="row inline">
							<r:img dir="images" file="arrow-closed.png" />
							<a class="profile_url" href="profile?id=1">Jack Sparrow</a>
							<button type="button" disabled="disabled">Accept</button>
							<button type="button" disabled="disabled" >Skip</button>
							<button type="button" disabled="disabled">Deny</button>					
						</div>
						<div class="row hidden">
						<div class="candidate_app_txt float">
						
						</div>
						<div class="candidate_ai_comment flaot">
							
						</div>
						</div>	
					</div>
				</div>
			</div>
			<div class="task row">
				<img src="" alt="triangular arrow" onclick="clickHandler(this,'hidden_content_step_two')"/>
				<h4 class="task_header">Step 2: Review scores</h4>
				<h4 class="count">1</h4>
				<div class="row hidden" id="hidden_content_step_two">

				</div>
			</div>
			<div class="task row">
				<img src="" alt="triangular arrow" onclick="clickHandler(this,'hidden_content_step_three')"/>
				<h4 class="task_header">Step 3: Phone screens</h4>
				<h4 class="count">1</h4>
				<div class="row hidden" id="hidden_content_step_three">

				</div>
			</div>
			<div class="task row">
				<img src="" alt="triangular arrow" onclick="clickHandler(this,'hidden_content_step_four')"/>
				<h4 class="task_header">Step 4: Internship match</h4>
				<h4 class="count">1</h4>
				<div class="row hidden" id="hidden_content_step_four">

				</div>
			</div>
		</div>
	</body>
</html>