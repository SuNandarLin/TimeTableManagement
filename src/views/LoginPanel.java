package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {
	private JLabel lblClassTimeTable;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JPasswordField loginPassword;

	public LoginPanel() {
		setLayout(null);
		add(getLblClassTimeTable());
		add(getLblName());
		add(getTxtName());
		add(getLblPassword());
		add(getBtnLogIn());
		this.setSize(1110,700);
		add(getLoginPassword());

	}
	public JLabel getLblClassTimeTable() {
		if (lblClassTimeTable == null) {
			lblClassTimeTable = new JLabel("Class Time Table");
			lblClassTimeTable.setHorizontalAlignment(SwingConstants.CENTER);
			lblClassTimeTable.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblClassTimeTable.setBounds(187, 49, 246, 46);
		}
		return lblClassTimeTable;
	}
	public JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblName.setBounds(99, 143, 69, 19);
		}
		return lblName;
	}
	public JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtName.setBounds(214, 140, 234, 37);
			txtName.setColumns(10);
		}
		return txtName;
	}
	public JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPassword.setBounds(99, 196, 96, 30);
		}
		return lblPassword;
	}
	public JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnLogIn.setBounds(225, 275, 143, 46);
		}
		return btnLogIn;
	}
	public JPasswordField getLoginPassword() {
		if (loginPassword == null) {
			loginPassword = new JPasswordField();
			loginPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
			loginPassword.setBounds(214, 196, 234, 37);
		}
		return loginPassword;
	}
}
