/*
 This class will be called on by the Computer whenever it tries to make a move.
 The computer will have a specified behavior, which will be stored
 in this class.
 */

public class Behavior {
    
    private static int trickery;
    private static String response;
    private static String[] adjective = {
    //little to no confidence
    "anxiously", "nervously", "restlessly",
    "apprehensively", "hastily","hurriedly", "briskly",
    //medium confidence:
    "eagerly", "with no apparent reaction", "energetically", "seriously",
    "carefully", "quietly", "impatiently",
    //lots of confidence:
    "assertively", "assuredly", "with conviction", "while laughing loudly",
    "confidently", "enthusiastically", "purposefully" };
    
    
    public Behavior() {
        setStr();
    }
    
    public Behavior(int trick) {
        trickery = trick;
        setStr();
    }
    
    public static String getStr() {
        return response;
    }
    
    /*
     * Trickery from 1-21    Easy 1-7, Medium 8-14, Hard 15-21
     
     public static void setStr() {
     int percent = ((21 - trickery) * 100 / 21);
     
     if(percent >= (Math.random() * 100)) {
     if(trickery >= 1 && trickery <= 7)
     response = adjective[(int) (Math.random() * 7)];
     else if (trickery >= 7 && trickery <= 14)
     response = adjective[(int) (Math.random() * 7) + 7];
     else
     response = adjective[(int) (Math.random() * 7) + 14];
     //System.out.println("1");
     }
     
     else {
     response = adjective[(int)(Math.random() * adjective.length)];
     //System.out.println("2");
     }
     
     } */
    
    public static void setStr() {
        response = "The computer placed down the card " + adjective[trickery]+".";
    }
  
    
}
