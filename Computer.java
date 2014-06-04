
//Similar to the Player class; However, everything is randomized.

import java.util.*;
import java.io.*;

public class Computer {

    private Hand hand;
 

    //CONSTRUCTOR: must set up hand
    public Computer(){
	hand = new Hand([INSERT ARRAYLIST HERE]);
    }

    //public accessor to hand
    public Hand getHand() {
	return hand;
    }
}

