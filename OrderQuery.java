
public class OrderQuery extends QueryBuilder{
    
	public OrderQuery(){	
        tableName = "Orders";
		totalColumns = 5;
        loadKeys();
        clearKeys();
    }
    
    public void loadKeys(){
        keys.put("date", "");
		keys.put("email", "");
		keys.put("ship_address", "");
		keys.put("product_id", "");
		keys.put("quantity", 0);	
    }
}
