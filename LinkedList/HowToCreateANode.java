import java.util.*;

// Node is created using class means they are a kind of objects instantiated from Node class
class Node{
        int data;
        Node next;
        
        Node(int d, Node n){
            this.data = d;
            this.next = n;
        }

        Node(int d){
            this.data = d;
            this.next = null;
        }
}

public class HowToCreateANode{
    public static void main(String [] args){
        // Syntax of instantiating a object from a class
        Node a = new Node(1, null);
    }
}