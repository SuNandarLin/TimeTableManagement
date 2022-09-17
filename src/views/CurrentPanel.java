package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class CurrentPanel extends JPanel {
	private JLabel lblCurrentTime;
	private JLabel lblHourMin;
	private JLabel lblCurrentDay;
	private JLabel lblDay;
	private JLabel lblHappyHoliday;
	private JLabel lblBreakTime;
	private JLabel lblBye;
	private JLabel lblMorning;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JTable table1;
	private JTable table2;

	/**
	 * Create the panel.
	 */
	public CurrentPanel() {
		setLayout(null);
		this.setSize(1110,700);
		add(getLblCurrentTime());
		add(getLblHourMin());
		add(getLblCurrentDay());
		add(getLblDay());
		add(getLblBye());
		add(getLblMorning());
		add(getLblBreakTime());
		add(getScrollPane1());
		add(getScrollPane2());
		add(getLblHappyHoliday());

	}
	public JLabel getLblCurrentTime() {
		if (lblCurrentTime == null) {
			lblCurrentTime = new JLabel("Current time :");
			lblCurrentTime.setHorizontalAlignment(SwingConstants.CENTER);
			lblCurrentTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCurrentTime.setBounds(215, 51, 127, 35);
		}
		return lblCurrentTime;
	}
	public JLabel getLblHourMin() {
		if (lblHourMin == null) {
			lblHourMin = new JLabel("Hour:Min");
			lblHourMin.setHorizontalAlignment(SwingConstants.CENTER);
			lblHourMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHourMin.setBounds(352, 52, 93, 35);
		}
		return lblHourMin;
	}
	public JLabel getLblCurrentDay() {
		if (lblCurrentDay == null) {
			lblCurrentDay = new JLabel("Current Day :");
			lblCurrentDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblCurrentDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCurrentDay.setBounds(589, 51, 161, 35);
		}
		return lblCurrentDay;
	}
	public JLabel getLblDay() {
		if (lblDay == null) {
			lblDay = new JLabel(" day");
			lblDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDay.setBounds(752, 51, 83, 35);
		}
		return lblDay;
	}
	public JLabel getLblHappyHoliday() {
		if (lblHappyHoliday == null) {
			lblHappyHoliday = new JLabel("Happy Holiday!");
			lblHappyHoliday.setHorizontalAlignment(SwingConstants.CENTER);
			lblHappyHoliday.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 50));
			lblHappyHoliday.setBounds(309, 177, 462, 50);
		}
		return lblHappyHoliday;
	}
	public JLabel getLblBreakTime() {
		if (lblBreakTime == null) {
			lblBreakTime = new JLabel("BREAK TIME!");
			lblBreakTime.setHorizontalAlignment(SwingConstants.CENTER);
			lblBreakTime.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 50));
			lblBreakTime.setBounds(309, 177, 462, 50);
		}
		return lblBreakTime;
	}
	public JLabel getLblBye() {
		if (lblBye == null) {
			lblBye = new JLabel("Bye Bye!");
			lblBye.setHorizontalAlignment(SwingConstants.CENTER);
			lblBye.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 50));
			lblBye.setBounds(299, 177, 462, 50);
		}
		return lblBye;
	}
	public JLabel getLblMorning() {
		if (lblMorning == null) {
			lblMorning = new JLabel("Good Morning!");
			lblMorning.setHorizontalAlignment(SwingConstants.CENTER);
			lblMorning.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 50));
			lblMorning.setBounds(309, 177, 462, 50);
		}
		return lblMorning;
	}
	public JScrollPane getScrollPane1() {
		if (scrollPane1 == null) {
			scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(181, 123, 666, 104);
			scrollPane1.setViewportView(getTable1());
		}
		return scrollPane1;
	}
	public JScrollPane getScrollPane2() {
		if (scrollPane2 == null) {
			scrollPane2 = new JScrollPane();
			scrollPane2.setBounds(181, 280, 666, 104);
			scrollPane2.setViewportView(getTable2());
		}
		return scrollPane2;
	}
	public JTable getTable1() {
		if (table1 == null) {
			table1 = new JTable();
			table1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return table1;
	}
	public JTable getTable2() {
		if (table2 == null) {
			table2 = new JTable();
			table2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return table2;
	}
}
