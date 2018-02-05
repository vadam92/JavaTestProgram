package com.srccodes.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestApp {

	private JFrame frame;
	private JTextField textField;
	public JLabel lblNewLabel_Timer;
	public int sec = 0;
	public int min = 0;
	public String timerStr;
	public int generateNumber;
	public int hits = 10;
	public Timer timer;
	private JTable table_1;
	public String[][] data = {{"Adam","9","0:16","Win"}};    
	public String[] column = {"Name","Hits","Time","Result"};
	private JTextField textField_Name;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApp window = new TestApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestApp() {
		
		initialize();

	}
	
	public void randomGenerator(){
		generateNumber = 1;
		generateNumber = (int)(Math.random()*21) + 1;
	}
	
	public void TimerStart(){
		timerStr = "";
		lblNewLabel_Timer = new JLabel("");
		lblNewLabel_Timer.setBounds(359, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel_Timer);
		timer = new Timer(1000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				  
				  sec++;
			    	if(sec == 60)
			    	{
			    		min = min + 1;
			    		sec = 0;
			    	}
			    		
			    	if(sec < 10){
			    		timerStr = Integer.toString(min);
			    		timerStr += ":0";
			    		timerStr += Integer.toString(sec);
			    		lblNewLabel_Timer.setText(timerStr);
			    		System.out.println(timerStr);
			  		}
			    	else{
			    		timerStr = Integer.toString(min);
			    		timerStr += ":";
			    		timerStr += Integer.toString(sec);
			    		lblNewLabel_Timer.setText(timerStr);
			    		System.out.println(timerStr);
			    	}
			  }
		});
		timer.start();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(); 
		
		lblNewLabel_Timer = new JLabel("");
		lblNewLabel_Timer.setBounds(359, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel_Timer);
		
		JLabel lblASzmotKitalltam = new JLabel("The number  founded!");
		lblASzmotKitalltam.setBounds(197, 69, 189, 14);
		frame.getContentPane().add(lblASzmotKitalltam);
		lblASzmotKitalltam.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(197, 126, 139, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_Name = new JTextField();
	    textField_Name.setBounds(74, 21, 195, 20);
	    frame.getContentPane().add(textField_Name);
	    textField_Name.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(316, 21, 46, 14);
		frame.getContentPane().add(lblTime);
		
	    JLabel lblName = new JLabel("Name:");
	    lblName.setBounds(30, 21, 46, 14);
	    frame.getContentPane().add(lblName);
		
		JButton btnPress = new JButton("Think a number!");
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomGenerator();
				btnPress.setEnabled(false);
				lblASzmotKitalltam.setVisible(true);
				textField.setEditable(true);
				lblNewLabel_Timer.setVisible(false);
				textField_Name.setEnabled(false);
				TimerStart();
			}
		});
		btnPress.setBounds(30, 59, 139, 35);
		frame.getContentPane().add(btnPress);
		
		JLabel lblPleasePutA = new JLabel("Please put a number:");
		lblPleasePutA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPleasePutA.setBounds(30, 128, 139, 17);
		frame.getContentPane().add(lblPleasePutA);
		
		JLabel lblNewLabel_1 = new JLabel("Possible number of hits:");
		lblNewLabel_1.setBounds(37, 241, 151, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_Hits = new JLabel("New label");
		lblNewLabel_Hits.setBounds(198, 241, 46, 14);
		frame.getContentPane().add(lblNewLabel_Hits);
		lblNewLabel_Hits.setText(Integer.toString(hits));
		
		JLabel lblWrongNumber = new JLabel("Wrong Number!");
		lblWrongNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWrongNumber.setBounds(123, 169, 189, 31);
		frame.getContentPane().add(lblWrongNumber);
		lblWrongNumber.setVisible(false);
		
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					lblWrongNumber.setVisible(false);
					System.out.println(textField.getText() + " " + generateNumber + " : "+(textField.getText() == Integer.toString(generateNumber)));
					if(Integer.parseInt(textField.getText()) == generateNumber){
						timer.stop();
						sec = 0;
						min = 0;
						btnPress.setEnabled(true);
						lblASzmotKitalltam.setVisible(false);
						textField.setEditable(false);
						lblWrongNumber.setForeground(Color.green);
						lblWrongNumber.setText("Great!!!");
						JOptionPane.showMessageDialog(btnPress, "You win!\n The number is: "+generateNumber+"\nTime is: " + lblNewLabel_Timer.getText());
						lblNewLabel_Timer.setVisible(false);
						textField_Name.setEnabled(true);
						lblWrongNumber.setVisible(true);
						model.addRow(new Object[]{textField_Name.getText(), hits,lblNewLabel_Timer.getText(), "Winner"});
					}
					else{
						hits -= 1;
						lblNewLabel_Hits.setText(Integer.toString(hits));
						if(hits == 0){
							timer.stop();
							lblWrongNumber.setVisible(false);
							JOptionPane.showMessageDialog(btnPress, "You lost!\n The number is: "+generateNumber+"\nTime is: " + lblNewLabel_Timer.getText());
							model.addRow(new Object[]{textField_Name.getText(), hits,lblNewLabel_Timer.getText(), "Lost"});
							return;
						}
						lblWrongNumber.setForeground(Color.red);
						lblWrongNumber.setVisible(true);
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(btnNewButton,"Not number input!");
					System.out.println(ex);
				}
				
			}
		});

		btnNewButton.setBounds(346, 125, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sec = 0;
				min = 0;
				hits = 10;
				lblNewLabel_Hits.setText(Integer.toString(hits));
				btnPress.setEnabled(true);
				lblASzmotKitalltam.setVisible(false);
				lblWrongNumber.setVisible(false);
				textField.setEditable(false);
				lblNewLabel_Timer.setText("0:00");
				textField.setText("");
				textField_Name.setEnabled(true);
			}
		});
		btnNewGame.setBounds(301, 272, 128, 56);
		frame.getContentPane().add(btnNewGame);
		
		model.addColumn("Name"); 
		model.addColumn("Hits");
		model.addColumn("Time"); 
		model.addColumn("Result");
		
		table_1 = new JTable(model);
		table_1.setBounds(10, 283, 431, 99);
		frame.getContentPane().add(table_1);
		JScrollPane scrollPane = new JScrollPane(table_1);
	    scrollPane.setBounds(30, 339, 407, 165);
	    frame.getContentPane().add(scrollPane);
	    
	    
	    

		
	}
}
