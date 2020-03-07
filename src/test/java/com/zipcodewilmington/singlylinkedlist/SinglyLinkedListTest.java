package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList mylist;

    @Before
    public void setUp() throws Exception {
        mylist = new SinglyLinkedList();
        mylist.addNode(15);
        mylist.addNode(20);
        mylist.addNode(28);
        mylist.addNode(42);
        mylist.addNode(7);
    }

    @Test
    public void addNode() {
        mylist.addNode(82);
        Integer expected = 6;
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNode() {
        Integer expected = 4;
        mylist.removeNode(0);
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNode2() {
        Integer expected = 4;
        mylist.removeNode(4);
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNode3() {
        mylist.removeNode(1);
        Assert.assertFalse(mylist.contains(20));
    }

    @Test
    public void find() {
        Integer expected = -1;
        Integer actual = mylist.find(37);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find2() {
        Integer expected = 2;
        Integer actual = mylist.find(28);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        Integer expected = 20;
        Integer actual = mylist.get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get2() {
        Integer expected = -1;
        Integer actual = mylist.get(8);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        Integer expected = 5;
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTest() {
        boolean expected = true;
        boolean actual = mylist.contains(28);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest () {

        Integer expected = mylist.get(3);
        Integer actual = mylist.copy().get(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sort () {

        SinglyLinkedList actual = mylist.sort();
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.addNode(7);
        expected.addNode(15);
        expected.addNode(20);
        expected.addNode(28);
        expected.addNode(42);
        for (int i = 0; i < mylist.size(); i++){
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }



}