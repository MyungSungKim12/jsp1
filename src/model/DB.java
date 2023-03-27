package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection CON;
	   static {
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "1234");
	         System.out.println("접속성공");
	      } catch (Exception e) {
	         System.out.println("접속실패:" + e.toString());
	      }
	   }

}
