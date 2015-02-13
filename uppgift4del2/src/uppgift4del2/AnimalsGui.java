package uppgift4del2;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AnimalsGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGui frame = new AnimalsGui();
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
	public AnimalsGui() {
		
ArrayList<Animal> zoo = new ArrayList<Animal>();
		
		zoo.add(new Dog("nisse","latin", 4, true));
		zoo.add(new Cat("cat1", 4, 9));
		zoo.add(new Snake("snake1", true));
		zoo.add(new Snake("snake2", true));
		zoo.add(new Dog("Bulldog","bull", 4, true));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 392, 250);
		contentPane.add(scrollPane);
		
		JTextArea Information = new JTextArea();
		scrollPane.setViewportView(Information);
		for(Animal animal : zoo) {
			Information.append(animal.getInfo()+"\n");
		}
		
		
		
	}
}
