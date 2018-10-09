package com.codecool.dojo;

import java.util.LinkedList;

public class Node {
    private static int size;

    private Node previous;
    private Node element;
    private Node next;

    private Node first;
    private Node last;

    public Node(){}


    private Node(Node prev, Node element, Node next) {
        this.element = element;
        this.next = next;
        this.previous = prev;
    }


    private void firstElement(Node e){
        final Node f = first;
        final Node newNode = new Node(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
    }

    void linkBefore(Node e, Node succ) {
        final Node pred = succ.previous;
        final Node newNode = new Node(pred, e, succ);
        succ.previous = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }



    void LinkLast(Node e){
        final Node l = last;
        final Node newNode = new Node(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }


    public void addFirst(Node e) {
        firstElement(e);
    }


    public void addLast(Node e) {
        LinkLast(e);
    }


    // v1
    public void add(Node e) {
        if (next == null)
            LinkLast(e);
        else
            linkBefore(e, next);

    }


    // appended as last element
    public boolean append(Node e) {
        LinkLast(e);
        return true;
    }


    public void insert(int index, Node element) {
        if (index == size)
            LinkLast(element);
        else
            linkBefore(element, node(index));
    }


    private Node node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }


    public int length(){
        return size;
    }

    public void remove(){}

}
