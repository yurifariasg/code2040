
<%@ page import="org.code2040.dashboard.Question" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Tasks')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<style type="text/css">
			#page-body {
				margin: 2em 5em 1.25em 5em;
			}
		</style>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/management')}">Dashboard</a></li>
				<li><g:link class="list" action="index">Some other future link</g:link></li>
			</ul>
		</div>
		<div id="page-body" role="main" margin="2em 5em 1.25em 5em;">
			<div class="header">
				<h2 class="page_title">Task List: Take Action</h2>
			</div>
			<div class="content">
				<div class="task row">
					<div class="row">
						<img src="" alt="triangular arrow"/>
						<h4 class="task_header">Step 1: Review application <b>(${step_one.size()})</b></h4>
						<g:each in="${step_one}" status="i" var="candidateInstance">
							<tr><b>${candidateInstance.name}</b></tr>
							
							<g:if test="${candidateInstance.needsReview}">
								<g:remoteLink action="approveCandidate" id="${candidateInstance.id}">Approve</g:remoteLink>
								<g:remoteLink action="denyCandidate" id="${candidateInstance.id}">Reject</g:remoteLink>
							</g:if>
							<g:else>Reviewed!</g:else>
							
						</g:each>
					</div>
					<div class="row hidden" id="hidden_content_step_one">
	
					</div>
				</div>
				<div class="task row">
					<img src="" alt="triangular arrow"/>
					<h4 class="task_header">Step 2: Review scores <b>(${step_two.size()})</b></h4>
					<g:each in="${step_two}" status="i" var="candidateInstance">
							<tr><b>${candidateInstance.name}</b></tr>
							
							<g:if test="${candidateInstance.needsReview}">
								<g:remoteLink action="approveCandidate" id="${candidateInstance.id}">Approve</g:remoteLink>
								<g:remoteLink action="denyCandidate" id="${candidateInstance.id}">Reject</g:remoteLink>
							</g:if>
							<g:else>Reviewed!</g:else>
							
					</g:each>
				</div>
				<div class="task row">
					<img src="" alt="triangular arrow"/>
					<h4 class="task_header">Step 3: Phone screens <b>(${step_three.size()})</b></h4>
					<g:each in="${step_three}" status="i" var="candidateInstance">
							<tr><b>${candidateInstance.name}</b></tr>
							
							<g:if test="${candidateInstance.needsReview}">
								<g:remoteLink action="approveCandidate" id="${candidateInstance.id}">Approve</g:remoteLink>
								<g:remoteLink action="denyCandidate" id="${candidateInstance.id}">Reject</g:remoteLink>
							</g:if>
							<g:else>Reviewed!</g:else>
							
					</g:each>
				</div>
				<div class="task row">
					<img src="" alt="triangular arrow"/>
					<h4 class="task_header">Step 4: Internship match <b>(${step_four.size()})</b></h4>
					<g:each in="${step_fourth}" status="i" var="candidateInstance">
							<tr><b>${candidateInstance.name}</b></tr>
							
							<g:if test="${candidateInstance.needsReview}">
								<g:remoteLink action="approveCandidate" id="${candidateInstance.id}">Approve</g:remoteLink>
								<g:remoteLink action="denyCandidate" id="${candidateInstance.id}">Reject</g:remoteLink>
							</g:if>
							<g:else>Reviewed!</g:else>
							
					</g:each>
				</div>
				<div class="task row">
					<img src="" alt="triangular arrow"/>
					<h4 class="task_header">Denied Candidates <b>(${denied.size()})</b></h4>
					<g:each in="${denied}" status="i" var="candidateInstance">
							<tr><b>${candidateInstance.name}</b></tr>
					</g:each>
				</div>
			</div>
		</div>
	</body>
</html>
