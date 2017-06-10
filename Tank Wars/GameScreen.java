package Cannon;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;
import java.lang.Integer;
import java.sql.*;

public class GameScreen extends Frame
{	TextField T1,T1n,T3;
	TextField T2,T2n;
//	GameScreen gsp;
	double dx1, dy1,dx2,dy2, theta,theta2, velocity,velocity2, gravity,gravity2, windage,windage2;
  	int xmm,ymm,xmaxm,ymaxm,xmax1, ymax1,xmax2,ymax2, numshots1,numshots2;
  	Color black, erase;
  	double x1, y1,x2,y2;
  	double xo1[] = new double[4];
  	double yo1[] = new double[4];
  	double xo2[] = new double[4];
  	double yo2[] = new double[4];
  	double rads;
	Graphics drawarea;
	Image targ,targ2,can2, can, shot, bang1,spoils,shot2,backg,gameover;
	CannonFrame1 frame1;
	CannonFrame2 frame2;

	int score1 = 0;	
	int score2=0;
	boolean flag1=false;
	boolean flag2=false;
	
	public GameScreen()
	{	
		loadImages();
      	numshots1 = 5;
      	numshots2 = 5;
      	rads = 57.29577866f;
      	//int xmm;
      	//xmax1 = 1000;
      	//ymax1 = 675;
      	//xmax2=1000;
      	//ymax2=675;
   
      	theta = 60;		// degrees
      	theta /= rads;		// -> radians
      	theta2 = 60;	
      	theta2 /= rads;
      	velocity = 3;
      	velocity2 = 3;		// m/s x 10^-1
      	gravity = .098f;
      	gravity2 = .098f;		// m/s^2 x 10^-2
      	windage = 0;
      	windage2 = 0;
      //	black = Color.white;
      //	erase = Color.blue;
		frame1 = new CannonFrame1(this);
		frame1.setVisible(true);
		frame1.setAlwaysOnTop(true);
		frame1.setBounds((xmm-(500+(xmm-500))),(ymm-175),500+(xmm-500),175);
		
		frame2 = new CannonFrame2(this);
		frame2.setVisible(true);
		frame2.setAlwaysOnTop(true);
		frame2.setBounds(xmm,(ymm-175),500+(xmm-500),175);
		
		
		Panel p;
		setLayout(new FlowLayout());
		
		add("North", p = new Panel());
		
		
		//p.add(new Label("Player 1:"));
		
		p.add(T1n = new TextField("", 10));
		T1n.setEditable(false);
	
	
		add(T1n);
		
		p.add(T1 = new TextField("", 10));
		T1.setEditable(false);
		T1.setText("" +score1);
		
		add(T1);
		
		
		
		Panel p1;
		setLayout(new FlowLayout());
		add("North", p1 = new Panel());
				
	//	p1.add(new Label("Player 2:"));
		
		p1.add(T2n = new TextField("", 10));
		T2n.setEditable(false);
		add(T2n);
	
		
		p1.add(T3 = new TextField("", 10));
		T3.setEditable(false);
	
	
		add(T3);
		
		p1.add(T2 = new TextField("", 10));
		T2.setText("" +score2);
		T2.setEditable(false);
		add(T2);
		
	
	
		pack();
		
	

		
	}
	
