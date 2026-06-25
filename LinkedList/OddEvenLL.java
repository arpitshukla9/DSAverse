
// 5-second revision trick 🧠

// O E S → O E → Join

// Odd pointer (t1)
// Even pointer (t2)
// Save even head
// Odd ko odd se jodo
// Even ko even se jodo
// End me join
class OddEvenLL {
    // TC => O(N/2) + O(N/2) + O(1) = O(N) similar to Two While Loop but slightly better than two while loop
    // SC => O(1)
    public ListNode oddEvenList(ListNode head) {

        // Agar list empty hai ya sirf 1 node hai to direct return
        if(head == null || head.next == null) return head;

        // t1 odd position wale nodes ko traverse karega
        ListNode t1 = head;

        // t2 even position wale nodes ko traverse karega
        ListNode t2 = head.next;

        // Even list ka head save kar lo, end me attach karna hai
        ListNode evenHead = t2;

        // Jab tak even pointer aur uska next exist karta hai, rearrange karte raho
        while(t2 != null && t2.next != null) {

            // Current odd node ko next odd node se connect karo
            t1.next = t2.next;

            // Odd pointer ko aage badhao
            t1 = t1.next;

            // Current even node ko next even node se connect karo
            t2.next = t1.next;

            // Even pointer ko aage badhao
            t2 = t2.next;
        }

        // Odd list ke end me poori even list attach kar do
        t1.next = evenHead;

        // Original head hi answer ka head rahega
        return head;
    }
}