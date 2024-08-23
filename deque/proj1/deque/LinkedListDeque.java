package deque;

public class LinkedListDeque<T> implements Deque<T> {

    private final LinkedListNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new LinkedListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public T getRecursive(int index) {
        if (index > size || index < 0 || sentinel.next == null) {
            return null;
        }

        return helperRecursive(index, sentinel.next);
    }

    private T helperRecursive(int index, LinkedListNode i) {
        if (index == 0) {
            return i.item;
        }
        return helperRecursive(index - 1, i.next);
    }

    @Override
    public void addFirst(T item) {
        LinkedListNode i = new LinkedListNode(sentinel, item, sentinel.next);
        i.next.prev = i;
        sentinel.next = i;
        size++;
    }

    @Override
    public void addLast(T item) {
        LinkedListNode i = new LinkedListNode(sentinel.prev, item, sentinel);
        i.prev.next = i;
        sentinel.prev = i;
        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedListNode l = sentinel.next;
        while (l != sentinel) {
            System.out.print(l.item + " ");
            l = l.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        LinkedListNode i = sentinel.next;
        i.next.prev = sentinel;
        sentinel.next = i.next;
        i.prev = null;
        i.next = null;
        return i.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        LinkedListNode i = sentinel.prev;
        i.prev.next = sentinel;
        sentinel.prev = i.prev;
        i.prev = null;
        i.next = null;
        return i.item;
    }

    @Override
    public T get(int index) {
        LinkedListNode x;
        if (index >= size || index < 0) {
            return null;
        } else {
            x = this.sentinel.next;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.item;
        }
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

        for (int x = 0; x < this.size; x++) {
            if (!(i.get(x).equals(this.get(x)))) {
                return false;
            }
        }
        return true;
    }

    private class LinkedListNode {
        public LinkedListNode next;
        public T item;
        public LinkedListNode prev;

        LinkedListNode(LinkedListNode prev, T item, LinkedListNode next) {
            this.next = next;
            this.item = item;
            this.prev = prev;
        }
    }


}
