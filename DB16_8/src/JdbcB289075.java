import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcB289075 {
	private Connection conn = null;
	private Statement stmt = null;

	public JdbcB289075(JschB289075 jsch) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("\nI need JDBC\nhttp://dev.mysql.com/downloads/connector/j/\n");
			return;
		}

		try {
			conn = DriverManager.getConnection(jsch.connect(jsch.getLport()).toString());
			stmt = conn.createStatement();
			System.out.println("[+] Connection.createStatment()");
			System.out.println(">>> DB connection Success!!\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public boolean getDatabase(String query) {
		System.out.println("여기");
		try {
			System.out.println("query = " + query);
			
			if (stmt.executeUpdate(query) != 0) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean getDBCheck(String query) {
	      System.out.println("여기2");
	      try {
	         System.out.println("query = " + query);
	         
	          ResultSet rs = stmt.executeQuery(query);

	         if (rs.next()) {
	            return true;
	         }
	         
	         return false;
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	      }
	   }

	public void finalize() {
		try {
			stmt.close();
			System.out.println("[-] Statement.close()");
			conn.close();
			System.out.println("[-] Connection.close()");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}