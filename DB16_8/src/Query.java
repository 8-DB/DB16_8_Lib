
public class Query {
	public static String isClient(String client){
	      return "SELECT 회원번호 FROM 회원 WHERE `이름`=\"" + client + "\"";
	   }
	   public static String isBook(String book){
	      return "SELECT * FROM 도서 WHERE `도서이름`=\"" + book + "\"";
	   }
	   public static String isAlready(String s){
	      return "SELECT * FROM 대출 WHERE `ISBN`=(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\""+s+"\") AND `대출현황`='Y'";
	   }
	public static String insert대출(String client, String book){
		if(client == "김일리")
			return "INSERT INTO 대출 (`대출기간`,`회원번호`,`ISBN`) VALUES (CURDATE()+14,"
				+ "1,"
				+ "(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\"" + book + "\"))";
		else if(book == "유은재")
			return "INSERT INTO 대출 (`대출기간`,`회원번호`,`ISBN`) VALUES (CURDATE()+14,"
					+ "2,"
					+ "(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\"" + book + "\"))";
		else
			return "INSERT INTO 대출 (`대출기간`,`회원번호`,`ISBN`) VALUES (CURDATE()+14,"
			+ "3,"
			+ "(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\"" + book + "\"))";
	}
}
