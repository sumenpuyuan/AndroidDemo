package Model;

import java.sql.DriverManager;
import java.sql.*;


/**
 *
 * @author lv
 * ����ļ������ݿ�Ļ����ļ�������mysql���ݿ⣬�ر����ݿ�
 *
 */
public class DbBase {
	//�õ�Class.froName����������������
	Connection connection;
	final static String url="jdbc:mysql://121.42.211.211:3306/school?useUnicode=true&characterEncoding=utf8";
	final static String dbType="com.mysql.jdbc.Driver";
	final static String username="root";
	final static String password="Xicheng2016";
	public DbBase(){
		try{
			Class.forName(dbType);
			System.out.println("�ɹ�����MySQL������");
			connection=DriverManager.getConnection(url, username, password);
		//	Statement stmt = connection.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Close(){
		try{
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
