public class TestCard {

    public static void main(String[]args) {
        Card a = new Card(2, "Spade");
        Card c = new Card(3, "Diamond");
        Card d = new Card(3, "Diamond");
        Card e = new Card(5, "Hearts");
        Card f = new Card(6, "Clover");
        Card g = new Card(6, "Spade");
        
        System.out.println(a.compareTo(c)); //-1
        System.out.println(c.compareTo(d)); // 0
        System.out.println(g.compareTo(f)); // 1
        System.out.println(e.compareTo(a)); // 1
       
    }

}