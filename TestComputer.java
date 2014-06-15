import java.util.ArrayList;

/*
 * Class created solely for testing purposes
 */
public class TestComputer {

    public static void main(String[] args) {
        Computer c = new Computer(new ArrayList<Card>(12), 3);
        for(int x = 0; x < 20; x++) {
            c.defineBehavior();
            System.out.println(c.seeBehavior());
        }
    }
    
}
