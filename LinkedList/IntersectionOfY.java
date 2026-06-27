public class IntersectionOfY {

    // ==========================================================
    // INTERSECTION OF TWO LINKED LISTS (Y SHAPE) - APPROACH 1 (HashMap)
    // TC => O(M + N)
    // SC => O(M)  // HashMap mein M elements store honge
    // ==========================================================
    public ListNode getIntersectionNode_HashMap(ListNode headA, ListNode headB) {
        
        // Edge Case:
        // Agar koi bhi list empty ho to intersection nahi hai
        if(headA == null || headB == null) return null;

        // HashMap mein pehli list ke saare nodes ke addresses store kareneg
        // Key = Node reference, Value = true
        java.util.HashMap<ListNode, Boolean> map = new java.util.HashMap<>();

        // Traversal pointer
        ListNode temp = headA;

        // Pehli list ke saare nodes ko HashMap mein store karo
        while(temp != null) {
            map.put(temp, true);
            temp = temp.next;
        }

        // Ab doosri list se traversal start karo
        temp = headB;

        // Jab tak doosri list mein nodes hain
        while(temp != null) {
            
            // Check karo ki ye node pehli list mein bhi tha ya nahi
            if(map.containsKey(temp)) {
                return temp;  // Intersection node mil gaya
            }
            
            temp = temp.next;
        }

        // Koi intersection nahi mila
        return null;
    }



    // ==========================================================
    // INTERSECTION OF TWO LINKED LISTS (Y SHAPE) - APPROACH 2 (Two Pointers - Same Level)
    // TC => O(M + N)
    // SC => O(1)  // Extra space nahi use ho raha
    // 
    // KEY TRICK: Do pointers ko tabhi cycle mein bandh sakta ho 
    //            jab dono same length ke ho
    //            So pehle dono ko same level pe lao
    // ==========================================================
    public ListNode getIntersectionNode_SameLevel(ListNode headA, ListNode headB) {
        
        // Edge Case:
        // Agar koi bhi list empty ho to intersection nahi hai
        if(headA == null || headB == null) return null;

        // Pehli list ki length nikalo
        int lenA = 0;
        ListNode tempA = headA;
        while(tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        // Doosri list ki length nikalo
        int lenB = 0;
        ListNode tempB = headB;
        while(tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        // Ab dono pointers ko usi position se start kareneg 
        // jahan se dono ka distance end tak same ho
        tempA = headA;
        tempB = headB;

        // Agar pehli list zyada lambi hai to usse ek pair steps aage le jao
        if(lenA > lenB) {
            for(int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        }
        // Agar doosri list zyada lambi hai to usse ek pair steps aage le jao
        else if(lenB > lenA) {
            for(int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }

        // Ab dono same level pe hain, ab dono ko ek sath aage badhao
        // Jab same node mil jaye wahi intersection hai
        while(tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        // tempA aur tempB ab same node par hain (ya dono null hain)
        return tempA;
    }



    // ==========================================================
    // INTERSECTION OF TWO LINKED LISTS (Y SHAPE) - APPROACH 3 (OPTIMAL - Clever Trick)
    // TC => O(M + N)
    // SC => O(1)  // Extra space nahi use ho raha
    //
    // KEY TRICK: Dono pointers ko jab ek list khatam ho jaaye 
    //            tab doosri list ke start se start karo
    //            They will meet at intersection point!
    //            Kyun? Kyuki dono same total distance travel kareneg
    // 
    // Example:
    // List A: 4 -> 1 -> 8 -> 4 -> 5
    //                  ^ intersection
    // List B:      5 -> 0 -> 1 -> 8 -> 4 -> 5
    //                         ^ intersection
    //
    // pointerA: 4 -> 1 -> 8 -> 4 -> 5 (khatam) -> 5 -> 0 -> 1 -> 8 -> 4 -> 5 (stop)
    // pointerB: 5 -> 0 -> 1 -> 8 -> 4 -> 5 (khatam) -> 4 -> 1 -> 8 -> 4 -> 5 (stop)
    // Dono ko same total nodes traverse karne padenge, tab intersection par milenge
    // ==========================================================
    public ListNode getIntersectionNode_Optimal(ListNode headA, ListNode headB) {
        
        // Edge Case:
        // Agar koi bhi list empty ho to intersection nahi hai
        if(headA == null || headB == null) return null;

        // Do pointers se start karo
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Jab tak dono same node par nahi pahunch jate (ya null nahi hote)
        while(pointerA != pointerB) {
            
            // PointerA: Agar list khatam ho gyi to doosri list se start karo
            // Otherwise agle node par jao
            pointerA = (pointerA == null) ? headB : pointerA.next;

            // PointerB: Agar list khatam ho gyi to pehli list se start karo
            // Otherwise agle node par jao
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // pointerA aur pointerB ab intersection node par hain (ya dono null hain)
        return pointerA;
    }

    
    // HELPER CLASS (LeetCode format ke liye)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

