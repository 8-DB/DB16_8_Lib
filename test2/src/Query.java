
public class Query {
//	public static String isClient(String client){
//		return "SELECT * FROM 회원 WHERE `이름`=\"" + client + "\"";
//	}
//	public static String isBook(String book){
//		return "SELECT * FROM 도서 WHERE `도서이름`=\"" + book + "\"";
//	}
	public static String insert대출(String client, String book){
		return "INSERT INTO 대출 (`대출기간`,`회원번호`,`ISBN`) VALUES (CURDATE()+14,"
				+ "(SELECT `회원번호` FROM 회원 WHERE `이름`=\"" + client + "\"),"
				+ "(SELECT `ISBN` FROM 도서 WHERE `도서이름`=\"" + book + "\"))";
	}
}
