package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import support.TimeTableData;

public class DataCurrentDB {
	private MyDBconnection DB=new MyDBconnection();
	
public int getTimeId(int hour,String day){
		
		DB.OpenConnection(); 	
		  Connection c=DB.getMyConnection();
		int timeInt=hour;
		 int timeId = 0;
		 String query="Select timeId from time where day=? and time=?";
		 
		try {
			PreparedStatement stmt = c.prepareStatement(query);
			 stmt.setString(1,day);
			 stmt.setInt(2,timeInt);
				ResultSet rs=stmt.executeQuery();
				
				while (rs.next()){	
					 timeId=rs.getInt(1);					
				}
		} catch (SQLException e) {System.out.println("Error in getting timeId");}
		DB.CloseConnection();	
		return timeId;
		
	}
public ArrayList<String> getSemester(){
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	  ArrayList<String> arrayList=new ArrayList<String>();
	 String query="Select semName from semester;";
	 
	try {
		PreparedStatement stmt = c.prepareStatement(query);
		ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				 arrayList.add(rs.getString(1))	;				
			}
	} catch (SQLException e) {System.out.println("Error in getting semester");}
	DB.CloseConnection();	
	return arrayList;
}
public ArrayList<String> CurrentTimeTable(String sem,int hour,String day){
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	 
	  String Day;
	 Day=day.equals("Thursday") ? day.substring(0,4) :day.substring(0,3);
	 
	  int timeId=getTimeId(hour, Day);
	  ArrayList<String> arrayList=new ArrayList<String>();
		 String query="Select courseName,roomName,teacherName "
			 		+"from course c,room r,time t,teacher te,timetable tt "
			 		+"where tt.semName like ? and tt.timeId=? and c.courseNo=tt.courseNo and "
			 		+ "r.roomNo=tt.roomNo and t.timeId=tt.timeId and te.teacherNo=tt.teacherNo;";	 
		
		try {
			PreparedStatement stmt = c.prepareStatement(query);
			stmt.setString(1,sem+"%");
			stmt.setInt(2,timeId);
			ResultSet rs=stmt.executeQuery();
				
				while (rs.next()){	
					 arrayList.add(rs.getString(1));
					 arrayList.add(rs.getString(2));	
					 arrayList.add(rs.getString(3));	
				}
		} catch (SQLException e) {System.out.println("Error in getting current timetable");}
		DB.CloseConnection();	
		return arrayList;
}
}
