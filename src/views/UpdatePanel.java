package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdatePanel extends JPanel {
	private JLabel lblAddingdata;
	private JLabel lblnewTeacher;
	private JTextField txtTeacher;
	private JButton btnTeacher;
	private JLabel lblCourse;
	private JTextField txtCourse;
	private JButton btnCourse;
	private JLabel lblRoomNo;
	private JTextField txtRoom;
	private JButton btnRoomNo;

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);
		add(getLblAddingdata());
		add(getLblnewTeacher());
		add(getTxtTeacher());
		add(getBtnTeacher());
		add(getLblCourse());
		add(getTxtCourse());
		add(getBtnCourse());
		add(getLblRoomNo());
		add(getTxtRoom());
		add(getBtnRoomNo());
		this.setSize(1110,700);
		
		
		

	}
	public JLabel getLblAddingdata() {
		if (lblAddingdata == null) {
			lblAddingdata = new JLabel("Adding Data");
			lblAddingdata.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddingdata.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblAddingdata.setBounds(404, 40, 201, 44);
		}
		return lblAddingdata;
	}
	public JLabel getLblnewTeacher() {
		if (lblnewTeacher == null) {
			lblnewTeacher = new JLabel("New Teacher");
			lblnewTeacher.setHorizontalAlignment(SwingConstants.CENTER);
			lblnewTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblnewTeacher.setBounds(223, 120, 137, 38);
		}
		return lblnewTeacher;
	}
	public JTextField getTxtTeacher() {
		if (txtTeacher == null) {
			txtTeacher = new JTextField();
			txtTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtTeacher.setBounds(384, 120, 254, 38);
			txtTeacher.setColumns(10);
		}
		return txtTeacher;
	}
	public JButton getBtnTeacher() {
		if (btnTeacher == null) {
			btnTeacher = new JButton("ADD");
			btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnTeacher.setBounds(716, 120, 89, 38);
		}
		return btnTeacher;
	}
	public JLabel getLblCourse() {
		if (lblCourse == null) {
			lblCourse = new JLabel("Course");
			lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
			lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCourse.setBounds(237, 207, 137, 38);
		}
		return lblCourse;
	}
	public JTextField getTxtCourse() {
		if (txtCourse == null) {
			txtCourse = new JTextField();
			txtCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtCourse.setColumns(10);
			txtCourse.setBounds(384, 207, 254, 38);
		}
		return txtCourse;
	}
	public JButton getBtnCourse() {
		if (btnCourse == null) {
			btnCourse = new JButton("ADD");
			btnCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnCourse.setBounds(716, 207, 89, 38);
		}
		return btnCourse;
	}
	public JLabel getLblRoomNo() {
		if (lblRoomNo == null) {
			lblRoomNo = new JLabel("Room No.");
			lblRoomNo.setHorizontalAlignment(SwingConstants.CENTER);
			lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblRoomNo.setBounds(237, 304, 123, 38);
		}
		return lblRoomNo;
	}
	public JTextField getTxtRoom() {
		if (txtRoom == null) {
			txtRoom = new JTextField();
			txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtRoom.setColumns(10);
			txtRoom.setBounds(384, 304, 254, 38);
		}
		return txtRoom;
	}
	public JButton getBtnRoomNo() {
		if (btnRoomNo == null) {
			btnRoomNo = new JButton("ADD");
			btnRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRoomNo.setBounds(716, 304, 89, 38);
		}
		return btnRoomNo;
	}
}
