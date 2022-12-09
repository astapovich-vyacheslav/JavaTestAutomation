package com.solvd.it.custom.structures;

import org.apache.log4j.Logger;

import java.lang.reflect.Type;

public class CustomLinkedList<T> {
    private static final Logger log = Logger.getLogger(CustomLinkedList.class);
    private final Node<T> head = new Node<>(null);
    private int size = 0;

    public CustomLinkedList() {
        head.setPrev(null);
        head.setNext(null);
    }

    public boolean add(T element) {
        try {
            Node<T> adr = head;
            while (adr.getNext() != null)
                adr = adr.getNext();
            Node<T> node = new Node<>(element);
            node.setPrev(adr);
            adr.setNext(node);
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(T element) {
        Node<T> adr = head;
        boolean result = false;
        while (adr.getNext() != null) {
            adr = adr.getNext();
            if (adr.getElement() == element) {
                adr.getPrev().setNext(adr.getNext());
                if (adr.getNext() != null)
                    adr.getNext().setPrev(adr.getPrev());
                result = true;
                break;
            }
        }
        size--;
        return result;
    }

    public boolean print() {
        try {
            Node<T> adr = head;
            while (adr.getNext() != null) {
                adr = adr.getNext();
                log.info(adr.getElement().toString());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean printFlipped() {
        try {
            Node<T> adr = head;
            while (adr.getNext() != null)
                adr = adr.getNext();
            while (adr.getPrev() != null) {
                log.info(adr.getElement().toString());
                adr = adr.getPrev();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getSize() {
        return size;
    }
}
