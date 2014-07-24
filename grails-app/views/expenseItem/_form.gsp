<%@ page import="myfinancemanager.ExpenseItem" %>



<div class="fieldcontain ${hasErrors(bean: expenseItemInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="expenseItem.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${expenseItemInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: expenseItemInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="expenseItem.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: expenseItemInstance, field: 'amount')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: expenseItemInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="expenseItem.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="person" from="${expenseItemInstance.constraints.person.inList}" required="" value="${expenseItemInstance?.person}" valueMessagePrefix="expenseItem.person"/>

</div>

<div class="fieldcontain ${hasErrors(bean: expenseItemInstance, field: 'shop', 'error')} required">
	<label for="shop">
		<g:message code="expenseItem.shop.label" default="Shop" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="shop" name="shop.id" from="${myfinancemanager.Shop.list()}" optionKey="id" required="" value="${expenseItemInstance?.shop?.id}" class="many-to-one"/>

</div>

