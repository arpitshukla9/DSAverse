class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = next;
    }
}

public class AddTwoNumLL {
    public static Node arr2LL(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i < arr.length; i++){
            Node curr = new Node(arr[i]);
            temp.next = curr;
            temp = curr;
       }
       return head;
    }

    public static void traversal(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static Node addNum(Node L1, Node L2){
        // \* JHA PR BHI NEW LIST BNAO HMSA DUMMY NODE KA CONCEPT YDD RKHO *\
        // TC O(N) + O(M) and SC O(N+M) for new linked list
    // Dono linked lists ko traverse karne ke liye temporary pointers
    Node temp1 = L1;
    Node temp2 = L2;

    // Dummy node banao taki head handle karna easy ho jaye
    Node dummy = new Node(-1);

    // Tail hamesha answer wali linked list ke last node pe rahega
    Node tail = dummy;

    // Addition carry store karne ke liye (0 ya 1)
    int carry = 0;

    // Jab tak kisi bhi list me node bacha hai, loop chalao
    while(temp1 != null || temp2 != null){

        // Default value 0 rakho taki agar koi list khatam ho jaye to bhi addition ho sake
        int val1 = 0;
        int val2 = 0;

        // Agar L1 me node hai to uski value lo aur pointer aage badhao
        if(temp1 != null){
            val1 = temp1.data;
            temp1 = temp1.next;
        }

        // Agar L2 me node hai to uski value lo aur pointer aage badhao
        if(temp2 != null){
            val2 = temp2.data;
            temp2 = temp2.next;
        }

        // Dono values aur carry ko add karo
        int sum = val1 + val2 + carry;

        // Carry nikaalo (10 ya usse bada hua to)
        carry = sum / 10;

        // Current digit ki node banao aur answer list me jodo
        tail.next = new Node(sum % 10);

        // Tail ko naye last node pe shift karo
        tail = tail.next;
    }

    // Agar end me carry bach gaya to uski extra node add karo
    if(carry > 0){
        tail.next = new Node(carry);
    }

    // Dummy ko skip karke actual head return karo
    return dummy.next;
}
        public static void main(String[] args) {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        Node L1 = arr2LL(arr1);
        Node L2 = arr2LL(arr2);
        // traversal(L1);
        // System.out.println("---------PARTITION------");
        // traversal(L2);
        traversal(addNum(L1, L2));

    }
}
