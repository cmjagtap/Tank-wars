package Cannon;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;
import java.lang.Integer;


public class CannonFrame1 extends Frame implements ActionListener, AdjustmentListener 
{
	GameScreen can1;
	//int score = 0;
    TextField ang;
    TextField vel;
    TextField grav;
    TextField wind;
	TextField nsb1;
	TextField p1name;

	Button btShoot, btAmmo;

    Scrollbar s_ang;
    Scrollbar s_vel;
    Scrollbar s_grav;
    Scrollbar s_wind;

    CannonFrame1(GameScreen gsp) 
	{
		this.can1 = gsp;

		setTitle("Player 1");

		Panel p;
		add("North", p = new Panel());
		
	/*	p.add(new Label("Player 2:"));
		p.add(p1name = new TextField("s", 10));
		p1name.setEditable(false);*/


		p.add(new Label("Ang:"));
		p.add(ang = new TextField("60", 4));
		ang.setEditable(false);

		p.add(new Label("Vel:"));
		p.add(vel = new TextField("15", 4));
		vel.setEditable(false);

		p.add(new Label("Grav:"));
		p.add(grav = new TextField("4.0", 4));
		grav.setEditable(false);

		p.add(new Label("Wind:"));
		p.add(wind = new TextField("0", 4));
		wind.setEditable(false);

		add("Center", p = new Panel());
		p.setLayout(new GridLayout(4, 0));

		p.add(s_ang = new Scrollbar(Scrollbar.HORIZONTAL));
		s_ang.setValues(60, 10, 1, 90);

		p.add(s_vel = new Scrollbar(Scrollbar.HORIZONTAL));
		s_vel.setValues(10, 2, 1, 60);

		p.add(s_grav = new Scrollbar(Scrollbar.HORIZONTAL));
		s_grav.setValues(98, 10, 40, 200);

		p.add(s_wind = new Scrollbar(Scrollbar.HORIZONTAL));
		s_wind.setValues(0, 1, -10, 10);

		s_ang.addAdjustmentListener(this);
		s_vel.addAdjustmentListener(this);
		s_grav.addAdjustmentListener(this);
		s_wind.addAdjustmentListener(this);
		
	//	tfScore = new TextField(5);
	//	tfScore.setEditable(false);
		btShoot = new Button("Shoot");
		btAmmo = new Button("More Ammo");
		btShoot.addActionListener(this);
		btAmmo.addActionListener(this);
		//tfScore.setText("" + can1.score1);
	//	tfScore.addActionListener(this);
		add("South", p = new Panel());
		p.add(btShoot);
		p.add(btAmmo);
		
		p.add(new Label("Shots Left:"));
		p.add(nsb1 = new TextField("5",1));
		nsb1.setEditable(false);
	//	p.add(new Label("Score:"));
	//	p.add(tfScore);
		pack();
    }

    public void actionPerformed(ActionEvent evt) 
	{
		String actionCommand = evt.getActionCommand();

		if ("Shoot".equals(actionCommand)) 
		{
	    	can1.shootShot1();
		}
		if ("More Ammo".equals(actionCommand)) 
		{
	    	can1.more1();
	    	nsb1.setText("5");
		}
    }

	public void adjustmentValueChanged(AdjustmentEvent evt)
	{
		if (evt.getSource() == s_ang) 
		{
	    	can1.changeAngle1(evt.getValue());
		}
		if (evt.getSource() == s_vel) 
		{
	    	can1.changeVelocity1(evt.getValue());
		}
		if (evt.getSource() == s_grav) 
		{
	    	can1.changeGravity1(evt.getValue());
		}
		if (evt.getSource() == s_wind) 
		{
	    	can1.changeWindage1(evt.getValue());
		}
	}
	
	/*	public static void main(String[] args)
	{
		GameScreen gsp=new GameScreen();
		CannonFrame2 cf2=new CannonFrame2(gsp);
		cf2.setVisible(true);
	}*/
}