package Cannon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Play extends Frame implements ActionListener
{	GameScreen gs1;	
	public String Title;
	TextField T1;
	TextField T2;
	Button B1;
	int xmax=0,ymax=0;
	Image tank;
	String Player1,Player2;
	
	public Play()
	{
		//super(Title);
		
		loadImages();
		Panel p;
		
		setLayout(new FlowLayout());
		add("North", p = new Panel());
		p.add(new Label("Player 1:"));
		p.add(T1 = new TextField("", 10));
		T1.setEditable(true);
		add(T1);
		
		Panel p1;
		setLayout(new FlowLayout());
		add("North", p1 = new Panel());		
		p1.add(new Label("Player 2:"));
		p1.add(T2 = new TextField("", 10));
		T2.setEditable(true);
		add(T2);
		
		B1=new Button("SAVE");
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
		public void paint(Graphics g)
	{
		g.drawImage(tank, 0,0,xmax,ymax, this);
	}
		
		
	public void actionPerformed(ActionEvent e)
	{	gs1=new GameScreen();
		String sql;	
		if(e.getSource()==B1)
		{	
		
			loadImages();
		
		
			gs1.setVisible(true);
			
			gs1.setSize(xmax, ymax);
			insertData();
			gs1.T1n.setText(T1.getText());
			gs1.T2n.setText(T2.getText());
		}	
	
	

	}



	public void insertData()
	{
		Connection con;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Tank");
			String sql1 = "Insert Into Players (Player) " +"Values ('"+T1.getText()+"')";
			String sql2 = "Insert Into Players (Player) " +"Values ('"+T2.getText()+"')";
			Statement statement = con.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
}