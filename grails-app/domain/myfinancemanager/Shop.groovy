package myfinancemanager

class Shop {
	String shopName
	
	String toString (){
		"${shopName}"
	}
    static constraints = {
		shopName(nullable: false, unique:true)
    }
}
