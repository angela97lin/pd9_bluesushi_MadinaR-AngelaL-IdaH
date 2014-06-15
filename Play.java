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
    }

    public void go(){
	placed = 0;
	for (int i = 0; i < p.getHand().size();i++){
	    if (p.getHand().getCard(i).selected()){
		cs.add(p.getHand().remove(p.getHand().getCard(i)));
		placed ++;
	    }
	}
    }
    
    public void checkAll(float x, float y){
	for (int i =0; i < p.getHand().size();i++){
	    if(p.getHand().getCard(i).isBetween(x,y)){
		if(!(p.getHand().getCard(i).selected())){
		    p.getHand().getCard(i).select();
		}else{
		    p.getHand().getCard(i).unselect();
		}
	    }
	}
    }

    public void bs(){
	int cardNum = 1;
	while(placed > 0){
	    cs.pop().reveal(cardNum);
	    placed --;
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
	
	
	//int cSpacing = c.getHand().size()*5;
	//int pSpacing = p.getHand().size()*5;
	if (p.getHand().size() > 13){

	    for (int i = 0; i < 13;i++){
		p.getHand().getCard(i).setXCor((GamePlay.myWidth/2
						-((c.getHand().size()*75)/2))
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
					       -((c.getHand().size()*75)/2))
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
					       -((c.getHand().size()*75)/2))
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
					       -((c.getHand().size()*75)/2))
					       +i*75);
		c.getHand().getCard(i).setYCor(130);
		c.getHand().getCard(i).draw(g);
	    }
	    for (int i = 13; i < c.getHand().size();i++){
		c.getHand().getCard(i).setXCor((GamePlay.myWidth/2
					       -((c.getHand().size()*75)/2))
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
    }

}
