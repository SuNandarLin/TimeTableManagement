package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.DataSourceDB;
import views.UpdatePanel;

public class UpdateController {
UpdatePanel panel;
DataSourceDB addDB=new DataSourceDB();
	public UpdateController(UpdatePanel panel){
		this.panel=panel;
		
		panel.getBtnTeacher().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addTeacher();
				
			}
		});
		panel.getBtnCourse().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addCourse();
				
			}
		});
		panel.getBtnRoomNo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addRoom();
				
			}
		});
		
	}
	void addTeacher(){
		String teacher=panel.getTxtTeacher().getText();		
		addDB.AddTeacher(teacher);
		JOptionPane.showMessageDialog(this.panel,"Save Success!","Information",JOptionPane.INFORMATION_MESSAGE);
	}
	void addCourse(){
		String course=panel.getTxtCourse().getText();		
		addDB.AddCourse(course);
		JOptionPane.showMessageDialog(this.panel,"Save Success!","Information",JOptionPane.INFORMATION_MESSAGE);
	}
	void addRoom(){
		String room=panel.getTxtRoom().getText();		
		addDB.AddRoom(room);
		JOptionPane.showMessageDialog(this.panel,"Save Success!","Information",JOptionPane.INFORMATION_MESSAGE);
	}
}
