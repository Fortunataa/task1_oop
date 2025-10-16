package org.example;

public interface LinkedCyclicList<T> {
    int size();
    boolean isEmpty();
    void clear();
    void add(T data);
    void addByIndex(T data, int index);
    void addFirst(T data);
    void deleteFirst();
    void deleteLast();
    void deleteNode(T data);
    void deleteByIndex(int index);
    T get(int index);
    int indexOf(T data);
    boolean contains(T data);
    String toString();
    T getFirst();
    T getLast();
}
