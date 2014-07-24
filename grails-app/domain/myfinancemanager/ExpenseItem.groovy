package myfinancemanager

class ExpenseItem {
	Date date
	Double amount
	String person
		
	static belongsTo = [shop: Shop]

    static constraints = {
		date(nullable: false)
		amount(nullable: false)
		person(inList:["Wife", "Husband", "Family"])
		shop(nullable: false)
    }
}
