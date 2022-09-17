package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import views.CurrentPanel;
import views.LoginPanel;
import views.MainFrame;
import views.SearchPanel;
import views.TimetablePanel;
import views.UpdatePanel;



public class MainController {
	private MainFrame myView;
	
	public MainController(MainFrame mainframe){
		this.myView=mainframe;
		CallCurrent();	
		this.myView.getMnCurrent().addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				CallCurrent();				
			}			
			@Override
			public void menuDeselected(MenuEvent arg0) {  }			
			@Override
			public void menuCanceled(MenuEvent arg0) {}
		});
		this.myView.getMnTimetable().addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				CallTimetable();
			}			
			@Override
			public void menuDeselected(MenuEvent arg0) {  }			
			@Override
			public void menuCanceled(MenuEvent arg0) {}
		});
		this.myView.getMnUpdate().addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				CallUpdate();				
			}			
			@Override
			public void menuDeselected(MenuEvent arg0) {  }			
			@Override
			public void menuCanceled(MenuEvent arg0) {}
		});
		this.myView.getMnSearch().addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent arg0) {
				CallSearch();
				
			}
			
			@Override
			public void menuDeselected(MenuEvent arg0) {  }			
			@Override
			public void menuCanceled(MenuEvent arg0) {}
		});
		
	}
		
	public void clearOldViews(){
		Component cs[]=this.myView.getContentPane().getComponents();
		for(int i=0;i<cs.length;i++){
			Component c=cs[i];
			c.setVisible(false);
			this.myView.getContentPane().remove(c);
		}
	}
	public void CallCurrent(){
		clearOldViews();
		CurrentPanel panel=new CurrentPanel();
		panel.setSize(1200, 650);
		panel.setVisible(true);
		new CurrentController(panel);
		this.myView.getContentPane().add(panel);
	}
	public void CallTimetable(){
		clearOldViews();
		TimetablePanel panel=new TimetablePanel();
		panel.setSize(1200, 650);
		panel.setVisible(true);
		new TimetableController(panel);
		this.myView.getContentPane().add(panel);
	}
	public void CallUpdate(){
		clearOldViews();
		UpdatePanel panel=new UpdatePanel();
		panel.setSize(1200, 650);
		panel.setVisible(true);
		new UpdateController(panel);
		this.myView.getContentPane().add(panel);
	}
	public void CallSearch(){
		clearOldViews();
		SearchPanel panel=new SearchPanel();
		panel.setSize(1200, 650);
		panel.setVisible(true);
		new SearchController(panel);
		this.myView.getContentPane().add(panel);
	}
	
}