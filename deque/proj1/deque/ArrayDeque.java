package deque;

public class ArrayDeque<T> implements Deque<T> {

    private int front;
    private int size;
    private int back;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = -1;
        back = 0;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        items = newArray;
        // if empty, reset to beginning conditions
        if (size == 0) {
            front = -1;
            back = 0;
        } else {
            front = 0;
            back = size - 1;
        }

    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            // if full, resize (double capacity)
            resize(items.length * 2);
        }

        // if there is nothing in the array, adding new item will make front+back point to the same value
        if (front == -1) {
            front = 0;
            back = 0;
        }
        // if front is at the end of the array, move to the other end (circular)
        else if (front == 0) {
            front = items.length - 1;
        }
        // else move down one value as usual
        else {
            front--;
        }
        items[front] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            // if full, resize (double capacity)
            resize(items.length * 2);
        }

        // if there is nothing in the array, adding new item will make front+back point to the same value
        if (front == -1) {
            front = 0;
            back = 0;
        }
        // if back is at the end of the array, move to the other end (circular)
        else if (back == items.length - 1) {
            back = 0;
        }
        // else move up one value as usual
        else {
            back++;
        }

        items[back] = item;
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        // if empty return null
        if (size == 0) {
            return null;
        }
        // save the value of the first
        T deletedItem = items[front];
        // delete it
        items[front] = null;

        // if only one item in deque, remove it and set front and back to negative and end
        if (size == 1) {
            front = -1;
            back = 0;
            size = 0;
            return (T) deletedItem;
        }

        size--;

        // if front is at the end of the array, move it to the other end (circular)
        if (front == items.length - 1) {
            front = 0;
        }
        // else just move up (usually move down so opposite)
        else {
            front++;
        }
        // For arrays of length 16 or more,  usage factor should always be at least 25%.
        if (size >= 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return (T) deletedItem;
    }

    @Override
    public T removeLast() {
        // if empty return null
        if (size == 0) {
            return null;
        }
        // save the value of the last
        T deletedItem = items[back];
        // delete it
        items[back] = null;

        // if only one item in deque, remove it and set front and back to negative and end
        if (size == 1) {
            front = -1;
            back = 0;
            size = 0;
            return (T) deletedItem;
        }

        size--;

        // if back is at the end of the array, move it to the other end (circular)
        if (back == 0) {
            back = items.length - 1;
        }
        // else just move down (usually move up so opposite)
        else {
            back--;
        }

        // For arrays of length 16 or more,  usage factor should always be at least 25%.
        if (size >= 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }

        return (T) deletedItem;
    }

    @Override
    public T get(int index) {
        return items[(front + index) % items.length];

    }

    @Override

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(Deque.class.isAssignableFrom(o.getClass()))) {
            return false;
        }
        Deque<T> i = (Deque<T>) o;
        if (i.size() != this.size) {
            return false;
        }
        if ((i.get(0)).getClass() != (this.get(0)).getClass()) {
            return false;
        }

        for (int x = 0; x < size; x++) {
            if (!(i.get(x).equals(this.get(x)))) {
                return false;
            }
        }
        return true;
    }
}
