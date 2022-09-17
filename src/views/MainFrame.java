package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.LoginMainController;
import controllers.MainController;

import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCurrent;
	private JMenu mnTimetable;
	private JMenu mnUpdate;
	private JMenu mnSearch;

	/**
	 * Launch the application.
	 */
	public static void mainFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					new MainController(frame);	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		setBounds(0, 0, 1110, 650);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 17));
			menuBar.add(getMnCurrent());
			menuBar.add(getMnTimetable());
			menuBar.add(getMnUpdate());
			menuBar.add(getMnSearch());
		}
		return menuBar;
	}
	public JMenu getMnCurrent() {
		if (mnCurrent == null) {
			mnCurrent = new JMenu("   Current   ");
			mnCurrent.setHorizontalAlignment(SwingConstants.CENTER);
			mnCurrent.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
		}
		return mnCurrent;
	}
	public JMenu getMnTimetable() {
		if (mnTimetable == null) {
			mnTimetable = new JMenu("  Time Table   ");
			mnTimetable.setHorizontalAlignment(SwingConstants.CENTER);
			mnTimetable.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
		}
		return mnTimetable;
	}
	public JMenu getMnUpdate() {
		if (mnUpdate == null) {
			mnUpdate = new JMenu("   Update    ");
			mnUpdate.setHorizontalAlignment(SwingConstants.CENTER);
			mnUpdate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
		}
		return mnUpdate;
	}
	public JMenu getMnSearch() {
		if (mnSearch == null) {
			mnSearch = new JMenu("    Search    ");
			mnSearch.setHorizontalAlignment(SwingConstants.CENTER);
			mnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
		}
		return mnSearch;
	}
}
