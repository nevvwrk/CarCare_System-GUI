package CarCare;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnect {

		public static Connection getConnection() {
		try {
			Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
			return DriverManager.getConnection("jdbc:mysql://localhost/carcare?useUnicode=true&characterEncoding=utf-8","root","new2011591");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
	
}
