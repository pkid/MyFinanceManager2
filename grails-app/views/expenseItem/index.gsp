
<%@ page import="myfinancemanager.ExpenseItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'expenseItem.label', default: 'ExpenseItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-expenseItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-expenseItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="date" title="${message(code: 'expenseItem.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'expenseItem.amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="person" title="${message(code: 'expenseItem.person.label', default: 'Person')}" />
					
						<th><g:message code="expenseItem.shop.label" default="Shop" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${expenseItemInstanceList}" status="i" var="expenseItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${expenseItemInstance.id}">${fieldValue(bean: expenseItemInstance, field: "date").substring(0,10)}</g:link></td>
					
						<td>${fieldValue(bean: expenseItemInstance, field: "amount")}</td>
					
						<td>${fieldValue(bean: expenseItemInstance, field: "person")}</td>
					
						<td>${fieldValue(bean: expenseItemInstance, field: "shop")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${expenseItemInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
