package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBconnection {
	public Connection myConnection;
	
	public void OpenConnection(){
		try {
			Class.forName(myDatabase.driverName);
			myConnection=DriverManager.getConnection(myDatabase.URL,
					myDatabase.user_name, myDatabase.user_password);
		} catch (Exception e) {}
	}
	
	public void CloseConnection(){
		try {
			myConnection.close();
		} catch (Exception e) {}
	}

	public Connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(Connection myConnection) {
		this.myConnection = myConnection;
	}
	
	
}
