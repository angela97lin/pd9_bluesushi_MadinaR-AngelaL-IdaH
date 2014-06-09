/*
    This class will be called on by the Computer whenever it tries to make a move.
    The computer will have a specified behavior, which will be stored
    in this class.
 */

public class Behavior {
    
    String response;
    int trickery, gullibility;
    
    public Behavior(int gullibility , int trickery) {
        this.gullibility = gullibility;
        this.trickery = trickery;
    }
    
    
}