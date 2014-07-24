<%@ page import="myfinancemanager.Shop" %>



<div class="fieldcontain ${hasErrors(bean: shopInstance, field: 'shopName', 'error')} required">
	<label for="shopName">
		<g:message code="shop.shopName.label" default="Shop Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="shopName" required="" value="${shopInstance?.shopName}"/>

</div>

