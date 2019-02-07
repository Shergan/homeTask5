package com.divashchenko;

public class IntLinkedList implements IntList {

    private class Element {
        private int value;
        private Element next;
        private Element previous;

        public Element(int value) {
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

    /*    1.1
    public void add(int index, int element) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Element tmpElement = first;
        for (int i = 0; i < count; i++) {
            sb.append(tmpElement.value).append(", ");
            tmpElement = tmpElement.next;
            if (i == count - 2) {
                sb.append(tmpElement.value).append("]");
                break;
            }
        }

        return sb.toString();
    }
}
