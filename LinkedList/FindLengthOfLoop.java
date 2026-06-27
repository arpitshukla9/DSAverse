class FindLengthOfLoop {
    int findLength(Node slow, Node fast) {
        int ct = 1;
        fast = fast.next;
        while (slow != fast) {
            ct++;
            fast = fast.next;
        }
        return ct;
    }

    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return findLength(slow, fast);
            }
        }

        return 0;
    }
}