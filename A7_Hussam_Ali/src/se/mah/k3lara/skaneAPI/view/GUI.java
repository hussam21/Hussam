package se.mah.k3lara.skaneAPI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	
	@SuppressWarnings("unused")
	private SearchThread t;

	JLabel labelTitle = new JLabel("Ub\u00E5tshallen");
	JLabel lblLinje = new JLabel("Linje");
	JLabel lblNewLabel = new JLabel("Destination");
	JLabel lblNewLabel_1 = new JLabel("Avg\u00E5r");
	JLabel lblLateTitle = new JLabel("F\u00F6rseningar");

	JLabel labelLinje1 = new JLabel("");
	JLabel labelLinje2 = new JLabel("");
	JLabel labelLinje3 = new JLabel("");
	JLabel labelLinje4 = new JLabel("");

	JLabel labelDes1 = new JLabel("");
	JLabel labelDes2 = new JLabel("");
	JLabel labelDes3 = new JLabel("");
	JLabel labelDes4 = new JLabel("");

	JLabel labelTime1 = new JLabel("");
	JLabel labelTime2 = new JLabel("");
	JLabel labelTime3 = new JLabel("");
	JLabel labelTime4 = new JLabel("");
	
	JLabel labelLate1 = new JLabel("");
	JLabel labelLate2 = new JLabel("");
	JLabel labelLate3 = new JLabel("");
	JLabel labelLate4 = new JLabel("");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 236);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		labelTitle.setForeground(Color.WHITE);
		labelTitle.setFont(new Font("Calibri", Font.BOLD, 20));
		labelTitle.setBounds(157, 11, 137, 30);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitle);


		lblLinje.setForeground(Color.WHITE);
		lblLinje.setBounds(10, 57, 46, 14);
		contentPane.add(lblLinje);


		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(88, 57, 93, 14);
		contentPane.add(lblNewLabel);


		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(378, 57, 46, 14);
		contentPane.add(lblNewLabel_1);


		labelLinje1.setForeground(Color.ORANGE);
		labelLinje1.setBounds(10, 82, 46, 14);
		contentPane.add(labelLinje1);


		labelLinje2.setForeground(Color.ORANGE);
		labelLinje2.setBounds(10, 107, 46, 14);
		contentPane.add(labelLinje2);


		labelLinje3.setForeground(Color.ORANGE);
		labelLinje3.setBounds(10, 132, 46, 14);
		contentPane.add(labelLinje3);

		labelLinje4.setForeground(Color.ORANGE);
		labelLinje4.setBounds(10, 157, 46, 14);
		contentPane.add(labelLinje4);

		labelDes1.setForeground(Color.ORANGE);
		labelDes1.setBounds(86, 82, 248, 14);
		contentPane.add(labelDes1);


		labelDes2.setForeground(Color.ORANGE);
		labelDes2.setBounds(88, 107, 248, 14);
		contentPane.add(labelDes2);

		labelDes3.setForeground(Color.ORANGE);
		labelDes3.setBounds(88, 132, 248, 14);
		contentPane.add(labelDes3);

		labelDes4.setForeground(Color.ORANGE);
		labelDes4.setBounds(88, 157, 248, 14);
		contentPane.add(labelDes4);


		labelTime1.setForeground(Color.ORANGE);
		labelTime1.setBounds(376, 82, 150, 14);
		contentPane.add(labelTime1);

		labelTime2.setForeground(Color.ORANGE);
		labelTime2.setBounds(376, 107, 150, 14);
		contentPane.add(labelTime2);

		labelTime3.setForeground(Color.ORANGE);
		labelTime3.setBounds(376, 132, 150, 14);
		contentPane.add(labelTime3);

		labelTime4.setForeground(Color.ORANGE);
		labelTime4.setBounds(376, 157, 150, 14);
		contentPane.add(labelTime4);
		
		lblLateTitle.setForeground(Color.ORANGE);
		lblLateTitle.setBounds(354, 573, 614, 14);
		contentPane.add(lblLateTitle);
		labelLate1.setVisible(false);
		
		labelLate1.setBounds(354, 82, 14, 14);
		labelLate1.setForeground(Color.ORANGE);
		contentPane.add(labelLate1);
		labelLate2.setVisible(false);
		labelLate2.setBounds(354, 107, 13, 14);
		labelLate2.setForeground(Color.ORANGE);
		contentPane.add(labelLate2);
		labelLate3.setVisible(false);
		labelLate3.setBounds(354, 132, 14, 13);
		labelLate3.setForeground(Color.ORANGE);
		contentPane.add(labelLate3);
		labelLate4.setVisible(false);
		labelLate4.setBounds(354, 157, 14, 14);
		labelLate4.setForeground(Color.ORANGE);
		contentPane.add(labelLate4);

	
		UpdateLabels();
		
		
		Thread t = new SearchThread(this);
		t.start();
		System.out.println("Thread started");
	}

	public void UpdateLabels(){
		Calendar cal= Calendar.getInstance();
		Lines lines = Parser.getStationResults(new Station("80046"));

		
		labelLinje1.setText(lines.getLines().get(0).getLine());
		labelLinje2.setText(lines.getLines().get(1).getLine());
		labelLinje3.setText(lines.getLines().get(2).getLine());
		labelLinje4.setText(lines.getLines().get(3).getLine());

		
		labelDes1.setText(lines.getLines().get(0).getDestination());
		labelDes2.setText(lines.getLines().get(1).getDestination());
		labelDes3.setText(lines.getLines().get(2).getDestination());
		labelDes4.setText(lines.getLines().get(3).getDestination());
		
		
		labelTime1.setText(FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)));
		labelTime2.setText(FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.MINUTE)));
		labelTime3.setText(FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.MINUTE)));
		labelTime4.setText(FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.MINUTE)));
		
		if(cal.get(Calendar.HOUR_OF_DAY)==lines.getLines().get(0).getDepTime().get(Calendar.HOUR_OF_DAY) && cal.get(Calendar.MINUTE)+10>=lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)){
			System.out.println(FixThatClock(cal.get(Calendar.MINUTE)-lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)));
			if(lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)-cal.get(Calendar.MINUTE)<=0){
				labelTime1.setText( "0 min");	
			}else{
			labelTime1.setText( String.valueOf(cal.get(Calendar.MINUTE)-lines.getLines().get(0).getDepTime().get(Calendar.MINUTE))+" min");
			}
			
		}

		 if (lines.getLines().get(0).getDepTimeDeviation() != "") {
				JLabel label = new JLabel("");
				label.setForeground(new Color(255, 255, 255));
				label.setBounds(392, 82, 20, 14);
				contentPane.add(label);
				labelLate1.setText(lines.getLines().get(0).getDepTimeDeviation() + " min");
			}
		
		     if (lines.getLines().get(1).getDepTimeDeviation() != "") {
				JLabel label_1 = new JLabel("");
				label_1.setForeground(Color.ORANGE);
				label_1.setBounds(392, 107, 20, 14);
				contentPane.add(label_1);
				labelLate2.setText(lines.getLines().get(1).getDepTimeDeviation() + " min");
			}
		     if (lines.getLines().get(2).getDepTimeDeviation() != "") {
				JLabel label_2 = new JLabel("");
				label_2.setForeground(Color.ORANGE);
				label_2.setBounds(392, 132, 20, 14);
				contentPane.add(label_2);
				labelLate3.setText(lines.getLines().get(2).getDepTimeDeviation() + " min");
			}
		    if (lines.getLines().get(3).getDepTimeDeviation() != "") {
			JLabel label_3 = new JLabel("");
			label_3.setForeground(Color.ORANGE);
			label_3.setBounds(392, 157, 20, 14);
			contentPane.add(label_3);
			labelLate4.setText(lines.getLines().get(3).getDepTimeDeviation());

				
			}
		    
		    if (lines.getLines().get(4).getDepTimeDeviation() != "") {
				JLabel label_4 = new JLabel("");
				label_4.setForeground(Color.ORANGE);
				label_4.setBounds(392, 157, 20, 14);
				contentPane.add(label_4);
				labelLate4.setText(lines.getLines().get(4).getDepTimeDeviation());

					
				}
			

		
	}

	public String FixThatClock(int time){
		
		String zero = "";

		if (time < 10) {
			zero = "0";
		}

		
		String finalTimeString = zero + Integer.toString(time);

		zero = "";
		
		return finalTimeString;
	}
}