<%@ page import="org.code2040.dashboard.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'beingUsed', 'error')} ">
	<label for="beingUsed">
		<g:message code="question.beingUsed.label" default="Being Used" />
		
	</label>
	<g:checkBox name="beingUsed" value="${questionInstance?.beingUsed}" />
</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="question.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${questionInstance?.description}"/>
</div>

