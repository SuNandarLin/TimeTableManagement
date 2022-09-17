package controllers;


import support.MultiLineCellRenderer;
import support.TimeTableData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import database.DataSourceDB;
import support.MyTableModel;
import views.TimetablePanel;

public class TimetableController {
TimetablePanel panel;
String[] columns={"Monday","Tuesday","Wednesday","Thursday","Friday"};
DataSourceDB mydata=new DataSourceDB();
//MultiLineCellRenderer multiLine;

	public TimetableController(TimetablePanel panel){
		this.panel=panel;		
		comboShow1();
		comboShow2();
		ShowTable();
		
	this.panel.getBtnAdd().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			AddTimeTable();	
			ShowTable();
		}
	});
	this.panel.getBtnDelete().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			deleteTimeTable();
			ShowTable();
			
		}
	});
	
	this.panel.getComboSemester().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			comboRoomUpdate();
			comboTeacherUpdate();	
			ShowTable();
			
		}
	});
	this.panel.getComboTime().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			comboRoomUpdate();
			comboTeacherUpdate();			
		}
	});
this.panel.getComboDay().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			comboRoomUpdate();
			comboTeacherUpdate();			
		}
	});
	
	}
public void deleteTimeTable(){
	String day=(String) this.panel.getComboDay().getSelectedItem();
	String time=(String) this.panel.getComboTime().getSelectedItem();
	String sem=(String) this.panel.getComboSemester().getSelectedItem();
	mydata.delete(time, day,sem);
}
public void AddTimeTable(){
	String teacher=(String) this.panel.getComboTeacher().getSelectedItem();
	String room=(String) this.panel.getComboRoom().getSelectedItem();
	String course=(String) this.panel.getComboCourse().getSelectedItem();
	String day=(String) this.panel.getComboDay().getSelectedItem();
	String time=(String) this.panel.getComboTime().getSelectedItem();
	
	String sem=(String) this.panel.getComboSemester().getSelectedItem();	
	mydata.AddTimeTable(teacher, course, room,  sem, day, time);
	
	}
