import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener{
	static JTextField txt1;
	static JButton btn1;
	static JButton btn2;
	static JPasswordField password;
	static File btn;
	public login(String title){
		super(title); 
		setSize(500,500);
		setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn = new File("btn.wav");
		
		ImageIcon icon = new ImageIcon("icon.png");
		setIconImage(icon.getImage());	
		
		txt1 = new JTextField();
		txt1.setBounds(150,210,220,30);
		
		password = new JPasswordField();
		password.setBounds(150,260,220,30);
		
		btn1 = new JButton("Login");
		btn1.setBounds(270,300,100,30);
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setOpaque(true);
		
		btn2 = new JButton("Cancel");
		btn2.setBounds(150,300,100,30);
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setOpaque(true);
		
		
		JLabel background;
		ImageIcon img = new ImageIcon("login.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,500,500);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		add(password);
		add(txt1);
		add(btn1);
		add(btn2);
		add(background);
		
		setVisible(true);
		
		
		
	}
public void actionPerformed(ActionEvent ae){
	
		playSound(btn);
		JButton obj = (JButton)ae.getSource();
		String mystr = obj.getText();
		if (mystr.equals("Login"))
		{
		String username = login.txt1.getText();
		char[] pass = login.password.getPassword();
		String str=""; 
		for(int i=0; i<pass.length; i++){
			str+=""+pass[i];
		}
		JFrame parent = new JFrame();
		if(username.equals("admin") && str.equals("12345"))
		{
			File welcome = new File("welcome.wav");
			
			this.setVisible(false);
			new Screen("Main");
			playSound(welcome);
		}
		else{
			JOptionPane.showMessageDialog(parent,"Invalid username and password");
		}
		}
		else if(mystr.equals("Cancel"))
		{
			System.exit(0);
		}
		
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







