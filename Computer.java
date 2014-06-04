
//Similar to the Player class; However, everything is randomized.

import java.util.*;
import java.io.*;

public class Computer {

    private Hand hand;

    //CONSTRUCTOR: must set up hand
    public Computer(ArrayList<Cards> cards){
        cards.add(
        hand = new Hand(cards);
    }

    
                  
    //public accessor to hand
    public Hand getHand() {
            return hand;
    }
}

