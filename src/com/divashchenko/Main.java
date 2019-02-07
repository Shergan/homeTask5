package com.divashchenko;

public class Main {

    public static void main(String[] args) {

        IntLinkedList linkedList = new IntLinkedList();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        System.out.println(linkedList);
        System.out.println();

        System.out.println("Is 20 here? " + linkedList.contains(10));
        System.out.println("And 100? " + linkedList.contains(100));
        System.out.println();

        System.out.println("Get element '0': " + linkedList.get(0));
        System.out.println("Get element '1': " + linkedList.get(1));
        System.out.println("Get element '2': " + linkedList.get(2));
        System.out.println("Get element '3': " + linkedList.get(3));
        System.out.println("Get element '4': " + linkedList.get(4));
        System.out.println();

        linkedList.set(1, 200);
        linkedList.set(2, 300);
        System.out.println(linkedList);
        System.out.println();

        System.out.println("Size: " + linkedList.size());
        System.out.println("Is empty: " + linkedList.isEmpty());
        System.out.println("Clear!");
        linkedList.clear();
        System.out.println("New size: " + linkedList.size());
        System.out.println("Is empty now? " + linkedList.isEmpty());
    }
}
