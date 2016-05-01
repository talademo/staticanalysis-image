//STEP 1. Import required packages
import java.sql.*;

public class JDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "username";
   static final String PASS = "password";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;

   while (true){
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      //System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	Thread.sleep(5000);

      //STEP 4: Execute a query
      System.out.println("Listing databases...");
      stmt = conn.createStatement();
      
      String sql = "show databases";
      stmt.executeQuery(sql);
      System.out.println("Listing successful");
   }catch(Exception e){
      //Handle errors for Class.forName
      //e.printStackTrace();
      //System.out.println("JDBC Database(s) running on host: []");
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   }
}//end main
}//end JDBCExample
