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
		// if ((rs = stmt.executeQuery("SHOW TABLES")) != null) {
		// rs = stmt.getResultSet();
		// }
		System.out.println("여기");
		try {
			System.out.println("query = " + query);
			// System.out.println("-----------------------");

			// ResultSet rs = stmt.executeQuery(query);

			if (stmt.executeUpdate(query) != 0) {
//				// System.out.println(rs.getNString(1));
//				// System.out.println(rs.getString("이름"));
//				// rs.getString("분류명"));
				return true;
			}
//			stmt.executeUpdate("INSERT INTO 대출(`대출기간`,`회원번호`,`ISBN`) VALUES (CURDATE()+14,3,(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\"명탐정 코난 5\"))");
			// System.out.println("-----------------------");
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean getDBCheck(String query) {
	      // if ((rs = stmt.executeQuery("SHOW TABLES")) != null) {
	      // rs = stmt.getResultSet();
	      // }
	      System.out.println("여기2");
	      try {
	         System.out.println("query = " + query);
	         // System.out.println("-----------------------");

	          ResultSet rs = stmt.executeQuery(query);

	         if (rs.next()) {
	            // System.out.println(rs.getNString(1));
	            // System.out.println(rs.getString("이름"));
	            // rs.getString("분류명"));
	            return true;
	         }
	         // System.out.println("-----------------------");
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