
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
			return "INSERT INTO ���� (`����Ⱓ`,`ȸ����ȣ`,`ISBN`) VALUES (CURDATE()+14," // ����Ⱓ= ����κ��� 14�� �� ����
				+ "(SELECT ȸ����ȣ FROM ȸ�� WHERE `�̸�`=\"" + client + "\"),"
				+ "(SELECT `ISBN` FROM ���� WHERE `�����̸�`=\"" + book + "\"))";
	}
}
