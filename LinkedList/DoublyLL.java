
class Node {

    int data;
    Node next;
    Node back;

    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DoublyLL {

    static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            int prev = (temp.back == null) ? -1 : temp.back.data;
            int next = (temp.next == null) ? -1 : temp.next.data;
            // System.out.println(
            //     "Prev: " + prev +
            //     " Data: " + temp.data +
            //     " Next: " + next
            // );
            System.err.println(temp.data);
            temp = temp.next;
        }
    }

    static Node arrayToDLL(int[] arr) {
// Har iteration me ye 3 kaam hote hain:
// prev.next = temp; // aage jodo
// temp.back = prev; // peeche jodo
// prev = temp; // prev ko aage le jao
// Ek trick yaad rakhna:
// "Naya node banao → dono taraf connect karo → prev ko aage badhao."
        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.back = prev;
            prev = temp;
        }
        return head;
    }

    // ---------------DELETION--------------------
    static Node deleteHeadDLL(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    static Node deleteTailDLL(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next.back = null;
        temp.next = null;
        return head;
    }

    static Node deleteKthNode(Node head, int k){
        if(head == null) return null;
        // delete head
        if(k == 1) return deleteHeadDLL(head);
        Node temp = head;
        int count = 1;
        while(temp != null){
        if(count == k) break;
        temp = temp.next;
        count++;
    }
    // k > length of DLL
        if(temp == null) return head;

    // delete tail
        if(temp.next == null) return deleteTailDLL(head);

    // delete middle node
        Node prev = temp.back;
        Node front = temp.next;

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;

    return head;
}
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9};
        Node head = arrayToDLL(arr);
        // traverse(deleteHeadDLL(head));
        // traverse(deleteTailDLL(head));
        traverse(deleteKthNode(head, 4));

    }
}
