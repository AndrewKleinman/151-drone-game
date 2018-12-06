import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;

//plane always start at some random y, fixed x near right side of screen
//airplane array should be 1-6 at one time
//the plane will move to the left in a horizontal line
//the speed of the airplane is random from 1 pixel per 100ms to 1 pixel per 1000ms
public class Airplane implements Icon
{
	private int 				y;
	private int 				x; 
	private int 				width;
	private int 				height;	
	
	public Airplane(int y, int width, int height)
	{
		this.x = 700;				// Plane starts at the right of the screen
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	public void resetX()
	{
		x=820;
	}
	public void resetY()
	{
		y = (int)(Math.random()*600+1);
	}
	
	@Override
	public int getIconWidth() 
	{
		return width;
	}


	@Override
	public int getIconHeight() 
	{
		return height;
	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.DARK_GRAY);
		Rectangle2D.Double body = new Rectangle2D.Double(x, y, width, height);
		g2.fill(body);
		
		int[] xP = {x, x - (width / 4), x};
		int[] yP = {y, y + (height / 2), y + height};
		Polygon tip = new Polygon(xP,yP, 3);
		g2.fill(tip);		


		int[] xP1 = {x + (width / 3), x + (2 * width / 3), x + (3 * width / 4)};
		int[] yP1 = {y, y, y - height};
		Polygon topWing = new Polygon(xP1,yP1, 3);
		g2.fill(topWing);

		int[] xP2 = {x + (width / 3), x + (2 * width / 3), x + (3 * width / 4)};
		int[] yP2 = {y + height, y + height, y + (2 * height)};
		Polygon botWing = new Polygon(xP2, yP2, 3);
		g2.fill(botWing);
		
		// Draw components
		g2.draw(tip);
		g2.draw(topWing);
		g2.draw(botWing);
		
	}

	public void xShift()
	{
		x -= 7;
	}
}
