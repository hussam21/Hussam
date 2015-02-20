import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;


public class digitalClockGUI extends JFrame {

	public JPanel contentPane;
	public ClockLogic clocklogic;

	JButton btnSetAlarm = new JButton("Set Alarm");
	JButton btnClearAlarm = new JButton("Clear alarm");
	JLabel lblHours = new JLabel("Hours");
	JLabel lblMinutes = new JLabel("Minutes");
	public JTextArea textArea = new JTextArea();
	public JTextArea textArea_1 = new JTextArea();
	JLabel Clock = new JLabel("Clock");
	JLabel alarmAt = new JLabel("alarm");
	private final JLabel image = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					digitalClockGUI frame = new digitalClockGUI();
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
	public digitalClockGUI() {
		
		this.setTitle("Hussams klocka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 305);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		clocklogic= new ClockLogic(this);
		
		
		
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				clocklogic.setAlarm( Integer.parseInt(textArea.getText()), Integer.parseInt(textArea_1.getText()));
				}catch(NumberFormatException e){
					
					System.out.println("cant convert text");
				}
				}
		});
		btnSetAlarm.setBounds(236, 206, 89, 23);
		contentPane.add(btnSetAlarm);

		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clocklogic.clearAlarm();
			}
		});
		
		btnClearAlarm.setBounds(335, 206, 89, 23);
		contentPane.add(btnClearAlarm);
		lblHours.setBounds(10, 210, 46, 14);
		contentPane.add(lblHours);

		lblMinutes.setBounds(117, 210, 46, 14);
		contentPane.add(lblMinutes);

		textArea.setBounds(46, 205, 46, 19);
		contentPane.add(textArea);

		textArea_1.setBounds(169, 205, 46, 19);
		contentPane.add(textArea_1);
		Clock.setFont(new Font("Tahoma", Font.PLAIN, 40));

		Clock.setBounds(138, 61, 187, 65);
		contentPane.add(Clock);

		alarmAt.setBounds(193, 137, 46, 14);
		contentPane.add(alarmAt);
		image.setIcon(new ImageIcon("C:\\Users\\Hussam\\workspace\\Uppgift5\\src\\Images\\untitled.png"));
		image.setBounds(372, 11, 52, 50);
		
		contentPane.add(image);
	}

}
