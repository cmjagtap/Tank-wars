package Cannon;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;
import java.lang.Integer;


class CannonFrame2 extends Frame implements ActionListener, AdjustmentListener 
{
	GameScreen can2;
	//int score = 0;
    TextField ang2;
    TextField vel2;
    TextField grav2;
    TextField wind2;
	TextField nsb1;
	TextField p2name;

	Button btShoot2, btAmmo2;

    Scrollbar s_ang2;
    Scrollbar s_vel2;
    Scrollbar s_grav2;
    Scrollbar s_wind2;

    CannonFrame2(GameScreen gsp2) 
	{
		this.can2 = gsp2;

		setTitle("Player 2");

		Panel p2;
		add("North", p2 = new Panel());
		
	/*	p2.add(new Label("Player 2:"));
		p2.add(p2name = new TextField("s", 10));
		p2name.setEditable(false);*/


		p2.add(new Label("Ang:"));
		p2.add(ang2 = new TextField("60", 4));
		ang2.setEditable(false);

		p2.add(new Label("Vel:"));
		p2.add(vel2 = new TextField("15", 4));
		vel2.setEditable(false);

		p2.add(new Label("Grav:"));
		p2.add(grav2 = new TextField("4.0", 4));
		grav2.setEditable(false);

		p2.add(new Label("Wind:"));
		p2.add(wind2 = new TextField("0", 4));
		wind2.setEditable(false);

		add("Center", p2 = new Panel());
		p2.setLayout(new GridLayout(4, 0));

		p2.add(s_ang2 = new Scrollbar(Scrollbar.HORIZONTAL));
		s_ang2.setValues(60, 10, 1, 90);

		p2.add(s_vel2 = new Scrollbar(Scrollbar.HORIZONTAL));
		s_vel2.setValues(10, 2, 1, 60);

		p2.add(s_grav2 = new Scrollbar(Scrollbar.HORIZONTAL));
		s_grav2.setValues(98, 10, 40, 200);

		p2.add(s_wind2 = new Scrollbar(Scrollbar.HORIZONTAL));
		s_wind2.setValues(0, 1, -10, 10);

		s_ang2.addAdjustmentListener(this);
		s_vel2.addAdjustmentListener(this);
		s_grav2.addAdjustmentListener(this);
		s_wind2.addAdjustmentListener(this);
		
	//	tfScore1 = new TextField(5);
//		tfScore1.setEditable(false);
		btShoot2 = new Button("Shoot2");
		btAmmo2 = new Button("More Ammo2");
		btShoot2.addActionListener(this);
		btAmmo2.addActionListener(this);
		//tfScore1.setText("" + can2.score2);
		//tfScore1.addActionListener(this);
		
		add("South", p2 = new Panel());
		p2.add(btShoot2);
		p2.add(btAmmo2);
		
		p2.add(new Label("Shots Left:"));
		p2.add(nsb1 = new TextField("5",1));
		nsb1.setEditable(false);
		
		//p2.add(new Label("Score1:"));
		//p2.add(tfScore1);
		pack();
    }

    public void actionPerformed(ActionEvent evt1) 
	{
		String actionCommand = evt1.getActionCommand();

		if ("Shoot2".equals(actionCommand)) 
		{
	    	can2.shootShot2();
		}
		if ("More Ammo2".equals(actionCommand)) 
		{
	    	can2.more2();
	    	nsb1.setText("5");
		}
    }

	public void adjustmentValueChanged(AdjustmentEvent evt1)
	{
		if (evt1.getSource() == s_ang2) 
		{
	    	can2.changeAngle2(evt1.getValue());
		}
		if (evt1.getSource() == s_vel2) 
		{
	    	can2.changeVelocity2(evt1.getValue());
		}
		if (evt1.getSource() == s_grav2) 
		{
	    	can2.changeGravity2(evt1.getValue());
		}
		if (evt1.getSource() == s_wind2) 
		{
	    	can2.changeWindage2(evt1.getValue());
		}
	}
	
	/*	public static void main(String[] args)
	{
		GameScreen gsp=new GameScreen();
		CannonFrame2 cf2=new CannonFrame2(gsp);
		cf2.setVisible(true);
	}*/
}