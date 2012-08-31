
<%@ page import="org.code2040.dashboard.Question" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}">Lets go back</a></li>
				<li><g:link class="create" action="create">Create a brand new Question!</g:link></li>
			</ul>
		</div>
		<div id="list-question" class="content scaffold-list" role="main">
			<!--  <h1><g:message code="default.list.label" args="[entityName]" /></h1> -->
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="id" title="${message(code: 'question.beingUsed.label', default: 'Question ID')}" />
						<g:sortableColumn property="description" title="${message(code: 'question.description.label', default: 'Question')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${questionInstanceList}" status="i" var="questionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${questionInstance.id}">${fieldValue(bean: questionInstance, field: "id")}</g:link></td>
						<td>${fieldValue(bean: questionInstance, field: "description")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${questionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
