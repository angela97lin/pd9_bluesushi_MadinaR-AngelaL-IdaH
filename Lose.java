import java.awt.*;


public class Lose{

    public void draw(Graphics g){
	g.setColor(new Color(255,150,150));
	g.setFont(new Font("Courier New",Font.BOLD,300));
	g.drawString("YOU",200,300);
	g.drawString("LOSE!",200,500);

    }


}
