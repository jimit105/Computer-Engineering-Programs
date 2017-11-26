import java.awt.*;
import java.applet.*;

/* <applet code="Exp10.class" height=100 width=100> </applet> */

public class Exp10 extends Applet
{
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		
		
		Font f = new Font("Lucida", Font.BOLD, 25);
		g.setFont(f);
		
		g.setColor(Color.blue);
		g.drawString("Don't forget to Smile :)", 50 ,30);
		g.setColor(Color.yellow);
		g.fillOval(60, 60, 200, 200);
		g.setColor(Color.black);
		g.drawOval(60, 60, 200, 200);
		
		g.fillOval(110, 120, 20, 35);
		g.fillOval(190, 120, 20, 35);
		
		g2.setStroke(new BasicStroke(3));
		g.drawLine(160, 125, 160, 185);
		
		g2.setStroke(new BasicStroke(6));
		g.drawArc(110, 160, 100, 60, 0 ,-180);
	
	}
}