import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JLabel;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import java.awt.Color;


public class GUI extends JFrame {
	private JScrollPane scrollPane = new JScrollPane();
	public JTextArea Resultat = new JTextArea();
	private JPanel contentPane;
	private JTextField Fromtext  = new JTextField();
	private JTextField Totext  = new JTextField();
	public static SearchThread s;
	public final JTextField stationTxt = new JTextField();
	//public static Thread t;
	//public static Thread t2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					s= new SearchThread(frame);
					//s.start();
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
	public GUI() {
		stationTxt.setBounds(10, 18, 222, 20);
		stationTxt.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("S\u00F6k");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//s.running=true;
			
				if(stationTxt.getText().equals("")){
					final String Lund="81216",Malmö="80000";
					String text1= Fromtext.getText();
					String text2= Totext.getText();
					
		
					
					
					//Constats tar in 3 parametrar första är id nummer för malmöc och andra id nummer för lundc och 20 är antal resultat, returnar string till searchString
					String searchURL = Constants.getURL(text1,text2,20); //Malmö C = 80000,  Lund C, 81216 Malmö Gatorg 80100, Hässleholm C 93070
					System.out.println(searchURL);
					System.out.println("// Results when searching:");
					
					//Parser.getJourneys(searchURL);
					ParserThread t=new ParserThread(GUI.this,searchURL);
					t.start();
					 
				}else{
					
					StationThread t2=new StationThread(GUI.this);
					t2.start();
					
						
				}
			Resultat.setText("searching...");
				
	
				
	
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(10, 49, 453, 23);
		contentPane.add(btnNewButton);
		
		
		scrollPane.setBounds(10, 78, 453, 173);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(Resultat);
	
		Fromtext.setBounds(242, 18, 104, 20);
		contentPane.add(Fromtext);
		Fromtext.setColumns(10);
		
		
		Totext.setColumns(10);
		Totext.setBounds(356, 18, 107, 20);
		contentPane.add(Totext);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(new Color(255, 255, 255));
		lblFrom.setBounds(242, 0, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel To = new JLabel("To");
		To.setForeground(new Color(255, 255, 255));
		To.setBounds(356, 0, 24, 14);
		contentPane.add(To);
		
		contentPane.add(stationTxt);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setForeground(new Color(255, 255, 255));
		lblStation.setBounds(10, 0, 46, 14);
		contentPane.add(lblStation);
	}
}
