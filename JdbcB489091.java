
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcB489091 {
	private Connection conn = null;
	private Statement stmt = null;

//	public JdbcB289075(StringBuilder url) {
	public JdbcB489091(JschB489091 jsch) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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

	public void getDatabase(String query) {
		// if ((rs = stmt.executeQuery("SHOW TABLES")) != null) {
		// rs = stmt.getResultSet();
		// }

		try {
			System.out.println("query = " + query);
			System.out.println("-----------------------");
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getNString(1));
//				System.out.println(rs.getString("분류기호") + " " + rs.getString("분류명"));
			}
			System.out.println("-----------------------");

		} catch (SQLException e) {
			e.printStackTrace();
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
