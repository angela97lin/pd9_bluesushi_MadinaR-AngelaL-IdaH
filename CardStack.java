import java.util.*;
import java.io.*;

public class CardStack{

    private Stack<Card> stack;
    public static int expectedVal;

    public CardStack(){
	stack = new Stack<Card>();
	expectedVal = 1;
    }

    public Card pop(){
	return stack.pop();
    }

    public int peek(){
	return stack.peek().getIntVal();
    }

    public void add(Card c){
	stack.push(c);
	//	expectedVal ++; //issue if we add more than one card at a time 
	c.setXCor(GamePlay.myWidth/2-37);
	c.setYCor(GamePlay.myHeight/2-60);
    }


}
