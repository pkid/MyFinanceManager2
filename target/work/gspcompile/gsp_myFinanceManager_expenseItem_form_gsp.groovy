import myfinancemanager.ExpenseItem
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_myFinanceManager_expenseItem_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expenseItem/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: expenseItemInstance, field: 'date', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("expenseItem.date.label"),'default':("Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("date"),'precision':("day"),'value':(expenseItemInstance?.date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: expenseItemInstance, field: 'amount', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("expenseItem.amount.label"),'default':("Amount")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("amount"),'value':(fieldValue(bean: expenseItemInstance, field: 'amount')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: expenseItemInstance, field: 'person', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("expenseItem.person.label"),'default':("Person")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['name':("person"),'from':(expenseItemInstance.constraints.person.inList),'required':(""),'value':(expenseItemInstance?.person),'valueMessagePrefix':("expenseItem.person")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: expenseItemInstance, field: 'shop', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("expenseItem.shop.label"),'default':("Shop")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("shop"),'name':("shop.id"),'from':(myfinancemanager.Shop.list()),'optionKey':("id"),'required':(""),'value':(expenseItemInstance?.shop?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406191561580L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
