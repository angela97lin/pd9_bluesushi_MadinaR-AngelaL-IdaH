import java.util.ArrayList;


public class BehaviorQueue implements Queue<Behavior> {
    
    private ArrayList<Behavior> _queue;
    
    // default constructor
    public BehaviorQueue() {
        _queue = new ArrayList<Behavior>();
    }
    
    // means of adding an item to collection
    public void enqueue( Behavior x ) {
        _queue.add(x);
    }//O(1) and O(n) when resizing array after it is full and you want to enqueue an element
    
    
    // means of removing an item from collection
    public Behavior dequeue() {
        return _queue.remove(0);
    }//O(n)
    
    
    // means of "peeking" at the front item
    public Behavior peekFront() {
        if(isEmpty()) return null;
        else return _queue.get(0);
    }//O(1)
    
    public Behavior peekBack() {
        if(isEmpty()) return null;
        else return _queue.get(size() - 1);
    }
    
    public int size() {
        return _queue.size();
    }
    
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