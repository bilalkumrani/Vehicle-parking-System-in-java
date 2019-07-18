import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class Departure extends JFrame implements ActionListener{
	static JTextField txt1;
	 JLabel lebel1;
	 JButton btn1;
	 JButton back;
	 static File btn;
	
	
	
	static Connection connection=null;
	static Statement statement=null;
	
	
	Departure(String title){
		
		super(title);
				
		
		ImageIcon icon = new ImageIcon("icon.png");
		setIconImage(icon.getImage());	
		
		btn = new File("btn.wav");
		
		setSize(800,600);
		setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon pback = new ImageIcon("back.png");
		back = new JButton("back",pback);
		back.setBounds	(20,20,70,60);
		back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		back.setContentAreaFilled(false);
		
		
		lebel1 = new JLabel ("Enter Reg number: ");
		lebel1.setBounds(180,210,200,30);
		lebel1.setForeground (Color.white);
		
		txt1 = new JTextField();
		txt1.setBounds(305,210,200,30);
		
		
		
		JLabel background;
		
		
		
		ImageIcon img = new ImageIcon("screen.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,800,600);
		btn1 = new JButton("Depart");
		btn1.setBounds(350,250,100,30);
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setOpaque(true);
		
		
		btn1.addActionListener(this);
		
		
		add(btn1);
		add(txt1);
		add(lebel1);
		add(back);
		back.addActionListener(this);
		add(background);
		setVisible(true);
	}
	
		
	
	public void actionPerformed(ActionEvent ae)
	{
		playSound(btn);
		JButton obj = (JButton)ae.getSource();
		String im = obj.getText();
		if(im.equals("Depart"))
		{
			if(this.txt1.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog(this,"Field must be Filled");
			}
			else
			{
			int a = database();
			if (a>0)
			{
					
					JOptionPane.showMessageDialog(this,"Departed");
					this.setVisible(false);
					new Screen("Main");
				
			}
			else
			{
					JOptionPane.showMessageDialog(this,"Vehicle not found in area..!");
			}
			}
		}
		else if(im.equals("back")){
			this.setVisible(false);
			new Screen("Main");
		}
	}
	
	

	

	
	public static int database()
	{
		int a=0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String str = "data.accdb";
			String str1 = "jdbc:ucanaccess://"+str;
			connection = DriverManager.getConnection(str1);
			statement = connection.createStatement();
			a = statement.executeUpdate("delete from customer where Reg='"+Departure.txt1.getText()+"'");
			statement.close();
			connection.close();
			
			}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
	return a;
			
	}
	public void playSound(File sound)
	{
		try
		{
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
				Thread.sleep(250);
		}
		catch(Exception e)
		{
			
		}
	}
		
}




	
