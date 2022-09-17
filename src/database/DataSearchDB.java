package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import support.TimeTableData;
import views.SearchPanel;

public class DataSearchDB {
	private MyDBconnection DB=new MyDBconnection();
	
public ArrayList<TimeTableData> searchTrRoom(String name,char ch){
	 DB.OpenConnection();
	  Connection c=DB.getMyConnection();
	  
	 ArrayList<TimeTableData> arrayList=new ArrayList();
	 int time = 0;
	 String query="";
	 if(ch=='t')	{	 
	query="Select semName,courseName,roomName,time,teacherName,day "
			+ "from timetable tt,course c,room r,teacher t,time ti "
			+ "where c.courseNo=tt.courseNo and r.roomNo=tt.roomNo and "
			+ "t.teacherNo=tt.teacherNo and ti.timeId=tt.timeId and teacherName=?;";	
	 } else if(ch=='r'){
		query="Select semName,courseName,roomName,time,teacherName,day "
					+ "from timetable tt,course c,room r,teacher t,time ti "
					+ "where c.courseNo=tt.courseNo and r.roomNo=tt.roomNo and "
					+ "t.teacherNo=tt.teacherNo and ti.timeId=tt.timeId and r.roomName=?;";
	 }else if(ch=='i'){
		 time=Integer.parseInt(name.substring(0,name.indexOf(":")));
		 query="Select semName,courseName,roomName,time,teacherName,day "
					+ "from timetable tt,course c,room r,teacher t,time ti "
					+ "where c.courseNo=tt.courseNo and r.roomNo=tt.roomNo and "
					+ "t.teacherNo=tt.teacherNo and ti.timeId=tt.timeId and ti.time=?;";
	 }
	   try {
					
		PreparedStatement stmt=c.prepareStatement(query);
		if(ch=='i') stmt.setInt(1,time);
		else	stmt.setString(1,name);
		ResultSet rs=stmt.executeQuery();
		
		while (rs.next()){	
			TimeTableData dataObj=new TimeTableData();
			dataObj.setSem(rs.getString(1));
			dataObj.setCourse(rs.getString(2));
			dataObj.setRoom(rs.getString(3));
			dataObj.setTime(rs.getInt(4));
			dataObj.setTeacher(rs.getString(5));
			dataObj.setDay(rs.getString(6));
			arrayList.add(dataObj);
		}
	
	} catch (SQLException e) {}
	   DB.CloseConnection();	  
	return arrayList;
}

}
