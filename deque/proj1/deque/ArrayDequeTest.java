package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /**
     * You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test.
     */

    public static Deque<Integer> ad = new ArrayDeque<Integer>();

    @Test
    public void addIsEmptySizeTest() {

        assertTrue("A newly initialized adeque should be empty", ad.isEmpty());
        ad.addFirst(0);

        assertFalse("ad1 should now contain 1 item", ad.isEmpty());

        ad = new ArrayDeque<Integer>(); //Assigns ad equal to a new, clean ArrayDeque!


    }

    /**
     * Adds an item, removes an item, and ensures that dll is empty afterwards.
     */
    @Test
    public void addRemoveTest() {
        ad = new ArrayDeque<Integer>();
        ad.addFirst(0);
        ad.removeFirst();
        assertTrue(ad.isEmpty());

    }

    /**
     * Make sure that removing from an empty ArrayDeque does nothing
     */
    @Test
    public void removeEmptyTest() {
        ad = new ArrayDeque<Integer>();
        assertTrue(ad.isEmpty());
        ad.removeFirst();
        assertTrue(ad.isEmpty());
    }

    @Test
    public void testLargeDeque() {
        ArrayDeque ad1 = new ArrayDeque<Integer>();
        ad = new ArrayDeque<Integer>();

        for (int i = 0; i <= 10000; i++) {
            ad.addLast(i);
            ad1.addFirst(10000 - i);
        }
        ad.printDeque();
        ad1.printDeque();

        assertTrue(ad.equals(ad1));
        assertTrue(ad1.equals(ad));

        ad1 = new ArrayDeque<Integer>();
        ad = new ArrayDeque<Integer>();

        for (int i = 0; i <= 10000; i++) {
            ad.addFirst(i);
            ad1.addLast(10000 - i);
        }
        ad1.printDeque();
        ad.printDeque();
        assertTrue(ad1.equals(ad));
        assertTrue(ad.equals(ad1));

        for (int i = 0; i <= 5000; i++) {
            ad.removeFirst();
            ad.removeLast();
        }
        ad.printDeque();


    }


    /**
     * Make sure your ArrayDeque also works on non-Integer types
     */
    @Test
    public void multipleParamsTest() {
        ArrayDeque ld = new ArrayDeque<Double>();
        ld.addFirst(1.2);
        ld.addFirst(2.2);
        ld.addFirst(3.2);
        ld.addLast(0.2);
        ld.removeFirst();
        ld.removeLast();
        ld.printDeque();
        ArrayDeque ls = new ArrayDeque<String>();
        ls.addLast("hello");
        ls.addLast("bye");
        ls.addFirst("o");
        ls.addFirst("l");
        ls.addFirst("l");
        ls.addFirst("e");
        ls.addFirst("h");
        ls.printDeque();
    }

    /**
     * Make sure that removing from an empty ArrayDeque returns null
     */
    @Test
    public void emptyNullReturn() {
        ad = new ArrayDeque<Integer>();
        assertTrue(ad.isEmpty());
        assertEquals(ad.removeFirst(), null);

    }

    /**
     * numbers of elements, and test any other methods you haven't yet tested!
     */


    @Test
    public void addFirstTest() {
        ad = new ArrayDeque<Integer>();

        assertTrue(ad.isEmpty());
        ad.addFirst(1);
        ad.addFirst(0);
        ad.printDeque();
        assertTrue(ad.get(0) == 0);
        assertTrue(ad.get(1) == 1);

    }

    @Test
    public void addLastTest() {
        ad = new ArrayDeque<Integer>();

        assertTrue(ad.isEmpty());
        ad.addLast(1);
        ad.addLast(2);
        ad.printDeque();
        assertTrue(ad.get(0) == 1);
        assertTrue(ad.get(1) == 2);
    }

    @Test
    public void isEmptyTest() {
        ad = new ArrayDeque<Integer>();
        assertTrue(ad.isEmpty());
    }

    @Test
    public void removeFirstTest() {
        ad = new ArrayDeque<Integer>();

        ad.addLast(0);
        ad.addLast(1);
        ad.removeFirst();
        assertTrue(ad.size() == 1);
        assertTrue(ad.get(0) == 1);
    }

    @Test
    public void removeLastTest() {
        ad = new ArrayDeque<Integer>();

        ad.addLast(0);
        ad.addLast(1);
        ad.addLast(2);
        ad.removeLast();

        assertTrue(ad.size() == 2);
        assertTrue(ad.get(0) == 0);
        assertTrue(ad.get(1) == 1);
    }

    @Test
    public void addLastandFirstTest() {
        ad = new ArrayDeque<Integer>();

        ad.addFirst(1);
        ad.addLast(2);
        ad.addFirst(0);
        ad.addLast(3);
        ad.printDeque();

        assertTrue(ad.get(0) == 0);
        assertTrue(ad.get(1) == 1);
        assertTrue(ad.get(2) == 2);
        assertTrue(ad.get(3) == 3);
    }


    @Test
    public void equalsTest() {
        ad = new ArrayDeque<Integer>();

        ArrayDeque testing = new ArrayDeque<Integer>();

        testing.addFirst(2);
        testing.addFirst(1);
        testing.addFirst(0);

        ad.addFirst(2);
        ad.addFirst(1);
        ad.addFirst(0);

        assertTrue(ad.equals(testing));

        testing.addLast(3);
        assertFalse(ad.equals(testing));
    }

    @Test
    public void testsizeAfterRemove() {
        ad = new ArrayDeque<Integer>();

        for (int i = 0; i <= 3; i++) {
            ad.addLast(i);
        }
        ad.printDeque();
        assertTrue(ad.size() == 4);
        ad.removeFirst();
        assertTrue(ad.size() == 3);
        assertTrue(ad.get(0) == 1);
        assertTrue(ad.get(2) == 3);
        ad.removeFirst();
        assertTrue(ad.size() == 2);
        ad.removeFirst();
        assertTrue(ad.size() == 1);
        ad.removeFirst();
        assertTrue(ad.size() == 0);
    }

    @Test
    public void testHavetoResize() {
        ad = new ArrayDeque<Integer>();

        for (int i = 0; i < 100; i++) {
            ad.addLast(i);
        }
        ad.printDeque();
        assertTrue(ad.size() == 100);
        assertTrue(ad.get(0) == 0);
    }

    @Test
    public void testdifferentTypes() {
        ArrayDeque s = new ArrayDeque<String>();
        ArrayDeque d = new ArrayDeque<Double>();
        s.addFirst("hello");
        s.addLast("goodbye");
        d.addFirst(0.0);
        d.addLast(1.0);
        assertFalse(s.equals(d));

        String stri = "dajiweoajw";
        assertFalse(d.equals(stri));
    }

    @Test
    public void testCompareArrayandLinked() {
        ad = new ArrayDeque<Integer>();
        LinkedListDeque test = new LinkedListDeque<Integer>();
        test.addFirst(2);
        test.addFirst(1);
        test.addFirst(0);

        ad.addFirst(2);
        ad.addFirst(1);
        ad.addFirst(0);

        ad.printDeque();
        test.printDeque();
        assertTrue(ad.equals(test));
        assertTrue(test.equals(ad));

        ad.addFirst(-1);
        assertFalse(ad.equals(test));
        assertFalse(test.equals(ad));
    }
}
