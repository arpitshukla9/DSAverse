import java.util.Stack;

public class ReverseDLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }

    public static Node arrayToDLL1(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }

    public static void traverse1(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void traverseprevward(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    public static Node reverseDLList(Node head) {
        // -------BRUTE_FORCE-------- TC - O(2N) and SC - O(N) as we use stack datatype
        // If list is empty or has one element, return it
        if (head == null || head.next == null) return head;
        // Stack to store node values
        Stack<Integer> st = new Stack<>();
        // Pointer to traverse list
        Node temp = head;
        // Push all node data to stack
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        // Reset temp to head
        temp = head;
        // Replace node values from stack
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        // Return updated head
        return head;
    }

    public static Node reverseDLListOptimal(Node head) {
        // -----------OPTIMAL--------- TC - O(N) and SC - O(1)
        // Pointer to traverse the list
        Node current = head;

        // Variable to eventually store new head after reversal
        Node last = null;

        // Traverse the entire list
        while (current != null) {

            // Swap next and prev pointers of current node
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            // Move last pointer to current (this will become new head)
            last = current;

            // Move to next node (originally current.next but now is prev due to swap)
            current = temp;
        }

        // Return the new head (was the last node in original list)
        return last;

    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        Node ans = arrayToDLL1(arr);
        // System.out.println(ans);
        // traverse1(ans);
        // traverseprevward(ans);
        Node rev = reverseDLList(ans);
        // traverse1(rev);
        Node revOpt = reverseDLListOptimal(ans);
        traverse1(revOpt);

    }
}
