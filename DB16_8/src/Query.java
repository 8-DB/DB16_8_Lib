
public class Query {
	public static String isClient(String client){
	      return "SELECT ȸ����ȣ FROM ȸ�� WHERE `�̸�`=\"" + client + "\"";
	   }
	   public static String isBook(String book){
	      return "SELECT * FROM ���� WHERE `�����̸�`=\"" + book + "\"";
	   }
	   public static String isAlready(String s){
	      return "SELECT * FROM ���� WHERE `ISBN`=(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\""+s+"\") AND `������Ȳ`='Y'";
	   }
	public static String insert����(String client, String book){
		if(client == "���ϸ�")
			return "INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`,`ISBN`) VALUES (CURDATE()+14,"
				+ "1,"
				+ "(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\"" + book + "\"))";
		else if(book == "������")
			return "INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`,`ISBN`) VALUES (CURDATE()+14,"
					+ "2,"
					+ "(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\"" + book + "\"))";
		else
			return "INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`,`ISBN`) VALUES (CURDATE()+14,"
			+ "3,"
			+ "(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\"" + book + "\"))";
	}
}
