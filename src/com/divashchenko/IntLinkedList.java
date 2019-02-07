package com.divashchenko;

public class IntLinkedList implements IntList, Stack, Queue {

    private class Element {
        private int value;
        private Element next;
        private Element previous;

        private Element(int value) {
            this.value = value;
        }
    }

    private int count = 0;
    private Element first;
    private Element last;


    @Override
    public void add(int value) {
        Element newElement = new Element(value);
        if (first == null) {
            first = newElement;
            last = first;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }
        count++;
    }

    @Override
    public void addFirst(int value) {
        Element newElement = new Element(value);
        if (first == null) {
            first = newElement;
            last = first;
        } else {
            first.previous = newElement;
            newElement.next = first;
            first = newElement;
        }
        count++;
    }

    @Override
    public int peekFirst() {
        checkFirstElement();

        return first.value;
    }

    @Override
    public int removeFirst() {
        checkFirstElement();

        int tmp = first.value;
        Element tmpElement = first.next;
        tmpElement.previous = null;
        first = tmpElement;
        count--;

        return tmp;

    }

    @Override
    public void push(int value) {
        addFirst(value);
    }

    @Override
    public int pull() {
        return removeFirst();
    }

    @Override
    public int peek() {
        checkFirstElement();

        return first.value;
    }

    @Override
    public int poll() {
        return removeFirst();
    }

    /*    1.1
    public void add(int index, int element) {
        checkIndexRange(index);
        Element newElement = new Element(element);
        Element tmpElement = findElement(index);
        Element tmpPreviousElement = tmpElement.previous;

        tmpPreviousElement.next = newElement;
        newElement.previous = tmpPreviousElement;

        tmpElement.previous = newElement;
        newElement.next = tmpElement;

        count++;
    }
    */

    @Override
    public void clear() {
        count = 0;
        first = null;
        last = null;
    }

    @Override
    public boolean contains(int value) {
        Element tmpElement = first;
        while (tmpElement != null) {
            if (tmpElement.value == value) {
                return true;
            } else {
                tmpElement = tmpElement.next;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        checkIndexRange(index);
        return findElement(index).value;

    }

    @Override
    public void set(int index, int element) {
        checkIndexRange(index);
        findElement(index).value = element;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    private Element findElement(int index) {
        Element tmpElement;

        if (count / 2 + 1 > index) {
            tmpElement = last;
            for (int i = count - 1; i > index; i--) {
                tmpElement = tmpElement.previous;
            }
        } else {
            tmpElement = first;
            for (int i = 0; i < index; i++) {
                tmpElement = tmpElement.next;
            }
        }

        return tmpElement;
    }

    private void checkIndexRange(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Wrong index!");
        }
    }

    private void checkFirstElement() {
        if (first == null) {
            throw new IndexOutOfBoundsException("List is empty!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Element tmpElement = first;
        for (int i = 0; i < count - 1; i++) {
            sb.append(tmpElement.value).append(", ");
            tmpElement = tmpElement.next;

        }
        sb.append(tmpElement.value).append("]");

        return sb.toString();
    }
}
