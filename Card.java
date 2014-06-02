public class Card {
    
    private int intValue;
    private String suit; 
    //private String faceValue;

    public Card(int x, String s) {
	if(x >= 1 && x <= 13)
	    intValue = x;
	if(s.equalsIgnoreCase("Clover") || s.equalsIgnoreCase("Hearts") ||
	   s.equalsIgnoreCase("Spade") || s.equalsIgnoreCase("Diamond"))
	    suit = s;
    }
    
    public int getIntVal() {
	return intValue;
    }

    public String getSuit() {
	return suit;
    }

    public boolean equals(Card other) {
	return other.getIntVal() == getIntVal();
    }

}