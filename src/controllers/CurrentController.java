package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import database.DataCurrentDB;
import support.MultiLineCellRenderer;
import support.MyTableModel;
import views.CurrentPanel;

public class CurrentController {
CurrentPanel panel; 
DataCurrentDB mydata=new DataCurrentDB();
	public CurrentController(CurrentPanel panel){
		this.panel=panel;
		HolidayOrNot();
		ShowCurrentTable();
	}
	
    public void HolidayOrNot(){
    	String[] dayNameOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
                "Thursday", "Friday", "Saturday"};
    	Calendar calendar = new GregorianCalendar();
    	 Calendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR),
    			  calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
    	 String day=dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK) - 1];
    	 int AM_PM=calendar.get(Calendar.AM_PM);
    	 int hour=calendar.get(Calendar.HOUR);
         int min=calendar.get(Calendar.MINUTE);
         String hourStr,minStr;
         hourStr=String.valueOf(hour);
         minStr=String.valueOf(min);
         if(hour<10) hourStr="0"+hour;
         if(min<10) minStr="0"+min;
        	
         this.panel.getLblHourMin().setText(hourStr+":"+minStr);
         this.panel.getLblDay().setText(day);
         
    	 if(day.equals("Sunday") || day.equals("Saturday")){
    		 this.panel.getScrollPane1().setVisible(false);
    		 this.panel.getScrollPane2().setVisible(false);
    		 this.panel.getLblBreakTime().setVisible(false);
    		 this.panel.getLblBye().setVisible(false);
    		 this.panel.getLblMorning().setVisible(false);
    		 this.panel.getLblHappyHoliday().setVisible(true);
    	 }else if((hour>=5 && AM_PM==1) || (hour<=6 && AM_PM==0)) {
    		 this.panel.getScrollPane1().setVisible(false);
    		 this.panel.getScrollPane2().setVisible(false);
    		 this.panel.getLblBreakTime().setVisible(false);
    		 this.panel.getLblHappyHoliday().setVisible(false);
    		 this.panel.getLblMorning().setVisible(false);
    		 this.panel.getLblBye().setVisible(true);
    		 
    	 }else if(hour>6 && hour<8 && AM_PM==0){
    		 this.panel.getScrollPane1().setVisible(false);
    		 this.panel.getScrollPane2().setVisible(false);
    		 this.panel.getLblBreakTime().setVisible(false);
    		 this.panel.getLblHappyHoliday().setVisible(false);
    		 this.panel.getLblBye().setVisible(false);
    		 this.panel.getLblMorning().setVisible(true);
    	 }else if(hour==0 || min>=50){
    		 this.panel.getScrollPane1().setVisible(false);
    		 this.panel.getScrollPane2().setVisible(false);
    		 this.panel.getLblHappyHoliday().setVisible(false);
    		 this.panel.getLblBye().setVisible(false);
    		 this.panel.getLblMorning().setVisible(false);
    		 this.panel.getLblBreakTime().setVisible(true);
    	 }else{
    		 this.panel.getLblHappyHoliday().setVisible(false);
    		 this.panel.getLblBreakTime().setVisible(false);
    		 this.panel.getLblBye().setVisible(false);
    		 this.panel.getLblMorning().setVisible(false);
    		 this.panel.getScrollPane1().setVisible(true);
    		 this.panel.getScrollPane2().setVisible(true);    		 
    	 }
    	 
    }
	public String getCurrentDate(){
    	String[] dayNameOfWeek = {"Sun", "Monday", "Tuesday", "Wednesday", 
                "Thursday", "Friday", "Saturday"};
    	Calendar calendar = new GregorianCalendar();
    	 int hour=calendar.get(Calendar.HOUR);
         int min=calendar.get(Calendar.MINUTE);
    	 Calendar calendar1 = new GregorianCalendar(calendar.get(Calendar.YEAR),
    			  calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
    	
    	 String day=dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK) - 1];         
        
        return day;
    }
	public void ShowCurrentTable(){
		String[] columns1={"First year","Second year","Third year"};
		String[] columns2={"Fourth year","Fifth year","Final year"};
		
		 int rowCount=1, colCount=3; String bn="\n  ";
		 
			MyTableModel mytable1=new MyTableModel();
			MyTableModel mytable2=new MyTableModel();
			mytable1.takeRowCol(columns1);
			mytable2.takeRowCol(columns2);
			mytable1.setRowCount(rowCount,colCount);
			mytable2.setRowCount(rowCount,colCount);
			
			String day=getCurrentDate();
			Calendar calendar = new GregorianCalendar();
	    	 int hour=calendar.get(Calendar.HOUR);
			
			for(int i=0;i<columns1.length;i++){
				ArrayList<String> arrayList=new ArrayList<String>();
				arrayList=mydata.CurrentTimeTable(columns1[i], hour, day);
				String str;
				if(!arrayList.isEmpty()){
		str="  "+arrayList.get(0)+bn+arrayList.get(1)+bn+arrayList.get(2);				
				}else{
			str="  ";		
				}
				mytable1.setValueAt(str, 0, i);
			}
			for(int i=0;i<columns2.length;i++){
				ArrayList<String> arrayList=new ArrayList<String>();
				arrayList=mydata.CurrentTimeTable(columns2[i], hour, day);
				String str;
				if(!arrayList.isEmpty()){
		str="  "+arrayList.get(0)+bn+arrayList.get(1)+bn+arrayList.get(2);				
				}else{
			str="  ";		
				}
				mytable2.setValueAt(str, 0, i);
			}
			
			this.panel.getTable1().setModel(mytable1);
			this.panel.getTable2().setModel(mytable2);
			
			for(int i=0;i<3;i++){
				this.panel.getTable1().getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
				this.panel.getTable2().getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
			}
			this.panel.getTable1().setRowHeight(80);
			this.panel.getTable2().setRowHeight(80);
	}
}
