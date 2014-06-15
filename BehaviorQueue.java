import java.util.ArrayList;


public class BehaviorQueue<T> implements Queue<T> {

    private ArrayList<T> _queue;

    // default constructor
    public BehaviorQueue() {
        _queue = new ArrayList<T>();
    }

    // means of adding an item to collection
    public void enqueue( T x ) {
        _queue.add(x);
    }//O(1) and O(n) when resizing array after it is full and you want to enqueue an element


    // means of removing an item from collection
    public T dequeue() {
        return _queue.remove(0);
    }//O(n)


    // means of "peeking" at the front item
    public T peekFront() {
	if(isEmpty()) return null;
	else return _queue.get(0);
    }//O(1)


    // means of checking to see if collection is empty
    public boolean isEmpty() {
        return _queue.size() == 0;
    }//O(1)

    public String toString() {
        String retStr = "";
        for(int x = 0; x < _queue.size(); x++)
            retStr += _queue.get(x) + " ";
        return retStr;
    }

    //main method for testing
    public static void main( String[] args ) {

    }//end main


}//end class ALQueue