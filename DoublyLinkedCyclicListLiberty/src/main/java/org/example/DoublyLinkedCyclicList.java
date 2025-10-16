package org.example;
import java.util.NoSuchElementException;


public class DoublyLinkedCyclicList<T> implements LinkedCyclicList<T>{
    private Node<T> head;
    private int size;

    private static class Node<E> {
        private final E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoublyLinkedCyclicList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> last = head.prev;
            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public void addByIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
            size++;
            return;
        }

        if (index == 0) {
            Node<T> last = head.prev;
            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
            size++;
            return;
        }

        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        Node<T> previous = curr.prev;
        newNode.next = curr;
        newNode.prev = previous;

        previous.next = newNode;
        curr.prev = newNode;
        size++;
    }

    public void addFirst(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> last = head.prev;
            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == head) {
            head = null;
        } else {
            Node<T> last = head.prev;
            Node<T> newHead = head.next;

            last.next = newHead;
            newHead.prev = last;

            head = newHead;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == head) {
            head = null;
        } else {
            Node<T> last = head.prev;
            Node<T> newLast = last.prev;

            newLast.next = head;
            head.prev = newLast;
        }
        size--;
    }

    public void deleteNode(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> curr = head;
        do {
            if (curr.data.equals(data)) {
                if (size == 1) {
                    head = null;
                } else {
                    Node<T> prevNode = curr.prev;
                    Node<T> nextNode = curr.next;

                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;

                    if (curr == head) {
                        head = nextNode;
                    }
                }
                size--;
                return;
            }
            curr = curr.next;
        } while (curr != head);
        System.out.println("Node with the value " + data + " not found");
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> curr = getNodeByIndex(index);
        if (size == 1) {
            head = null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            if (curr == head) {
                head = curr.next;
            }
        }
        size--;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNodeByIndex(index).data;
    }

    public int indexOf(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.equals(data)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "( )";
        }

        StringBuilder sb = new StringBuilder("(");
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            sb.append(curr.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append(")");
        return sb.toString();
    }

    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.prev.data;
    }
}