	private void UpdateScore()
	{
		Connection con;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Tank");
			String sql1 = "Update Players Set Score='"+T1.getText()+"' Where Player='"+T1n.getText()+"'";
			String sql2 = "Update Players Set Score='"+T2.getText()+"' Where Player='"+T2n.getText()+"'";
			Statement statement = con.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
/*		public void Winner()
	{
			 int a=Integer.parseInt(T1.getText());
			 int b=Integer.parseInt(T2.getText());
			
			if(a>b)
			{
				T3.setText("first");
			}
			else
			{
				T3.setText("secom");
			}
	}*/


	/*******************PLAYER ONE************/////////////////
	public void more1()
    {
    	numshots1 = 5;
    	repaint();
    }

	public void shootShot1()
    {
      	if (numshots1 > 0)
		{
	  		numshots1--;
	  		flag1=true;
	  		repaint();
		}
    }

	

	public void changeAngle1(int val)
    {
      	Integer temp = new Integer(val);
      	theta = (double)val;		// degrees
      	theta /= rads;		// -> radians
      	frame1.ang.setText(temp.toString());
    }

  	public void changeVelocity1(int val)
    {
      	Integer temp = new Integer(val);
      	velocity = (double)val / 5;
      	frame1.vel.setText(temp.toString());
    }

  	public void changeGravity1(int val)
    {
      	Float temp = new Float((float)val / 10);
      	gravity = (double)val / 1000;
      	frame1.grav.setText(temp.toString());
    }

  	public void changeWindage1(int val)
    {
      	Integer temp = new Integer(val);
      	windage = (double)val / 200;
      	frame1.wind.setText(temp.toString());
    }
    
    /*******************PLAYER TWO************/////////////////
    
    public void more2()
    {
    	numshots2 = 5;
    	repaint();
    }

	public void shootShot2()
    {
      	if (numshots2 > 0)
		{
	  		numshots2--;
	  		flag2=true;
	  		repaint();
		}
    }
    
    
    
    
    
    
    	
	
	
	
	
	
	
		public void changeAngle2(int val)
    {
      	Integer temp2 = new Integer(val);
      	theta2 = (double)val;		// degrees
      	theta2 /= rads;		// -> radians
      	frame2.ang2.setText(temp2.toString());
    }

  	public void changeVelocity2(int val)
    {
      	Integer temp2 = new Integer(val);
      	velocity2 = (double)val / 5;
      	frame2.vel2.setText(temp2.toString());
    }

  	public void changeGravity2(int val)
    {
      	Float temp2 = new Float((float)val / 10);
      	gravity2 = (double)val / 1000;
      	frame2.grav2.setText(temp2.toString());
    }

  	public void changeWindage2(int val)
    {
      	Integer temp2 = new Integer(val);
      	windage2 = (double)val / 200;
      	frame2.wind2.setText(temp2.toString());
    }
    
    ////*********************************************//////////////////
    
       
    public void loadImages()
	{
		Toolkit t = getToolkit();
		can = t.getImage("cannon3.png");
		can2 = t.getImage("cannon3_2.png");
		targ = t.getImage("targ1.png");
		targ2 = t.getImage("targ1_2.png");
		shot = t.getImage("ammo2.png");
		shot2 = t.getImage("ammo4.png");
		bang1 = t.getImage("fireball.gif");
		spoils=t.getImage("spoil.png");
		backg=t.getImage("tank.jpg");
		gameover=t.getImage("GameOver.jpg");
		Dimension dim=t.getScreenSize();
		 xmaxm=dim.width;
		 ymaxm=dim.height;
		 xmax1=dim.width-30;
		 ymax1=dim.height-180;
		 xmax2=dim.width-30;
		 ymax2=dim.height-180;
		 xmm=dim.width/2;
		 ymm=dim.height;
	}




	
	public void paint(Graphics g)
    {		
    		g.drawImage(backg,0,0,xmaxm,ymaxm,this);
    		g.drawImage(can, 50, ymax1 - can.getHeight(this), this);
      	g.drawImage(targ, xmax1 - (targ.getWidth(this) + 10), ymax1 - can.getHeight(this), this);
   
      	if (flag1 == true) 
	  	{
	  		
      	

      	

      	
      
      	
      	/*******************PLAYER ONE************/////////////////
      	if (numshots1 == 5)
	  	frame1.nsb1.setText("5");
		if (numshots1 == 4)
	  	frame1.nsb1.setText("4");
      	if (numshots1 == 3) 
		frame1.nsb1.setText("3");
      	if (numshots1 == 2) 
		frame1.nsb1.setText("2");
      	if (numshots1  ==1) 
		frame1.nsb1.setText("1");
		if (numshots1  ==0) 
		frame1.nsb1.setText("0");

      	if (numshots1 < 5)
		{
	  		//##### Shoot da shot
	  		x1 = 145;
	  		y1 = ymax1-40;
	  		dx1 = velocity * Math.cos(theta);
	  		dy1 = velocity * Math.sin(theta);
	  	//	g.setColor(Color.red);
	  
	  		while ((x1 > 0) && (x1 < xmax1) && (y1 < ymax1))
	    	{
	      		if (xo1[3] != 0)
				//g.clearRect((int)xo1[3] - 4, (int)yo1[3] - 4, 8, 7);
					
					
	      		if (xo1[0] != xmax1)
		  		//g.drawRect((int)xo1[0]-1, (int)yo1[0]-1, 2, 2);
	      		g.drawImage(shot, (int)x1 - 4, (int)y1 - 4, this);
	      		
	      		if (x1 > 145) 
				g.drawImage(can, 50, ymax1 - can.getHeight(this), this);
	      	
	      	/*	if ((x1>95) && (y1>32))
				g.drawImage(can, (can.getWidth(this)+10), 
			    can.getHeight(this), this);*/
			    
				try 
				{Thread.sleep(5);}
				catch(InterruptedException ex)
				{}
				
				
	      		xo1[0] = xo1[1]; xo1[1] = xo1[2]; xo1[2] = xo1[3];
	      		yo1[0] = yo1[1]; yo1[1] = yo1[2]; yo1[2] = yo1[3];
	      		xo1[3] = x1; yo1[3] = y1;
	      		x1 += dx1;
	      		dx1 -= windage/2;
	      		y1 -= dy1;
	      		dy1 -= gravity/2;
	      		flag1=false;
	      		flag2=false;
	      		
	      		
	      		//##### Check for hit
	      		
	      		if ((x1>(xmax1-118) && (x1<(xmax1-10)) && 
		  			(y1>(ymax1-30)) && (y1<ymax1)))
				{
		  		//	g.drawImage(bang1, xmax - (bang1.getWidth(this)+10), 
			    //		ymax - bang1.getHeight(this), this);
			    		g.drawImage(spoils, xmax1 - (spoils.getWidth(this)+10), 
			    		ymax1 - spoils.getHeight(this), this);
			    		
					++score1;
					T1.setText("" + score1);
				}
	    	}
	  		for (int i=0; i<4; i++) 
				xo1[i] = yo1[i] = 0;
		}
	
		}
		
		
		/*******************PLAYER TWO************/////////////////
		
		
		if (flag2 == true) 
		{
		
		if (numshots2 == 5)
	  	frame2.nsb1.setText("5");
		if (numshots2 == 4)
	  	frame2.nsb1.setText("4");
      	if (numshots2 == 3) 
		frame2.nsb1.setText("3");
      	if (numshots2 == 2) 
		frame2.nsb1.setText("2");
      	if (numshots2  ==1) 
		frame2.nsb1.setText("1");
		if (numshots2  ==0) 
		frame2.nsb1.setText("0");
		
		
      	if (numshots2 < 5)
		{
	  		//##### Shoot d shot
	  		x2 = xmax2-105;
	  		y2 = ymax2-40;
	  		
	  		dx2 = velocity2 * Math.cos(theta2);
	  		dy2 = velocity2 * Math.sin(theta2);
	  	//	g.setColor(Color.red);
	  
	  		while ((x2 > 0) && (x2 < xmax2) && (y2 < ymax2))
	    	{
	      		if (xo2[3] != xmax2)
			//	g.clearRect((int)xo2[3] - 4, (int)yo2[3] - 4, 8, 7);
					
					
	      		if (xo2[0] != xmax2)
		  		//g.drawRect((int)xo2[0]-1, (int)yo2[0]-1, 2, 2);
	      		g.drawImage(shot2, (int)x2 - 4, (int)y2 - 4, this);
	      		
	      	/*	if (x2 < 75) 
				g.drawImage(can2, 50, ymax2 - can.getHeight(this), this);
	      	
	      		if ((x2>xmax2-(targ2.getWidth(this)+10)) && (y2>ymax2-targ2.getHeight(this)))
				g.drawImage(targ2, xmax2 - (targ.getWidth(this)+10), 
			    ymax2 - targ2.getHeight(this), this);*/
			    	    
				try 
				{Thread.sleep(5);}
				catch(InterruptedException ex)
				{}
				
				
	      		xo2[0] = xo2[1]; xo2[1] = xo2[2]; xo2[2] = xo2[3];
	      		yo2[0] = yo2[1]; yo2[1] = yo2[2]; yo2[2] = yo2[3];
	      		xo2[3] = x2; yo2[3] = y2;
	      		x2 -= dx2;
	      		dx2 += windage2/2;
	      		y2 -= dy2;
	      		dy2 -= gravity2/2;
	      		
	      		flag2=false;
	      		
	      		//##### Check for hit
	      		if ((x2<150) && (x2>50) && 	(y2>(ymax2-30)) && (y2<ymax2))
				{
		  		//	g.drawImage(bang1, xmax - (bang1.getWidth(this)+10), 
			    //		ymax - bang1.getHeight(this), this);
			    		g.drawImage(spoils, 0+(spoils.getWidth(this)-60), 
			    		ymax2 - spoils.getHeight(this), this);
			    		
					++score2;
					T2.setText("" + score2);
				}
	    	}
	  		for (int i1=0; i1<4; i1++) 
			{	xo2[i1] = yo2[i1] = 0;
				//repaint();
			}
		}
		}
		
			if(numshots1==0 && numshots2==0)
		{
			g.drawImage(gameover,0,0,xmaxm,ymaxm,this);
			frame1.setVisible(false);
			frame2.setVisible(false);
		//	gsp.setAlwaysOnTop(true);
			UpdateScore();
		//	Winner();
			int a=Integer.parseInt(T1.getText());
			 int b=Integer.parseInt(T2.getText());
			String c=T1n.getText();
			String d=T2n.getText();
			if(a>b)
			{
				g.setColor(Color.white);
				g.setFont(new Font("Algerian",Font.BOLD,50));
				g.drawString("Congratulations!",xmm-300,230);
				g.setColor(Color.red);
				g.drawString(c,xmm-200,330);
				g.setColor(Color.white);
				g.drawString("You are the Winner",xmm-320,430);
			}
			else
			if(a<b)
			{	g.setColor(Color.white);
				g.setFont(new Font("Algerian",Font.BOLD,50));
				g.drawString("Congratulations!",xmm-300,230);
				g.setColor(Color.red);
				g.drawString(d,xmm-200,330);
				g.setColor(Color.white);
				g.drawString("You are the Winner",xmm-320,430);
			}
			else
			{	g.setColor(Color.white);
				g.setFont(new Font("Algerian",Font.BOLD,50));
				g.drawString("Sorry Result is Tie",xmm-200,330);
			}	
		}
    }
    
   

}

