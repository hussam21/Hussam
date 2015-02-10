package uppgift4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class DogsandHumansGUI extends JFrame {
	 public Human human;
	 
	 
	 
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DogsandHumansGUI frame = new DogsandHumansGUI();
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
	public DogsandHumansGUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 101, 24);
		contentPane.add(scrollPane);
		
		JTextArea newHuman = new JTextArea();
		scrollPane.setViewportView(newHuman);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 46, 101, 24);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnNewButton = new JButton("New Human");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				human = new Human(newHuman.getText());
				
			}
		});
		btnNewButton.setBounds(150, 13, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBuyDog = new JButton("Buy dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				human.buyDog(new Dog(textArea_1.getText()));
				//Dog dog= new Dog("rasse");
			}
		});
		btnBuyDog.setBounds(150, 48, 89, 23);
		contentPane.add(btnBuyDog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 126, 382, 50);
		contentPane.add(scrollPane_2);
		
		
		JTextArea infoTextArea = new JTextArea();
		scrollPane_2.setViewportView(infoTextArea);
		
		JButton btnGetInfo = new JButton("Print info");
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 infoTextArea.setText(human.getName() +" äger en hund som heter ");
				 infoTextArea.append(human.dog.name);
			}
		});
		btnGetInfo.setBounds(150, 92, 89, 23);
		contentPane.add(btnGetInfo);
		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(22, 96, 46, 14);
		contentPane.add(lblInfo);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 201, 382, 50);
		contentPane.add(scrollPane_3);
		
		JTextArea Error = new JTextArea();
		scrollPane_3.setViewportView(Error);
		
		JLabel lblError = new JLabel("Error");
		lblError.setBounds(22, 176, 46, 14);
		contentPane.add(lblError);
	}
}
