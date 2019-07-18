

import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Screen extends JFrame implements ActionListener
{
	
	
		
		 JButton car;
		 JButton bus;
		 JButton riksha;
		 JButton bike;
		 JButton close;
		 JButton records;
		 JButton departure;
		 JButton about;
		 JButton reset;
		 Thread t;
		 static File btn;
		 JLabel select;

		JLabel allVehicle;
	
	Screen(String title)
	{
		super(title);
		setSize(800,600);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		t = Thread.currentThread();
		
		btn = new File("btn.wav");
		
		ImageIcon pcar = new ImageIcon("car.png");
		ImageIcon pbus = new ImageIcon("bus.png");
		ImageIcon priksha = new ImageIcon("riksha.png");
		ImageIcon pbike = new ImageIcon("bike.png");
		ImageIcon precords = new ImageIcon("records.png");
		TotalVehicle obj = new TotalVehicle();
		
    int total = obj.totalNum();
		

		ImageIcon icon = new ImageIcon("icon.png");
		setIconImage(icon.getImage());	
		
		JLabel lb;
		ImageIcon img = new ImageIcon("screen.jpg");
		lb = new JLabel("",img,JLabel.CENTER);
		lb.setBounds(0,0, 800, 600);
		
		ImageIcon pclose = new ImageIcon("close.png");
		ImageIcon pdeparture = new ImageIcon("departure.png");
		ImageIcon pabout = new ImageIcon("about.png");
		ImageIcon preset = new ImageIcon("reset.png");
		
		car = new JButton("Car",pcar);
		bus = new JButton("Bus",pbus);
		bike = new JButton("Bike",pbike);
		riksha = new JButton("Riksha",priksha);
		close = new JButton("Close",pclose);
		records = new JButton("Records",precords);
		departure = new JButton("Departure",pdeparture);
		select = new JLabel("Select vehicle: ");
		about = new JButton("About",pabout);
		reset = new JButton("Reset",preset);
		
		allVehicle = new JLabel("Parked vehicles: 0"+ total);
		
		
		car.setBounds	(50,100,110,100);
		bike.setBounds	(50,210,110,100);
		riksha.setBounds(50,320,110,100);
		bus.setBounds	(50,430,110,100);
		close.setBounds	(740,5,50,50);
		records.setBounds(430,410,83,100);
		departure.setBounds(300,400,87,100);
		about.setBounds(550,400,83,100);
		reset.setBounds(670,400,83,100);
		select.setBounds(30,20,200,100);
		
		allVehicle.setBounds(560,310,500,100);
		select.setForeground (Color.white);
		
		
		select.setFont(new Font("Serif", Font.BOLD, 25));
		allVehicle.setFont(new Font("Serif", Font.BOLD, 25));
		
		
		close.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		close.setContentAreaFilled(false);
		
		car.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		car.setContentAreaFilled(false);
		
		bike.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		bike.setContentAreaFilled(false);
		
		riksha.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		riksha.setContentAreaFilled(false);
		
		bus.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		bus.setContentAreaFilled(false);
		
		records.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		records.setContentAreaFilled(false);
		
		departure.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		departure.setContentAreaFilled(false);
		
		about.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		about.setContentAreaFilled(false);
		
		reset.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		reset.setContentAreaFilled(false);

		
		
		
		
		
		

		
		
		add(car);
		car.addActionListener(this);
		add(bus);
		bus.addActionListener(this);
		add(riksha);
		riksha.addActionListener(this);
		add(bike);
		bike.addActionListener(this);
		add(close);
		close.addActionListener(this);
		add(records);
		records.addActionListener(this);
		add(select);
		add(allVehicle);
		add(departure);
		departure.addActionListener(this);
		add(about);
		about.addActionListener(this);
		add(reset);
		reset.addActionListener(this);
		
		
		
		add(lb);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent a)
	{
		playSound(btn);
		JButton obj = (JButton)a.getSource();
		String str = obj.getText();
		if(str.equals("Car"))
		{
			this.setVisible(false);
			new park(str);
			
		}
	
		else if(str.equals("Bike"))
		{
			this.setVisible(false);
			new park(str);
		}
	
		else if(str.equals("Riksha"))
		{
			this.setVisible(false);
			new park(str);
		}
		
	
		else if(str.equals("Bus"))
		{
			this.setVisible(false);
			new park(str);
		}
		else if(str.equals("Records"))
		{
			new Records();
		}
		
		else if(str.equals("Departure"))
		{
			new Departure("Departure");
			this.setVisible(false);
		}
		else if(str.equals("Reset"))
		{
			new Reset();
			this.setVisible(false);
			new Screen("Main");
		}
		else if(str.equals("About"))
		{
			this.setVisible(false);
			new About("About");
		}

	
	
		else if(str.equals("Close"))
			System.exit(0);
	
		
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



