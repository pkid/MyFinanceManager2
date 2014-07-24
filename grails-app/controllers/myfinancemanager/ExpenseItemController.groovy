package myfinancemanager



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ExpenseItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ExpenseItem.list(params), model:[expenseItemInstanceCount: ExpenseItem.count()]
    }

    def show(ExpenseItem expenseItemInstance) {
        respond expenseItemInstance
    }

    def create() {
        respond new ExpenseItem(params)
    }

    @Transactional
    def save(ExpenseItem expenseItemInstance) {
        if (expenseItemInstance == null) {
            notFound()
            return
        }

        if (expenseItemInstance.hasErrors()) {
            respond expenseItemInstance.errors, view:'create'
            return
        }

        expenseItemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'expenseItem.label', default: 'ExpenseItem'), expenseItemInstance.id])
                redirect expenseItemInstance
            }
            '*' { respond expenseItemInstance, [status: CREATED] }
        }
    }

    def edit(ExpenseItem expenseItemInstance) {
        respond expenseItemInstance
    }

    @Transactional
    def update(ExpenseItem expenseItemInstance) {
        if (expenseItemInstance == null) {
            notFound()
            return
        }

        if (expenseItemInstance.hasErrors()) {
            respond expenseItemInstance.errors, view:'edit'
            return
        }

        expenseItemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ExpenseItem.label', default: 'ExpenseItem'), expenseItemInstance.id])
                redirect expenseItemInstance
            }
            '*'{ respond expenseItemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ExpenseItem expenseItemInstance) {

        if (expenseItemInstance == null) {
            notFound()
            return
        }

        expenseItemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ExpenseItem.label', default: 'ExpenseItem'), expenseItemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'expenseItem.label', default: 'ExpenseItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
