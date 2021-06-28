
package Jframes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tohid Shop
 */
public class databaseconnection {
    
    
     static Connection con=null;
     
     public static Connection getConnection(){
         
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/library_manage","root","34313431");
         }
         catch(Exception e){
             e.printStackTrace();
         }
      return con; 
     }
}
