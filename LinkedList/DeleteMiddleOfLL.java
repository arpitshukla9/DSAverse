public class DeleteMiddleOfLL {
    public Node deleteMiddle(Node head) {
        // TC => O(N)
        // SC => O(1)

        // If list has only one node, delete it
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow pointer to head
        Node slow = head;

        // Initialize fast pointer two steps ahead to skip slow pointer by one node or step
        Node fast = head.next.next;

        // Traverse until fast reaches end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Bypass the middle node
        slow.next = slow.next.next;

        // Return head of updated list
        return head;
    }
}
