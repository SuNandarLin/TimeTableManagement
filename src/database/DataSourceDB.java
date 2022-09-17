package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import support.TimeTableData;
import views.TimetablePanel;

public class DataSourceDB {
	TimetablePanel panel;
	private MyDBconnection DB=new MyDBconnection();
	 
public void AddTeacher(String teacher){
	      DB.OpenConnection();  
		  Connection c=DB.getMyConnection();
		 try {
			  c.setAutoCommit(false);
			  String query="insert into Teacher values(null,?);";
			PreparedStatement stmt=c.prepareStatement(query);
			stmt.setString(1, teacher);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {System.out.println("Error in add teacher");}
		  DB.CloseConnection();
	  }
public void AddCourse(String course){
	      DB.OpenConnection();  
		  Connection c=DB.getMyConnection();
		 try {
			  c.setAutoCommit(false);
			  String query="insert into Course values(null,?);";
			PreparedStatement stmt=c.prepareStatement(query);
			stmt.setString(1, course);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {System.out.println("Error in add course");}
		  DB.CloseConnection();
	  }
public void AddRoom(String room){
	      DB.OpenConnection();  
		  Connection c=DB.getMyConnection();
		 try {
			  c.setAutoCommit(false);
			  String query="insert into Room values(null,?);";
			PreparedStatement stmt=c.prepareStatement(query);
			stmt.setString(1, room);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {System.out.println("Error in add room");}
		  DB.CloseConnection();
	  }
public ArrayList<String> ShowCombo(char ch){
		 
		  DB.OpenConnection();
		  Connection c=DB.getMyConnection();
		 ArrayList<String> arrayList=new ArrayList();
		 int index=0; 
		 String query="";
		 if(ch=='t')query="Select teacherName from Teacher ;";
		 else if(ch=='c')query="Select courseName from Course ;";
		 else if(ch=='r')query="Select roomName from Room ;";
		 else if(ch=='s')query="Select semName from semester ;";
		 else if(ch=='h')query="Select time from time where timeId<10;";
		 else if(ch=='d')query="Select day from time group by day;";
		 	
		   try {
						
			PreparedStatement stmt=c.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				arrayList.add(index, rs.getString(1));
				index++;
			}
		
		} catch (SQLException e) {}
		   DB.CloseConnection();	  
		return arrayList;
	  }
public int getTimeId(String time,String day){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	int timeInt=Integer.parseInt(time.substring(0,time.indexOf(":")));
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
public int getSemNo(String sem){
		
	  int semNo = 0;
	  
		if(sem.equals("First year First Semester")) semNo=11;
		else if(sem.equals("First year Second Semester")) semNo=12;
		else if(sem.equals("Second year First Semester")) semNo=21;
		else if(sem.equals("Second year Second Semester")) semNo=22;
		else if(sem.equals("Third year First Semester")) semNo=31;
		else if(sem.equals("Third year Second Semester")) semNo=32;
		else if(sem.equals("Fourth year First Semester")) semNo=41;
		else if(sem.equals("Fourth year Second Semester")) semNo=42;
		else if(sem.equals("Fifth year First Semester")) semNo=51;
		else if(sem.equals("Fifth year Second Semester")) semNo=52;
		else if(sem.equals("Final year First Semester")) semNo=61;
		else if(sem.equals("Final year Second Semester")) semNo=62;
		
	 return semNo;
}
public int getTeacherNo(String teacher){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	int teacherNo = 0;
	 String query="Select teacherNo from teacher where teacherName=?";
	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setString(1,teacher);
		 
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				 teacherNo=rs.getInt(1);					
			}
	} catch (SQLException e) {System.out.println("Error in getting teacher No.");}
	DB.CloseConnection();	
	return teacherNo;
	
}
public int getCourseNo(String course){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	int courseNo = 0;
	 String query="Select courseNo from course where CourseName=?";
	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setString(1,course);
		 
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				courseNo=rs.getInt(1);					
			}
	} catch (SQLException e) {System.out.println("Error in getting course No.");}
	DB.CloseConnection();	
	return courseNo;
	
}
public int getRoomNo(String room){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	int roomNo = 0;
	 String query="Select roomNo from room where roomName=?";
	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setString(1,room);
		 
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()){	
				roomNo=rs.getInt(1);					
			}
	} catch (SQLException e) {System.out.println("Error in getting room No.");}
	DB.CloseConnection();	
	return roomNo;
	
}
public void AddTimeTable(String teacher,String course,String room
		,String sem,String day,String time){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	  int teacherNo=getTeacherNo(teacher);
	  int courseNo=getCourseNo(course);
	  int roomNo=getRoomNo(room);
	  int timeId=getTimeId(time, day);
	  int semNo=getSemNo(sem);
	 
		 try {
			
				
			  c.setAutoCommit(false);
			  String query="insert into timetable values(?,?,?,?,?,?);";
			PreparedStatement stmt=c.prepareStatement(query);
			stmt.setInt(1, semNo);
			stmt.setString(2, sem);
			stmt.setInt(3, timeId);
			stmt.setInt(4, teacherNo);
			stmt.setInt(5, courseNo);
			stmt.setInt(6, roomNo);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {System.out.println("Error in adding timetable");}
		  DB.CloseConnection();		  
	  }
public void delete(String time,String day,String sem){
	
	DB.OpenConnection(); 	
	  Connection c=DB.getMyConnection();
	int timeId=getTimeId(time, day);
	String result=null;
	
	 String query="Delete from timetable where timeId=? and semName=?;";		
	 String querySelect="Select teacherNo from timetable where timeId=? and semName=?;";
		try {
			PreparedStatement stmt= c.prepareStatement(querySelect);
			stmt.setInt(1,timeId);
			stmt.setString(2, sem);
			ResultSet rs=stmt.executeQuery();	

	while (rs.next()){	
		result=rs.getString(1);
		
	}
} catch (SQLException e) {System.out.println("Error in select for delete");}
		
		if(result!=null ){
		try {
			PreparedStatement stmt= c.prepareStatement(query);
			stmt.setInt(1,timeId);
			stmt.setString(2, sem);
			stmt.execute();
			JOptionPane.showMessageDialog(panel,"DELETE SUCCESS!");	
		} catch (SQLException e) {
			System.out.println("Error in deleting cell");	
		}	
		}else
JOptionPane.showMessageDialog(panel,"The lecture time you choose does not already exist!");
		
	DB.CloseConnection();	
	
}
public ArrayList<String> ShowTable(String sem,int timeId){

	int semNo=getSemNo(sem);
	DB.OpenConnection(); 	
	 Connection c=DB.getMyConnection();
	 ArrayList<String> arrayList=new ArrayList<String>();
	
	 String query="Select courseName,roomName,time,teacherName "
			 		+"from course c,room r,time t,teacher te,timetable tt "
			 		+"where tt.semName=? and tt.timeId=? and c.courseNo=tt.courseNo and "
			 		+ "r.roomNo=tt.roomNo and t.timeId=tt.timeId and te.teacherNo=tt.teacherNo;";	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setString(1,sem);	
		stmt.setInt(2,timeId);
		ResultSet rs=stmt.executeQuery();	
		
			while (rs.next()){	
				arrayList.add(rs.getString(1));
				arrayList.add(rs.getString(2));
				arrayList.add(rs.getInt(3)+":00-"+rs.getInt(3)+":50");
				arrayList.add(rs.getString(4));
				
			}
	} catch (SQLException e) {System.out.println("Error in getting timetableCell");}
	DB.CloseConnection();	
	return arrayList.equals(null) || arrayList.isEmpty() ? null :arrayList;
	
}
public ArrayList<Integer> getTimeIdFromSem(String sem){
	
	DB.OpenConnection(); 	
	 Connection c=DB.getMyConnection();	 
	ArrayList<Integer> arrayList=new ArrayList();
	 String query="Select timeId from timetable where semName=?;";	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setString(1,sem);	
		ResultSet rs=stmt.executeQuery();	
		
			while (rs.next()){	
				arrayList.add(rs.getInt(1));		
				
			}
	} catch (SQLException e) {System.out.println("Error in getting timeId from semester");}
	DB.CloseConnection();	
	return arrayList;
	
}
public ArrayList<String> comboTeacherUpdate(String time,String day,String sem){
	int timeId=getTimeId(time, day);
	DB.OpenConnection(); 	
	 Connection c=DB.getMyConnection();	 
	ArrayList<String> arrayList=new ArrayList();
	 String query="Select teacherName from teacher t,timetable tt "
	 		+ " where tt.timeId=? and tt.semName like ? and t.teacherNo=tt.teacherNo;";	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setInt(1,timeId);	
		stmt.setString(2,"%"+sem);
		ResultSet rs=stmt.executeQuery();	
		
			while (rs.next()){	
				arrayList.add(rs.getString(1));		
				
			}
	} catch (SQLException e) {System.out.println("Error in getting teacherName for updateCombo");}
	DB.CloseConnection();	
	return arrayList;
}
public ArrayList<String> comboRoomUpdate(String time,String day,String sem){
	int timeId=getTimeId(time, day);
	DB.OpenConnection(); 	
	 Connection c=DB.getMyConnection();	 
	ArrayList<String> arrayList=new ArrayList();
	 String query="Select roomName from room r,timetable tt "
	 		+ " where tt.timeId=? and tt.semName like ? and r.roomNo=tt.roomNo;";	 
	try {
		PreparedStatement stmt= c.prepareStatement(query);
		stmt.setInt(1,timeId);	
		stmt.setString(2,"%"+sem);
		ResultSet rs=stmt.executeQuery();	
		
			while (rs.next()){	
				arrayList.add(rs.getString(1));		
				
			}
	} catch (SQLException e) {System.out.println("Error in getting roomName for updateCombo");}
	DB.CloseConnection();	
	return arrayList;
}
}
