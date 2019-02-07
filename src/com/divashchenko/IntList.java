package com.divashchenko;

public interface IntList {

    void add(int value);

    void clear();

    boolean contains(int value);

    int get(int index);

    void set(int index, int element);

    int size();

    boolean isEmpty();
}
