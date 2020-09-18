
public class ProductQuery extends QueryBuilder{

	static String TABLENAME = "Products";	
	static int TOTALCOLUMNS = 5;

	String KEYHEADER = "product_id";

	public ProductQuery(String keyWanted){

		super(keyWanted);
		
		keys.put(KEYHEADER, null);
		keys.put("quantity", null);
		keys.put("wholesale_cost", null);
		keys.put("sale_price", null);
		keys.put("supplier_id", null);
		
	}
	public ProductQuery(String keyWanted, int quantity, 
			    double wholeCost, double salePrice, String supplier) {
		
		super(keyWanted);
      
      		// puts inserted quantities from input into the product query constructor
      	keys.put(KEYHEADER, keyWanted);
		keys.put("quantity", quantity);
		keys.put("wholesale_cost", wholeCost);
		keys.put("sale_price", salePrice);
		keys.put("supplier_id", supplier);
		
	}
	
	
	public String buyerEvent() {
            
     		// statement that needs to be sent to database to update the quantity by 1 due to purchase
      		return "UPDATE " + TABLENAME + " SET quantity = quantity - 1 WHERE " + KEYHEADER + " = " + keyWanted + ";"; 
      
   	}

   	public String supplierEvent() {
            
      		// statement that needs to be sent to database to update the quantity by 1 due to purchase
      		return "UPDATE " + TABLENAME + " SET quantity = quantity + 1 WHERE " + KEYHEADER + " = " + keyWanted + ";"; 
      
   	}	
}
