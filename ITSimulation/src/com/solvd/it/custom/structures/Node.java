package com.solvd.it.custom.structures;

public class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private T element;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
