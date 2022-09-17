package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.LoginDB;
import views.LoginMainFrame;
import views.LoginPanel;
import views.MainFrame;

public class LoginController {
	LoginPanel panel;
	LoginMainFrame myframe;
	
	public LoginController(LoginPanel panel,LoginMainFrame loginFrame){
		this.panel=panel;
		this.myframe=loginFrame;
		
		
		panel.getBtnLogIn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				login();
				
			}
		});
	}
	public void login(){
		String name=this.panel.getTxtName().getText();
		String password=this.panel.getLoginPassword().getText();
		LoginDB loginDB=new LoginDB();
		String loginCheck=loginDB.LoginCheck(name,password);
		if(loginCheck!=null){
			
	myframe.dispose();
			MainFrame frame=new MainFrame();
			frame.mainFrame();	
			
			
		}else{
			JOptionPane.showMessageDialog(panel,"Login Failed!\nUser name or password is wrong!");

		}
		
	}
}