public void ShowTable(){
	
	String semName=(String) this.panel.getComboSemester().getSelectedItem();
	
	ArrayList<Integer> arrayInt=new ArrayList<Integer>();
	ArrayList<String> arrayData=new ArrayList<String>();
	arrayInt=mydata.getTimeIdFromSem(semName);
	 	 
	 int rowCount=9, colCount=5 ,timeInt=0; String bn="\n  ";
	MyTableModel mytable=new MyTableModel();
	mytable.takeRowCol(columns);
	mytable.setRowCount(rowCount,colCount);
		
for(int j=0;j<colCount;j++){
	for(int i=0;i<rowCount;i++){
		timeInt++;
		String str;
	arrayData=mydata.ShowTable(semName, timeInt);
	if(arrayData!=null ) {
	str="  "+arrayData.get(0)+bn+arrayData.get(1)+bn+arrayData.get(2)+bn+arrayData.get(3);
	mytable.setValueAt(str, i, j);
	}else{
		if(i!=4)mytable.setValueAt(" ", i, j);
		else mytable.setValueAt("\n BREAK TIME \n 12:00-12:50 ", i, j);		
	}
	}
	}
this.panel.getTable().setModel(mytable);
for(int i=0;i<5;i++)
	this.panel.getTable().getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
this.panel.getTable().setRowHeight(90);
}
public void comboTeacherUpdate(){
	String time=(String) this.panel.getComboTime().getSelectedItem();
	String day=(String) this.panel.getComboDay().getSelectedItem();
	String semester=(String) this.panel.getComboSemester().getSelectedItem();
	String Sem=firstOrSecond(semester);
	 ArrayList<String> teacherArrayList=new ArrayList();
	 ArrayList<String> teacherUpdateArray=new ArrayList();
	 teacherArrayList=mydata.ShowCombo('t');
	 teacherUpdateArray=mydata.comboTeacherUpdate(time, day,Sem);
	 
	 if(teacherArrayList!=null && !teacherUpdateArray.isEmpty()){	
		 panel.getComboTeacher().removeAllItems();
			for(int i=0;i<teacherArrayList.size();i++){
				for(int j=0;j<teacherUpdateArray.size();j++){
					if(teacherUpdateArray.get(j).equals(teacherArrayList.get(i)))
						teacherArrayList.remove(i);
				}
						
			}
			for(int i=0;i<teacherArrayList.size();i++){
				panel.getComboTeacher().addItem(teacherArrayList.get(i));
			}
	 }else if(teacherArrayList!=null)comboShow2();
	 
}
public void comboRoomUpdate(){
	String time=(String) this.panel.getComboTime().getSelectedItem();
	String day=(String) this.panel.getComboDay().getSelectedItem();
	String semester=(String) this.panel.getComboSemester().getSelectedItem();
	String Sem=firstOrSecond(semester);
	 ArrayList<String> roomArrayList=new ArrayList();
	 ArrayList<String> roomUpdateArray=new ArrayList();
	 roomArrayList=mydata.ShowCombo('r');
	 roomUpdateArray=mydata.comboRoomUpdate(time, day,Sem);
	 
	 if(roomArrayList!=null && !roomUpdateArray.isEmpty()){
		 panel.getComboRoom().removeAllItems();
			for(int i=0;i<roomArrayList.size();i++){
				for(int j=0;j<roomUpdateArray.size();j++){
					if(roomUpdateArray.get(j).equals(roomArrayList.get(i)))
						roomArrayList.remove(i);
				}
			}
			for(int i=0;i<roomArrayList.size();i++){
				panel.getComboRoom().addItem(roomArrayList.get(i)); }
	 }else if(roomArrayList!=null)comboShow2();

}
public void comboShow1(){		
	
	ArrayList<String> hourArrayList=new ArrayList();
	hourArrayList=mydata.ShowCombo('h');
	 panel.getComboTime().removeAllItems();
	 if(hourArrayList!=null ){
		for(int i=0;i<hourArrayList.size();i++){
			String hour=hourArrayList.get(i);
			if(!hour.equals("12"))
			panel.getComboTime().addItem(hour+":00-"+hour+":50");
		}
	 }
	 
	 ArrayList<String> dayArrayList=new ArrayList();
	 dayArrayList=mydata.ShowCombo('d');
		panel.getComboDay().removeAllItems();
		 if(dayArrayList!=null ){
			for(int i=0;i<dayArrayList.size();i++)
				panel.getComboDay().addItem(dayArrayList.get(i));
		 }
	
	ArrayList<String> semArrayList=new ArrayList();
	semArrayList=mydata.ShowCombo('s');
	panel.getComboSemester().removeAllItems();
	 if(semArrayList!=null ){
		for(int i=0;i<semArrayList.size();i++)
			panel.getComboSemester().addItem(semArrayList.get(i));
	 }
	 ArrayList<String> courseArrayList=new ArrayList();
		courseArrayList=mydata.ShowCombo('c');
		panel.getComboCourse().removeAllItems();
		if(courseArrayList!=null ){
			for(int i=0;i<courseArrayList.size();i++)
				 panel.getComboCourse().addItem(courseArrayList.get(i));			
		 }
 }
public void comboShow2(){
	 ArrayList<String> teacherArrayList=new ArrayList();
	 teacherArrayList=mydata.ShowCombo('t');
	 panel.getComboTeacher().removeAllItems();
	 if(teacherArrayList!=null ){
		for(int i=0;i<teacherArrayList.size();i++)
			panel.getComboTeacher().addItem(teacherArrayList.get(i));
	 }
			
					
	ArrayList<String> roomArrayList=new ArrayList();
	roomArrayList=mydata.ShowCombo('r');
	panel.getComboRoom().removeAllItems();
	if(roomArrayList!=null ){
		for(int i=0;i<roomArrayList.size();i++)
			panel.getComboRoom().addItem(roomArrayList.get(i));
		}
}
public String firstOrSecond(String sem){
	String semester;
	int semNo=mydata.getSemNo(sem);
	int firOrSec=semNo%10;
	if(firOrSec==1) semester="First Semester";
	else semester="Second Semester";
	
	return semester;
}
}
