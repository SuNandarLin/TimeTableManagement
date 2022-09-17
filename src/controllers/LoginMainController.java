package controllers;


import views.LoginMainFrame;
import views.LoginPanel;




public class LoginMainController {
	LoginMainFrame mainframe;

	public LoginMainController(LoginMainFrame mainframe){
		this.mainframe=mainframe;
		
		LoginPanel panel=new LoginPanel();	
		panel.setSize(500, 500);
		panel.setVisible(true);
		new LoginController(panel,this.mainframe);
		this.mainframe.getContentPane().add(panel);
		
	}
}
