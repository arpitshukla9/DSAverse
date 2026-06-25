import java.util.Stack;

class ReverseLL {

    // ==========================================================
    // REVERSE LINKED LIST - APPROACH 1 (Optimal - 3 Pointer)
    // TC => O(N)
    // SC => O(1)
    // ==========================================================
    public ListNode reverseListOptimal(ListNode head) {

        // Edge Case:
        // Empty list ya sirf 1 node ho to wahi answer hai
        if(head == null || head.next == null) return head;

        // Previous node (Initially null kyuki first node last banegi)
        ListNode prev = null;

        // Current node
        ListNode curr = head;

        // Current ke next node ko temporarily store karega
        ListNode front = null;

        // Jab tak current khatam na ho
        while(curr != null){

            // Next node save kar lo warna link toot jayega
            front = curr.next;

            // Link reverse karo
            curr.next = prev;

            // Prev ko current pe le aao
            prev = curr;

            // Current ko next node pe move karo
            curr = front;
        }

        // Reverse list ka naya head prev hoga
        return prev;
    }



    // ==========================================================
    // REVERSE LINKED LIST - APPROACH 2 (Stack)
    // TC => O(N)
    // SC => O(N)
    // ==========================================================
    public ListNode reverseListStack(ListNode head){

        // Edge Case:
        // Empty list ya sirf 1 node ho to wahi answer hai
        if(head == null || head.next == null) return head;

        // Values store karne ke liye stack
        Stack<Integer> st = new Stack<>();

        // Traversal pointer
        ListNode temp = head;

        // Saari values stack me push karo
        while(temp != null){

            st.push(temp.val);

            temp = temp.next;
        }

        // Dubara head se traversal start karo
        temp = head;

        // Stack se values pop karke overwrite karo
        while(temp != null){

            temp.val = st.pop();

            temp = temp.next;
        }

        // Updated linked list return karo
        return head;
    }



    // ==========================================================
    // REVERSE LINKED LIST - APPROACH 3 (Recursion)
    // TC => O(N)
    // SC => O(N)  // Recursive Call Stack
    // ==========================================================
    public ListNode reverseListRecursion(ListNode head){

        // Base Case:
        // Empty list ya last node mil gayi
        // Wahi reverse list ka new head banega
        if(head == null || head.next == null) return head;

        // Chhoti linked list ko reverse karo
        ListNode newHead = reverseListRecursion(head.next);

        // Current node ka next store karo
        ListNode front = head.next;

        // Reverse link banao
        front.next = head;

        // Current node ko last bana do
        head.next = null;

        // Har recursive call me same new head return hoga
        return newHead;
    }
}