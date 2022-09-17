package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
	private MyDBconnection DB=new MyDBconnection();
	 
	 
	  public String LoginCheck(String name,String pass){
	      DB.OpenConnection();  
		  Connection c=DB.getMyConnection();
		  String loginName = null;
		 try {
			  String query="Select loginName from Login where loginName=? and loginPassword=?;";
			PreparedStatement stmt=c.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				loginName=rs.getString(1);
			}
		} catch (SQLException e) {System.out.println("Error in login");}
		  DB.CloseConnection();
		  return loginName;
	  }
	  
}
