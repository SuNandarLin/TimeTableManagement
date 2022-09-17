package views;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SearchPanel extends JPanel {
	private JRadioButton rdTeacher;
	private JRadioButton rdRoom;
	private JRadioButton rdTime;
	private JButton btnSearch;
	private JComboBox comboSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblSearchTitle;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		
		setLayout(null);
		add(getRdTeacher());
		add(getRdRoom());
		add(getRdTime());
		add(getBtnSearch());
		add(getComboSearch());
		add(getScrollPane());
		add(getLblSearchTitle());
		this.setSize(1110,700);

	}
	public JRadioButton getRdTeacher() {
		if (rdTeacher == null) {
			rdTeacher = new JRadioButton("Teacher");
			buttonGroup.add(rdTeacher);
			rdTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
			rdTeacher.setBounds(282, 63, 109, 23);
		}
		return rdTeacher;
	}
	public JRadioButton getRdRoom() {
		if (rdRoom == null) {
			rdRoom = new JRadioButton("Room");
			buttonGroup.add(rdRoom);
			rdRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
			rdRoom.setBounds(478, 66, 109, 23);
		}
		return rdRoom;
	}
	public JRadioButton getRdTime() {
		if (rdTime == null) {
			rdTime = new JRadioButton("Time");
			buttonGroup.add(rdTime);
			rdTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
			rdTime.setBounds(685, 63, 109, 23);
		}
		return rdTime;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSearch.setBounds(665, 112, 89, 39);
		}
		return btnSearch;
	}
	public JComboBox getComboSearch() {
		if (comboSearch == null) {
			comboSearch = new JComboBox();
			comboSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
			comboSearch.setBounds(312, 113, 218, 38);
		}
		return comboSearch;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(204, 171, 719, 418);
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
	public JLabel getLblSearchTitle() {
		if (lblSearchTitle == null) {
			lblSearchTitle = new JLabel("Search Timetable");
			lblSearchTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblSearchTitle.setBounds(420, 11, 200, 39);
		}
		return lblSearchTitle;
	}
}
