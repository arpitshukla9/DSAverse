class SortLLOf0s1s2s {
    // TC O(N) and SC O(1) 
    public Node segregate(Node head) {

        // Empty ya single node list ko direct return karo
        if(head == null || head.next == null) return head;

        // Original list traverse karne ke liye pointer
        Node res = head;

        // 0 list ka dummy head
        Node zeroHead = new Node(-1);

        // 0 list ka tail
        Node Zero = zeroHead;

        // 1 list ka dummy head
        Node oneHead = new Node(-1);

        // 1 list ka tail
        Node One = oneHead;

        // 2 list ka dummy head
        Node twoHead = new Node(-1);

        // 2 list ka tail
        Node two = twoHead;


        // Original list traverse karo
        while(res != null){

            // 0 mila to 0 list me daalo
            if(res.data == 0){

                zeroHead.next = res;

                zeroHead = zeroHead.next;
            }

            // 1 mila to 1 list me daalo
            else if(res.data == 1){

                oneHead.next = res;

                oneHead = oneHead.next;
            }

            // 2 mila to 2 list me daalo
            else{

                twoHead.next = res;

                twoHead = twoHead.next;
            }

            // Original list me aage badho
            res = res.next;
        }


        // Agar 1-list empty hai to 0 ko direct 2 se jodo
        zeroHead.next = (One.next != null)
                        ? One.next
                        : two.next;

        

        // Actual head return karo
        return (Zero.next != null)
                ? Zero.next
                : (One.next != null)
                    ? One.next
                    : two.next;
    }
}