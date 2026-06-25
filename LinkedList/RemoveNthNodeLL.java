class RemoveNthNodeLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Empty list
        if(head == null) return null;

        // Total length nikalne ke liye temp pointer
        int len = 0;
        ListNode temp = head;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        // Invalid n handle karo
        if(n <= 0 || n > len) return head;

        // Start se kitne steps jana hai
        int res = len - n;

        // Agar head hi remove karni hai
        if(res == 0) return head.next;

        int count = 0;
        ListNode itr = head;

        // Previous node tak traverse karo
        while(itr != null){

            count++;

            if(count == res){

                // Target node skip karo
                itr.next = itr.next.next;

                break;
            }

            itr = itr.next;
        }

        return head;
    }

    // OPTIMAL APPROACH - SLow and FAST POINTER APPROACH
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node banao taki head deletion bhi easily handle ho jaye
        ListNode dummy = new ListNode(-1);

        // Dummy ko original head se connect karo
        dummy.next = head;

        // Slow aur fast dono dummy se start honge
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Fast ko n+1 steps aage bhejo
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        // Jab tak fast end tak na pahunch jaye
        while(fast != null){

            // Dono pointers ko saath move karo
            slow = slow.next;
            fast = fast.next;
        }

        // Slow target node ke previous node pe hoga
        // Target node ko skip kar do
        slow.next = slow.next.next;

        // Actual head return karo
        return dummy.next;
    }
}