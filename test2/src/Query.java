
public class Query {
//	public static String isClient(String client){
//		return "SELECT * FROM ȸ�� WHERE `�̸�`=\"" + client + "\"";
//	}
//	public static String isBook(String book){
//		return "SELECT * FROM ���� WHERE `�����̸�`=\"" + book + "\"";
//	}
	public static String insert����(String client, String book){
		return "INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`,`ISBN`) VALUES (CURDATE()+14,"
				+ "(SELECT `ȸ����ȣ` FROM ȸ�� WHERE `�̸�`=\"" + client + "\"),"
				+ "(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\"" + book + "\"))";
	}
}