import Cannon.Play;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends Frame implements ActionListener
{		
	String Title;
	Button B1;
	int xmax=0,ymax=0;
	boolean flag=false;
	Image tank;
	public Welcome(String Title)
	{
		super(Title);
		loadImages();
		setLayout(new FlowLayout());
		B1=new Button("START");
		add(B1);
		B1.addActionListener(this);
		
	}
	 public void loadImages()
	{
		Toolkit t = getToolkit();
		Dimension dim=t.getScreenSize();
		xmax=dim.width;
		ymax=dim.height;
	
		tank = t.getImage("tankwars.jpg");		
	}
	
	public void actionPerformed(ActionEvent ev)
	{	Play pl =new Play();
		if(ev.getSource()==B1)
		{
		loadImages();
		pl.setVisible(true);
		pl.setSize(xmax,ymax);
			
		//("Player Registration");
			
		}
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(tank, 0,0, this);
	}
	
	public static void main(String args[])
	{	
		Welcome wl=new Welcome("Welcome");
		

		wl.setSize(1024,786);
		wl.setVisible(true);
	}
	
}