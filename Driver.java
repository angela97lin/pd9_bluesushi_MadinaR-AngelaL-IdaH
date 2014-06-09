import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;

public class Driver {
    public static JFrame driver;
    public static Dimension size = new Dimension(1000,730);
    public Computer c;
    public Player p;
    public Deck deck;
    public static String name = "BS";
    //Since we are only playing with one other player, the computer, we must split the deck into two halves
    //and only use one half for each game. Otherwise, the game would be too easy and almost pointless.
    //As of now, we will use ArrayLists to store these two halves:
    public static ArrayList<Card> deck1;
    // public static ArrayList<Card> deck2 = new ArrayList<Card>();
    //Using stack as our pile in the middle of the table
    public static Stack<Card> pile;
    public Driver(){
	driver = new JFrame("Driver Frame");
	driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	driver.setSize(size);
	driver.setTitle(name);
	driver.setLocationRelativeTo(null);//centers screen
	driver.setResizable(false);
	driver.setLayout(new GridLayout(1,1,0,0));
	//may make more complex? using a image, perhaps?
	driver.getContentPane().setBackground(Color.GREEN);
	init();
	driver.setVisible(true);

      

    }

    //initiates the game with music and a split deck--will be called in the constructor
    //since we want these things when we run our game :)
    public void init(){
	//intiates our instance variables for useful things!
	//dummy arraylist as placeholder for constructor parameters
	ArrayList<Card> dummy = new ArrayList<Card>();
	//Number in c's parameter indicates how smart it is (see Computer class)
	c = new Computer(dummy,1);//CHANGE HERE BASED ON WHAT USER CLICKS AS LEVEL
	p = new Player(dummy);

	pile = new Stack<Card>();

	//plays music! 
	//we may possibly add onto this, if we have time to, and allow users to choose music :)
	Music m = new Music();
	m.play();

	//deals cards to computer and player
	Deck deck = new Deck();
	deck.deal(deck.half,c,p);

	//sets the background of our frame to a specific image of our choosing
	//(problem is, resizing does not work)
	try {
        BufferedImage myImage = ImageIO.read(new File("background.jpg"));
	driver.setContentPane(new ImagePanel(myImage));
	} catch (Exception e){
	}
    }

  




    public static void main(String[] args){
	Driver d = new Driver();

    }




}

