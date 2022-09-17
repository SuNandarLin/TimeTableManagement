package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TimetablePanel extends JPanel {
	private JLabel lblTimeTableCreation;
	private JComboBox comboTime;
	private JComboBox comboDay;
	private JComboBox comboRoom;
	private JComboBox comboTeacher;
	private JComboBox comboCourse;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboSemester;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public TimetablePanel() {
		setLayout(null);
		add(getLblTimeTableCreation());
		add(getComboTime());
		add(getComboDay());
		add(getComboRoom());
		add(getComboTeacher());
		add(getComboCourse());
		add(getBtnAdd());
		add(getScrollPane());
		add(getComboSemester());
		add(getBtnDelete());

	}
	public JLabel getLblTimeTableCreation() {
		if (lblTimeTableCreation == null) {
			lblTimeTableCreation = new JLabel("Time Table Creation");
			lblTimeTableCreation.setHorizontalAlignment(SwingConstants.CENTER);
			lblTimeTableCreation.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblTimeTableCreation.setBounds(440, 11, 288, 49);
		}
		return lblTimeTableCreation;
	}
	public JComboBox getComboTime() {
		if (comboTime == null) {
			comboTime = new JComboBox();
			comboTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboTime.setBounds(21, 164, 138, 26);
		}
		return comboTime;
	}
	public JComboBox getComboDay() {
		if (comboDay == null) {
			comboDay = new JComboBox();
			comboDay.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboDay.setBounds(174, 164, 89, 26);
		}
		return comboDay;
	}
	public JComboBox getComboRoom() {
		if (comboRoom == null) {
			comboRoom = new JComboBox();
			comboRoom.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboRoom.setBounds(21, 211, 199, 32);
		}
		return comboRoom;
	}
	public JComboBox getComboTeacher() {
		if (comboTeacher == null) {
			comboTeacher = new JComboBox();
			comboTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboTeacher.setBounds(21, 262, 199, 32);
		}
		return comboTeacher;
	}
	public JComboBox getComboCourse() {
		if (comboCourse == null) {
			comboCourse = new JComboBox();
			comboCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboCourse.setBounds(21, 314, 199, 32);
		}
		return comboCourse;
	}
	public JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("ADD");
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnAdd.setBounds(21, 373, 103, 42);
		}
		return btnAdd;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(290, 92, 784, 497);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return table;
	}
	public JComboBox getComboSemester() {
		if (comboSemester == null) {
			comboSemester = new JComboBox();
			comboSemester.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboSemester.setBounds(21, 111, 242, 32);
		}
		return comboSemester;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("DELETE");
			btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnDelete.setBounds(138, 373, 103, 42);
		}
		return btnDelete;
	}
}
