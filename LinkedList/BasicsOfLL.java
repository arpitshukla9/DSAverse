import java.util.*;
public class BasicsOfLL {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        System.out.println("Node created with data: " + head.data);
    }
}
