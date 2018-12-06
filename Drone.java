import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Drone 
{
	int x; int y; int xvel; int yvel;

	ImageIcon icon = new ImageIcon("droneresized.png");
	JLabel label = new JLabel(icon);
	int freeze = 5000;
	int dx;
	int dy;


	public Drone()
	{
		x = 50;
		y = 250;
	}

	public void update()
	{
		if(freeze>50)
		{
		x += dx;
		if(x > 800-70)
			x = 800-70;
		y += dy;
		if(y > 600-120)
			y=600-120;
		if(x<0)
			x=0;
		if(y<0)
			y=0;
		}
		else
			freeze+=1;
		}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean collisionDetection() 
	{
		for(Airplane p: DroneGame.airplanes)
		{
			if(p.getX()+p.getIconWidth()>x && p.getX()<x+50 && p.getY()+p.getIconHeight()>y && p.getY() < y+30) {
				freeze=0;
				return true;
			}
		}
		return false;
	}

	public void keyPressed(KeyEvent e){
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_UP)
			{dy = -5;
			dx=0;}
		if(id == KeyEvent.VK_DOWN)
		{	dy = 5;
			dx = 0;}
		if(id == KeyEvent.VK_LEFT)
			dx = -5;
		if(id == KeyEvent.VK_RIGHT)
			dx = 5;
	}
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_UP)
			{dy = 0;
			dx=1;
			}
		if(id == KeyEvent.VK_DOWN)
			{dy = 0;
			dx=1;
			}
		if(id == KeyEvent.VK_LEFT)
			dx = 1;
		if(id == KeyEvent.VK_RIGHT)
			dx = 1;
	}

	public Image getImage()
	{
		return icon.getImage();
	}
}
