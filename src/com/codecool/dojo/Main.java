package com.codecool.dojo;

public class Main {
    private static int numOfNodes = 10;

    public static void main(String[] args) {
        createNodes();
    }

    private static void createNodes(){
        Node node1 = new Node();
        node1.addFirst(node1);


        Node node2 = new Node();
        node2.append(node2);

        Node node3 = new Node();
        node3.addLast(node3);


        System.out.println(node1);
    }
}
