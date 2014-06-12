// Ida Huang
// APCS2 Period 9
// HW40
// 2014-05-17

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Card> _heap; //underlying container is array of Integers
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Card>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
	//simple version:
	//return _heap.toString(); 

	//prettier version:
	String lvlOrdTrav = "heap size " + _heap.size() + "\n";

	if ( _heap.size() == 0 ) return lvlOrdTrav;

	int h = 1; //init height to 1
	for( int i = 0; i < _heap.size(); i++ ) {
	    lvlOrdTrav += i + ":" + _heap.get(i) + " ";
	    if ( i >= Math.pow(2,h) - 2 ) {
		lvlOrdTrav += "\n";
		h++;
	    }
	}
	return lvlOrdTrav;
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() { return _heap.isEmpty(); } //O(1)



    /*****************************************************
      * Integer peekMin()
      * Returns min value in heap
      * Postcondition: Heap remains unchanged.
      *****************************************************/
    public Integer peekMin() { 
	if ( _heap.size() < 1 ){
	    return null;
	}
	else
	    return _heap.get(0).getIntVal();
    } //O(1)

    /*****************************************************
      * Integer getMin()
      * Returns min value in heap
      * Postcondition: Heap remains unchanged.
      *****************************************************/
    public Card getMin() { 
	    return _heap.get(0);
    } //O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Card add ) { 

	int addVal = add.getIntVal();
	//Add value as last node, to maintain balance, completeness of tree
	_heap.add( add );

	int addValPos = _heap.size() - 1;
	int parentPos;

	while( addValPos > 0 ) { //potentially swap until reach root

	    //pinpoint parent
	    parentPos = (addValPos-1) / 2;

	    if (  addVal  <  _heap.get(parentPos).getIntVal() )   {//add < parent
		swap( addValPos, parentPos );
		addValPos = parentPos;
	    }
	    else 
		break;
	}
    } //O(logn)

    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() {

	if ( _heap.size() == 0 ) 
	    return null;

	//store root value for return at end of fxn
	Integer retVal = peekMin();

	//store val about to be swapped into root
	Card foo = _heap.get( _heap.size() - 1);

	//swap last (rightmost, deepest) leaf with root
	swap( 0, _heap.size() - 1 );

	//lop off last leaf
	_heap.remove( _heap.size() - 1);

	// walk the now-out-of-place root node down the tree...
	int pos = 0;
	int minChildPos;

	while( pos < _heap.size() ) {

	    //choose child w/ min value, or check for child
	    minChildPos = minChildPos(pos);

	    //if no children, then i've walked far enough
	    if ( minChildPos == -1 ) 
		break;
	    //if i am less than my least child, then i've walked far enough
	    else if ( foo.getIntVal() <=  _heap.get(minChildPos).getIntVal()  ) 
		break;
	    //if i am > least child, swap with that child
	    else {
		swap( pos, minChildPos );
		pos = minChildPos;
	    }
	}
	//return removed value
	return retVal;
    }//O(logn)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= _heap.size() )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( _heap.get(lc).getIntVal() < _heap.get(rc).getIntVal() )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)



    //************ aux helper fxns ***************
    private Card  minOf( Card a, Card b ) {
	Integer aVal = a.getIntVal();
	Integer bVal = b.getIntVal();
	if ( aVal.compareTo(bVal) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {

	ALHeap pile = new ALHeap();

	pile.add(new Card(2, "Clover"));
	System.out.println(pile);
	pile.add(new Card(10, "Hearts"));
	System.out.println(pile);
	pile.add(new Card(13, "Diamond"));
	System.out.println(pile);
	pile.add(new Card(9, "Clover"));
	System.out.println(pile);
	pile.add(new Card(1, "Hearts"));
	System.out.println(pile);
	pile.add(new Card(5, "Spade"));
	System.out.println(pile);
	pile.add(new Card(2, "Spade"));
	System.out.println(pile);
        pile.add(new Card(10, "Spade"));
	System.out.println(pile);
	pile.add(new Card(7, "Diamonds"));
	System.out.println(pile);
	pile.add(new Card(11, "Spade"));
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
    }//end main()

}//end class ALHeap