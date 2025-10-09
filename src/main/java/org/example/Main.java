package org.example;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedCyclicList<Integer> list = new DoublyLinkedCyclicList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        list.addByIndex(567, 1);
        System.out.println(list);
        list.addFirst(172);
        System.out.println(list);
        if (list.contains(172)) {
            System.out.println("172 найдено в списке");
        }
        System.out.println("Элементов в списке: " + list.size());
        list.deleteNode(561);
        System.out.println(list);
        list.deleteByIndex(0);
        System.out.println(list);
        System.out.println(list.get(2));

        list.clear();
        System.out.println(list);
    }
}