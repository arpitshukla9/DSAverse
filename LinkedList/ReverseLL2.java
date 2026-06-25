public class ReverseLL2 {

    ListNode reverseBetween(ListNode head, int left, int right) {

        // ==========================================================
        // REVERSE LINKED LIST II (Reverse Between)
        // TC => O(N)
        // SC => O(1)
        // ==========================================================

        // Dummy node banao taki agar left = 1 ho tab bhi easily handle ho jaye
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // left se ek node pehle tak pahunchne ke liye
        ListNode leftPre = dummy;

        // Reverse start hone wali node
        ListNode currNode = head;

        // left position tak jao
        for (int i = 0; i < left - 1; i++) {

            leftPre = leftPre.next;

            currNode = currNode.next;
        }

        // Reverse hone wale part ka first node
        // Reverse ke baad ye tail ban jayega
        ListNode subListHead = currNode;

        // Normal Reverse Linked List Logic
        ListNode preNode = null;

        // Sirf (left...right) part reverse karo
        for (int i = 0; i <= right - left; i++) {

            // Next node save karo
            ListNode nextNode = currNode.next;

            // Link reverse karo
            currNode.next = preNode;

            // Prev ko aage badhao
            preNode = currNode;

            // Current ko aage badhao
            currNode = nextNode;
        }

        // -----------------------------
        // Reconnect the broken pieces
        // -----------------------------

        // Left part ko reversed head se jodo
        leftPre.next = preNode;

        // Reversed tail ko remaining list se jodo
        subListHead.next = currNode;

        // Actual head return karo
        return dummy.next;
    }
}