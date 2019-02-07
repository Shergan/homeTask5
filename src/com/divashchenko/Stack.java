package com.divashchenko;

public interface Stack {
    void addFirst(int value);

    int peekFirst();

    int removeFirst();

    void push(int value);

    int pull();
}
