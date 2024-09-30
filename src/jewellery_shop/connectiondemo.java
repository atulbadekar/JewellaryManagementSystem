package jewellery_shop;
import java.sql.*;
public class connectiondemo {
	
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			System.out.println(1);
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/jewelleryshop","root","Root@123");  
//			System.out.println(2);
			Statement stmt=con.createStatement();  
//			System.out.println(3);

	}catch(Exception e){ System.out.println(e); } 
	}
}                                                                                                                                                                                                                                                                              