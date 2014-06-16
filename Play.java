import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Play{
    
    public static Deck deck;
    public static Player p;
    public static Computer c;
    public static CardStack cs;
    public static int placed;
    public static int csPlaced;
    public static int count;
    public static boolean turn;
    public static boolean lie;
    public static int countDown;

    public Play(){
	define();
    }

    public void define(){
	deck = new Deck();
	p = new Player();
	c = new Computer();
	cs = new CardStack();
	placed = 0;
	deck.deal(c,p);
	count = 0;
	turn = true;
	lie = false;
	countDown = 1500;
    }

    public void go(){
	placed = 0;
	for (int i = 0; i < p.getHand().size();){
	    if (p.getHand().getCard(i).selected()){
		cs.add(p.getHand().remove(p.getHand().getCard(i)));
		placed ++;
	    }else{
		i++;
	    }
	}
	cs.expectedVal++;
	if(cs.expectedVal > 13){
	    cs.expectedVal = 1;
	}
	turn = false;
	lie = false;
    }

    public void deselect(){
	for (int i = 0; i < p.getHand().size();i++){
	    if(p.getHand().getCard(i).selected()){
		p.getHand().getCard(i).unselect();
	    }
	}
    }
    
    public void checkAll(float x, float y){
	for (int i =0; i < p.getHand().size();i++){
	    if(p.getHand().getCard(i).isBetween(x,y)&&
	       !(p.getHand().getCard(i).selected())){
		p.getHand().getCard(i).select();
		//System.out.println(p.getHand().getCard(i).getYCor());
		GamePlay.stuff = 1;
	    }
	}
    }

    public void bs(Graphics g){
	int cardNum = 1;
	if(turn){
	    while(csPlaced > 0){
		cs.pop(g,cardNum);//forgot-cardNum =?
		csPlaced --;
		cardNum++;
	    }
	    lie = false;
	    cs.cardCollection(p.getHand(),c.getHand());
	}
	else{
	    while(placed > 0){
		cs.pop(g,cardNum);
		placed--;
		cardNum++;
	    }
	    cs.cardCollection(c.getHand(),p.getHand());
	}

    }
	
    public Player getPlayer(){
	return p;
    }

    public void draw(Graphics g){
	g.setColor(new Color(168,168,230,63));
	g.fillRect(0,GamePlay.myHeight/2-40,80,80);
	g.setColor(new Color(255,255,255));
	g.setFont(new Font("Courier New",Font.BOLD,19));
	g.drawString("Menu",20,GamePlay.myHeight/2+5);
	g.setColor(new Color(0,0,0));
	g.fillRect(200,330,80,40);
	g.fillRect(200,380,80,40);
	g.fillRect(200,280,90,40);
	g.setColor(new Color(255,255,255));
	g.drawString("Go!",225,356);
	g.drawString("BS!",225,406);
	g.drawString("Unselect",200,306);
	g.drawString("Next Card:" + cs.expectedVal,300,356);
	if(turn){
	    g.drawString("Placed:" + csPlaced,300,406);
	    //System.out.println(c.emotion);
	    g.drawString(c.emotion, 240,270);
	    //g.drawString("HI", 200,200);
	}else{
	    g.drawString("Placed:"+placed,300,406);
	}
	if(!turn){
	    if(countDown <= 0){
		c.makeMove(g);
		if (cs.expectedVal<13){
		    cs.expectedVal ++;
		}else{
		    cs.expectedVal = 1;
		}
		countDown = 1500;
	    }
	    
	    
	}
	if(count != 0){
	    bs(g);
	    if(turn){
		if(csPlaced <=0){
		    count = 0;
		}
	    }else{
		if(placed<=0){
		    count=0;
		}
	    }
	}
	//int cSpacing = c.getHand().size()*5;
	//int pSpacing = p.getHand().size()*5;
	if (p.getHand().size() > 13){
	    for (int i = 0; i < 13;i++){
		p.getHand().getCard(i).setXCor((GamePlay.myWidth/2
						-((13*75)/2))
					       +i*75);
		if(p.getHand().getCard(i).selected()){
		    p.getHand().getCard(i).setYCor(450);
		}else{
		    p.getHand().getCard(i).setYCor(460);
		}
		p.getHand().getCard(i).draw(g);
	    }
	    for (int i = 13; i < p.getHand().size();i++){
		p.getHand().getCard(i).setXCor((GamePlay.myWidth/2
						-(((p.getHand().size()-13)*75)/2))
					       +(i-13)*75);
		if(p.getHand().getCard(i).selected()){
		    p.getHand().getCard(i).setYCor(570);
		}else{
		    p.getHand().getCard(i).setYCor(580);
		}
		p.getHand().getCard(i).draw(g);
	    }
	}
	else { 	    
	    for (int i = 0; i < p.getHand().size();i++){
		p.getHand().getCard(i).setXCor((GamePlay.myWidth/2
					       -((p.getHand().size()*75)/2))
					       +i*75);
		if(p.getHand().getCard(i).selected()){
		    p.getHand().getCard(i).setYCor(450);
		}
		else{
		    p.getHand().getCard(i).setYCor(460);
		}
		p.getHand().getCard(i).draw(g);
	    }

	}

	if (c.getHand().size() > 13){

	    for (int i = 0; i < 13;i++){
		c.getHand().getCard(i).setXCor((GamePlay.myWidth/2
					       -((13*75)/2))
					       +i*75);
		c.getHand().getCard(i).setYCor(130);
		c.getHand().getCard(i).draw(g);
	    }
	    for (int i = 13; i < c.getHand().size();i++){
		c.getHand().getCard(i).setXCor((GamePlay.myWidth/2
						-(((c.getHand().size()-13)*75)/2))
					       +(i-13)*75);
		c.getHand().getCard(i).setYCor(10);
		c.getHand().getCard(i).draw(g);
	    }
	}

	else {

	    for (int i = 0; i < c.getHand().size();i++){
		c.getHand().getCard(i).setXCor((GamePlay.myWidth/2
					       -((c.getHand().size()*75)/2))
					       +i*75);
		c.getHand().getCard(i).setYCor(130);
		c.getHand().getCard(i).draw(g);
	    }
	}
	cs.draw(g);
    }
}
