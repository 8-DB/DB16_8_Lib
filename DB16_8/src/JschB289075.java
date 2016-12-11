import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JschB289075 {
	private Session session = null;
	private int lport = 0;
	
	public JschB289075(int lport){
		this.lport = lport;
	}
	
	public int getLport(){
		return lport;
	}
	
	public StringBuilder connect(int lport) {
		int assigned_port;

		final String remote_host = "203.249.91.94";
		final int remote_port = 3306; // ssh tunnel
		final String remote_id = "db1_8";
		final String remote_pw = "";
		final int local_port = lport; // new port-forwarding

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(remote_id, remote_host); // ssh
			session.setPassword(remote_pw);

			// Config
			session.setConfig("StrictHostKeyChecking", "no");

			// Connect
			session.connect();
			System.out.println("[+] Session.connect()");

			assigned_port = session.setPortForwardingL(local_port, "127.0.0.1", remote_port); // mysql

		} catch (Exception e) {
			System.err.println(e);
			System.out.println("\nPortForwarding port maight be using\nTry Change or Close past task");
			return null;
		}

		final String db_user = remote_id;
		final String db_password = remote_pw;
		final String default_db = "testdb1_8";

		StringBuilder url = new StringBuilder("jdbc:mysql://localhost:");
		url.append(assigned_port) // port forward
				.append("/").append(default_db) // ues default database
				.append("?user=").append(db_user) // database userID
				.append("&password=").append(db_password) // database userPW
				.append("&useUnicode=yes&characterEncoding=UTF-8"); // UTF8

		return url;
//		new JdbcB289075(url);

	}

	public void finalize() {
		session.disconnect();
		System.out.println("[-] Session.disconnect()");
	}
}
