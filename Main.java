

public class Main {

	public static void main(String[] args) {
		int fowardingPort = 53306;
		JdbcB489091 jdbc = new JdbcB489091(new JschB489091(fowardingPort));
		
		jdbc.getDatabase("SHOW TABLES");
		
		// garbage collect
		System.out.println("\n>>> Garbage collect start");
		jdbc = null;
		System.gc();
		return;
	}
}
