import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class About extends JFrame implements ActionListener{

	JLabel label1;
	JButton back;
	static File btn;

	
	
	
	
	About(String title){
		
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
		
		JLabel label = new JLabel("<html>______Developers{}______<br> <br><br> <br>Bilal Khan <br>bilalkhan.bcsf18@iba-suk.edu.pk<br> <a href='http://www.facebook.com/leopardbilal'>www.facebook.com/leopardbilal </a><br>+923478378652 <br> <br> <br> <br> <br>Nouman Ali <br>noumanali.bcsf18@iba-suk.edu.pk<br> <a href='https://www.facebook.com/nouman.buriro'>www.facebook.com/nouman.buriro</a><br>+923360845261<br>");
		

		label.setBounds(100,100,500,300);
		label.setForeground (Color.white);
		
		
		
		
		JLabel background;
		
		
		
		ImageIcon img = new ImageIcon("screen.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,800,600);
	
		
		

		
		
		
		
		add(label);
	//	add(label2);
		add(back);
		back.addActionListener(this);
		add(background);
		setVisible(true);
	}
	
		
	
	public void actionPerformed(ActionEvent ae)
	{
		JButton obj = (JButton)ae.getSource();
		String im = obj.getText();
		
		if(im.equals("back")){
			playSound(btn);
			this.setVisible(false);
			new Screen("Main");
		}
	}
		
		
	public static void playSound(File sound)
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




	
