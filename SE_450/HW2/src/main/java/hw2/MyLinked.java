package hw2;

/**
 * MyLinked class
 */
public class MyLinked {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    /**
     * Class member variables
     */
    int N;
    Node first;

    /**
     * Default constructor - Initializing class member variables
     */
    public MyLinked () {
        first = null;
        N = 0;
        assert checkInvariants ();
    }

    /**
     * Checking state of variables
     * @return
     */
    private boolean checkInvariants() {
        assert((N != 0) || (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                return false;
            }
            x = x.next;
        }
        assert(x == null);
        return true;
    }

    /**
     * Return null if first node is empty
     * @return
     */
    public boolean isEmpty () { return first == null; }

    /**
     * Return size of the list
     * @return
     */
    public int size () { return N; }

    /**
     *  Adding new node in linked list
     * @param item Item to be added in the list
     */
    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }

    /**
     * Delete the kth element
     * @param k Position to delete from linked list
     */
    public void delete (int k) {
        if (k < 0 || k > N) throw new IllegalArgumentException ();
        assert checkInvariants ();

        Node firstNode = first;
        Node prev = null;

        int count = 0;
        while (firstNode != null)
        {
            count++;

            if(k == 1){
                first = first.next;
                N--;
                assert (N>=0); //Validating size of linked list after removing items
                return;
            } else if (k == count) {
                prev.next = firstNode.next;
                N--;
                assert (N>=0); //Validating size of linked list after removing items
                return;
            }

            if (count != 0)
                prev = firstNode;

            firstNode = prev.next;
        }
    }

    /**
     * Reverse the list "in place"... without creating any new nodes
     */
    public void reverse () {
        assert checkInvariants ();
        Node prev = null;
        Node current = first;
        Node next = first;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        first = prev;
        return ;
    }

    /**
     *  Remove given item from the list
     * @param item Item to be removed from the list
     */
    public void remove (double item) {
        assert checkInvariants ();

        Node firstNode = first;
        Node prev = null;

        int count = 0;
        while (firstNode != null)
        {
            count++;
            if(first.item == item){
                first = first.next;
                N--;
                assert (N>=0); //Validating size of linked list after removing items
            } else if (prev != null && firstNode.item == item) {
                prev.next = firstNode.next;
                count = 0;
                N--;
                assert (N>=0); //Validating size of linked list after removing items
            }
            if (count != 0)
                prev = firstNode;
            firstNode = prev.next;
        }
    }

    /**
     * Function to print elements of linked list
     * @param s String parameter
     * @param b Linkedlist object
     */
    public static void print (String s, MyLinked b) {
        System.out.print (s + ": ");
        for (Node x = b.first; x != null; x = x.next)
            System.out.print (x.item + " ");
        System.out.println ();
    }

}

































