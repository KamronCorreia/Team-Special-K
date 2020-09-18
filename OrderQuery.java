
public class OrderQuery extends QueryBuilder{

	static String TABLENAME = "Orders";	
	static int TOTALCOLUMNS = 5;

	public OrderQuery(String keyWanted){
		super(keyWanted);
		
		keys.put("date", null);
		keys.put("email", null);
		keys.put("ship_address", null);
		keys.put("product_id", null);
		keys.put("quantity", null);	
	}
}
