
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class welcome extends JFrame
{
	public welcome()
	{
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		ImageIcon icon = new ImageIcon("icon.png");
		setIconImage(icon.getImage());
		
		JLabel lb;
		ImageIcon img = new ImageIcon("WELCOME-SCREEN.jpg");
		lb = new JLabel("",img,JLabel.CENTER);
		lb.setBounds(0,0, 600, 300);
		Thread t = Thread.currentThread();
		
		JProgressBar b = new JProgressBar();
		b.setStringPainted(true); 
		b.setValue(0);
		b.setBounds(10,220,580,30);
		add(b);
		add(lb);
		setVisible(true);
		try
		{
			for(int i=0; i<=100; i++)
			{
				t.sleep(30);

				b.setValue(i);
				
			}
			setVisible(false);
		}
		catch(Exception a)
		{}
	}
}
