package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    public Node head = null;
    public Node tail = null;
    Integer count = 0;

    public class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            count = 1;
        } else {
            tail.next = newNode;
            tail = newNode;
            count++;
        }
    }

    public Integer size () {
        return count;
    }

    public void removeNode (int index) {
        Node current = head;
        if(current == null){
            return;
        }
        else if (index == 0){
            current = current.next;
            count--;
        }

        int counter = 0;
        while (current != null){
            if(counter == index-1) {
                current.setNext(current.getNext().getNext());
                count--;
                break;
            }

            current = current.next;
            counter++;

        }
    }

    public boolean contains (int data) {
        Node current = head;
        while(current != null){
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find (int data) {
        Node current = head;
        int counter =0;
        while (current != null) {
            if (current.data == data ){
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    public int get(int index) {
        Node current = head;
        int counter = 0;
        if (current == null) {
            return -1;
        }
        while (current != null) {
            if (counter == index) {
                return current.data;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    public SinglyLinkedList copy () {
        SinglyLinkedList myCopy = new SinglyLinkedList();
        Node current = this.head;
        while (current != null) {
            myCopy.addNode(current.data);
            current = current.next;
        }
        return myCopy;
    }

    public SinglyLinkedList sort () {
        Node current = head, nextNode = null;
        int temp;

        while(current != null){
            nextNode = current.next;
            while (nextNode != null){
                if(current.data > nextNode.data){
                    temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
        return this;
    }

}
