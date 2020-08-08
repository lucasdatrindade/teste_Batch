package teste_Batch;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
   private static Connection conn = null;
   
   public static Connection getConnection(){
	   //String url = "jdbc:mysql://localhost:3306/test";
	   String url = "jdbc:mysql://localhost:8889/test";
	   try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		   conn = DriverManager.getConnection(url,"root","root");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return conn;
   }
}
