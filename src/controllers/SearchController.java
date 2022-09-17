package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import database.DataSearchDB;
import database.DataSourceDB;
import support.MultiLineCellRenderer;
import support.MyTableModel;
import support.TimeTableData;
import views.SearchPanel;

public class SearchController {
SearchPanel panel;
String[] columns={"Monday","Tuesday","Wednesday","Thursday","Friday"};
DataSearchDB mydata=new DataSearchDB();
	public SearchController(final SearchPanel panel){
		this.panel=panel;
		panel.getComboSearch().setVisible(false);
		panel.getScrollPane().setVisible(false);

		
		this.panel.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.getScrollPane().setVisible(true);
				SearchTableShow();				
			}
		});
		this.panel.getRdTime().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.getComboSearch().setVisible(true);
				timeComboShow();
			}
		});
		this.panel.getRdTeacher().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panel.getComboSearch().setVisible(true);
				teacherComboShow();
			}
		});
		this.panel.getRdRoom().addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.getComboSearch().setVisible(true);	
				roomComboShow();				
	}
});
	}
public void timeComboShow(){
	DataSourceDB data=new DataSourceDB();
	ArrayList<String> hourArrayList=new ArrayList();
	hourArrayList=data.ShowCombo('h');
	this.panel.getComboSearch().removeAllItems();
	 if(hourArrayList!=null ){
		for(int i=0;i<hourArrayList.size();i++){
			String hour=hourArrayList.get(i);
			if(!hour.equals("12"))
			panel.getComboSearch().addItem(hour+":00-"+hour+":50");
		}
	 }	
}
public void teacherComboShow(){
	DataSourceDB data=new DataSourceDB();
	ArrayList<String> teacherArrayList=new ArrayList();
	 teacherArrayList=data.ShowCombo('t');
	 panel.getComboSearch().removeAllItems();
	 if(teacherArrayList!=null ){
		for(int i=0;i<teacherArrayList.size();i++)
			panel.getComboSearch().addItem(teacherArrayList.get(i));
	 }
}
public void roomComboShow(){
	DataSourceDB data=new DataSourceDB();
	ArrayList<String> roomArrayList=new ArrayList();
	roomArrayList=data.ShowCombo('r');
	panel.getComboSearch().removeAllItems();
	if(roomArrayList!=null ){
		for(int i=0;i<roomArrayList.size();i++)
			panel.getComboSearch().addItem(roomArrayList.get(i));
		}
}

public ArrayList<TimeTableData>  search(){
		
		 ArrayList<TimeTableData> arrayList=new ArrayList();
		 String search=(String) this.panel.getComboSearch().getSelectedItem();
	if(this.panel.getRdTeacher().isSelected()) arrayList=mydata.searchTrRoom(search,'t');
	if(this.panel.getRdRoom().isSelected()) arrayList=mydata.searchTrRoom(search,'r');
	if(this.panel.getRdTime().isSelected()) arrayList=mydata.searchTrRoom(search,'i');
	
	return arrayList;
		
	}
public int getRowCount(){
		ArrayList<TimeTableData> arrayList=new ArrayList();
		arrayList=search();	
		
		int rowIndex1 = 0,rowIndex2 = 0,rowIndex3 = 0,rowIndex4 = 0,rowIndex5 = 0;
		for(int i=0;i<arrayList.size();i++){
			
			if(arrayList.get(i).getDay().equals("Mon")){
	
				rowIndex1++;				
			}else if(arrayList.get(i).getDay().equals("Tue")){
	
				rowIndex2++;
			}else if(arrayList.get(i).getDay().equals("Wed")){
	
				rowIndex3++;
			}else if(arrayList.get(i).getDay().equals("Thur")){
	
				rowIndex4++;
			}else if(arrayList.get(i).getDay().equals("Fri")){
	
				rowIndex5++;
			}
		}
		ArrayList<Integer> arrayRowCount=new ArrayList<Integer>();
		arrayRowCount.add(rowIndex1);
		arrayRowCount.add(rowIndex2);
		arrayRowCount.add(rowIndex3);
		arrayRowCount.add(rowIndex4);
		arrayRowCount.add(rowIndex5);
		Collections.sort(arrayRowCount);
		int rowCount=arrayRowCount.get(4);
		return rowCount;
	}
	
public void SearchTableShow(){
		
		ArrayList<TimeTableData> arrayList=new ArrayList();
		arrayList=search();	
		int rowCount=getRowCount();
		int colCount=5 ; String bn="\n  ";

		MyTableModel mytable=new MyTableModel();
		mytable.takeRowCol(columns);
		mytable.setRowCount(rowCount,colCount);
		int row1 = 0,row2 = 0,row3 = 0,row4 = 0,row5 = 0;		
		for(int i=0;i<arrayList.size();i++){
			
			if(arrayList.get(i).getDay().equals("Mon")){
				String time=arrayList.get(i).getTime()+":00-"+arrayList.get(i).getTime()+":50";
				String str=" "+arrayList.get(i).getSem()+bn+arrayList.get(i).getCourse()
			+bn+time+bn+arrayList.get(i).getRoom();
				mytable.setValueAt(str, row1, 0);
				row1++;				
			}else if(arrayList.get(i).getDay().equals("Tue")){
				String time=arrayList.get(i).getTime()+":00-"+arrayList.get(i).getTime()+":50";
				String str=" "+arrayList.get(i).getSem()+bn+arrayList.get(i).getCourse()
						+bn+time+bn+arrayList.get(i).getRoom();
				mytable.setValueAt(str, row2, 1);
				row2++;
			}else if(arrayList.get(i).getDay().equals("Wed")){
				String time=arrayList.get(i).getTime()+":00-"+arrayList.get(i).getTime()+":50";
				String str=" "+arrayList.get(i).getSem()+bn+arrayList.get(i).getCourse()
						+bn+time+bn+arrayList.get(i).getRoom();
				mytable.setValueAt(str, row3, 2);
				row3++;
			}else if(arrayList.get(i).getDay().equals("Thur")){
				String time=arrayList.get(i).getTime()+":00-"+arrayList.get(i).getTime()+":50";
				String str=" "+arrayList.get(i).getSem()+bn+arrayList.get(i).getCourse()
						+bn+time+bn+arrayList.get(i).getRoom();
				mytable.setValueAt(str, row4, 3);
				row4++;
			}else if(arrayList.get(i).getDay().equals("Fri")){
				String time=arrayList.get(i).getTime()+":00-"+arrayList.get(i).getTime()+":50";
				String str=" "+arrayList.get(i).getSem()+bn+arrayList.get(i).getCourse()
						+bn+time+bn+arrayList.get(i).getRoom();
				mytable.setValueAt(str, row5, 4);
				row5++;
			}
		}
		this.panel.getTable().setModel(mytable);
		for(int i=0;i<5;i++)
			this.panel.getTable().getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
		this.panel.getTable().setRowHeight(110);
	}
	
}

