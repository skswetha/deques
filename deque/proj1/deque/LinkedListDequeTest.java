package deque;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Performs some basic linked list deque tests.
 */
public class LinkedListDequeTest {

    /**
     * You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!
     */

    public static LinkedListDeque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
        lld.addFirst(0);

        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!


    }

    /**
     * Adds an item, removes an item, and ensures that dll is empty afterwards.
     */
    @Test
    public void addRemoveTest() {
        lld.addFirst(0);
        lld.removeFirst();
        assertTrue(lld.isEmpty());

    }

    /**
     * Make sure that removing from an empty LinkedListDeque does nothing
     */
    @Test
    public void removeEmptyTest() {
        assertTrue(lld.isEmpty());
        lld.removeFirst();
        assertTrue(lld.isEmpty());
    }

    /**
     * Make sure your LinkedListDeque also works on non-Integer types
     */
    @Test
    public void multipleParamsTest() {
        LinkedListDeque ld = new LinkedListDeque<Double>();
        LinkedListDeque ls = new LinkedListDeque<String>();
    }

    /**
     * Make sure that removing from an empty LinkedListDeque returns null
     */
    @Test
    public void emptyNullReturn() {
        lld = new LinkedListDeque<Integer>();
        assertTrue(lld.isEmpty());
        assertEquals(lld.removeFirst(), null);

    }

    /**
     * numbers of elements, and test any other methods you haven't yet tested!
     */


    @Test
    public void addFirstTest() {
        assertTrue(lld.isEmpty());
        lld.addFirst(1);
        lld.addFirst(0);
        lld.printDeque();
        assertTrue(lld.get(0) == 0);
        assertTrue(lld.get(1) == 1);

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void addLastTest() {
        assertTrue(lld.isEmpty());
        lld.addLast(1);
        lld.addLast(2);
        lld.printDeque();
        assertTrue(lld.get(0) == 1);
        assertTrue(lld.get(1) == 2);

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void isEmptyTest() {
        lld = new LinkedListDeque<Integer>();
        assertTrue(lld.isEmpty());
    }

    @Test
    public void removeFirstTest() {
        lld.addLast(0);
        lld.addLast(1);
        lld.removeFirst();
        assertTrue(lld.size() == 1);
        assertTrue(lld.get(0) == 1);

        lld = new LinkedListDeque<Integer>();

    }

    @Test
    public void removeLastTest() {
        lld.addLast(0);
        lld.addLast(1);
        lld.addLast(2);
        lld.removeLast();

        assertTrue(lld.size() == 2);
        assertTrue(lld.get(0) == 0);
        assertTrue(lld.get(1) == 1);

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void addLastandFirstTest() {
        lld.addFirst(1);
        lld.addLast(2);
        lld.addFirst(0);
        lld.addLast(3);
        lld.printDeque();

        assertTrue(lld.get(0) == 0);
        assertTrue(lld.get(1) == 1);
        assertTrue(lld.get(2) == 2);
        assertTrue(lld.get(3) == 3);

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void getRecursiveTest() {
        assertTrue(lld.isEmpty());
        assertTrue(lld.getRecursive(2) == null);

        lld.addFirst(1);
        lld.addLast(2);
        lld.addFirst(0);
        lld.addLast(3);

        assertTrue(lld.getRecursive(0) == 0);
        assertTrue(lld.getRecursive(1) == 1);
        assertTrue(lld.getRecursive(2) == 2);
        assertTrue(lld.getRecursive(3) == 3);
        assertTrue(lld.getRecursive(5) == null);
        assertTrue(lld.getRecursive(-3) == null);

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void equalsTest() {
        LinkedListDeque<Integer> testing = new LinkedListDeque<Integer>();
        testing.addFirst(2);
        testing.addFirst(1);
        testing.addFirst(0);

        lld.addFirst(2);
        lld.addFirst(1);
        lld.addFirst(0);

        assertTrue(lld.equals(testing));

        testing.addLast(3);
        assertFalse(lld.equals(testing));

        lld = new LinkedListDeque<Integer>();
    }

    @Test
    public void testdifferentTypes() {
        LinkedListDeque s = new LinkedListDeque<String>();
        LinkedListDeque d = new LinkedListDeque<Double>();
        s.addFirst("hello");
        s.addLast("goodbye");
        d.addFirst(0.0);
        d.addLast(1.0);
        assertFalse(s.equals(d));

        String stri = "dajiweoajw";
        assertFalse(d.equals(stri));
    }
}
