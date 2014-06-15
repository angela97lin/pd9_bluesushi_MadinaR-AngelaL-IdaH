/*
    This class will be called on by the Computer whenever it tries to make a move.
    The computer will have a specified behavior, which will be stored
    in this class.
 */

public class Behavior {
    
    String response;
    int trickery, gullibility;
    BehaviorQueue actions;
    
    
    public Behavior(int gullibility , int trickery) {
        this.gullibility = gullibility;
        this.trickery = trickery;
    }
    
    /*
     Will return an array containing all of the necessary information
     for the computer to make a move.
     The following will be the format for the output:
     ["Behavioral String, ex. Giggled nervously",
        "a string that contains an integer of the # of cards to remove from hand",
     
     ]
     */
    public String[] act(int numCards) {
        if(numCards == 0 && trickery >= ((Math.random() * 21) + 1) )
            response = actions.dequeue();
    }
}