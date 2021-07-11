
package Jframes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sina
 */
public class databaseconnection {
    
    
     static Connection con=null;
     
     public static Connection getConnection(){
         
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","oracle123");
         }
         catch(Exception e){
             e.printStackTrace();
         }
      return con; 
     }
}
