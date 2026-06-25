// -------GENERIC CLASS---------------
// class Node<T> {
//     T data;
//     Node<T> next;

//     Node(T data){
//         this.data = data;
//         this.next = null;
//     }
// }

// ---------SPECIFIC int DATATYPE----------
class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
};

public class SinglyLL {
    private static Node convertArrayToLL(int[] arr){
        // arr[0] se start krege and head ko fix kr dege
        Node head = new Node(arr[0]);
        // mover traverse krega head se tail tk
        Node mover = head;
        // i = 1 coz for 0 already ho chuka
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            // temp m next ka head
            mover.next = temp;
            // mover ko current idx pr le aao
            mover = temp;
        }
        return head;
    }

    static int traverse(Node head) {
        // taaki kbhi bhi head ka address na bhoole ki start kha se hora h
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        return 0;
    }

    static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    static int checkifPresent(Node head, int val){
        Node temp = head;
        while(temp != null) {
            if(temp.data == val) return val;
            temp = temp.next;
        }
        return -1;
    }
    
    // ------------------DELETION------------------
    static Node removeHead(Node head){
        // edge-case for each ques
        if(head == null) return head;
        Node temp = head;
        head = head.next; 
        return head;
    }

    static Node removeTail(Node head){
        // edge-case for each ques
        if(head == null || head.next == null ) return null;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    
    static Node removeKthValue(Node head, int k){
        // Prev islye banaya h kyoki humko prev.next = prev.next.next krna h
        
        if(head == null ) return null;
         Node temp = head;
         Node prev = null;
         int count = 0;
         while(temp != null) {
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
         }
         return head;
    }
    
    static Node RemoveByValue(Node head, int val){
        if (head == null) return null;

        if (head.data == val) return head.next;

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    // ------------------INSERTION------------------
    static Node insertAtHead(Node head, int val){
        Node temp = new Node(val);
        temp.next = head;
        return temp;
    }
    static Node insertAtTail(Node head, int val){
        Node temp = new Node(val);
        if(head == null) return temp;
        Node mover = head;
        while(mover.next != null) {
            mover = mover.next;
        }
        mover.next = temp;
        return head;
    }
    static Node insertAtKthPosition(Node head, int val, int k){
        Node temp = new Node(val);
        if(k == 1) {
            temp.next = head;
            return temp;
        }
        Node mover = head;
        int count = 1;
        while(mover != null && count < k-1) {
            mover = mover.next;
            count++;
        }
        if(mover == null) return head; // k is greater than the length of the list
        temp.next = mover.next;
        mover.next = temp;
        return head;
    }
    static Node insertBeforeValue(Node head, int val, int target){
        Node temp = new Node(val);
        if(head == null) return temp;
        if(head.data == target) {
            temp.next = head;
            return temp;
        }
        Node mover = head;
        while(mover.next != null && mover.next.data != target) {
            mover = mover.next;
        }
        if(mover.next == null) return head; // target not found
        temp.next = mover.next;
        mover.next = temp;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};   
        Node head = convertArrayToLL(arr);
        // // traverse 
        // traverse(head);
        // // Length Call
        // System.out.println("LinkedList ki LENGTH H :" + lengthOfLL(head));

        // // checkIfPresent ki Call
        // System.out.println("Val dkhte h hai ki nh" + ":" + checkifPresent(head, 5));
        // System.out.println("Val dkhte h hai ki nh" + ":" + checkifPresent(head, 50));

        // // Deletion Of head
        // System.out.println("BEFORE REMOVING HEAD : " + head.data);
        // System.out.println("AFTER REMOVING HEAD :" + removeHead(head));
        // Node newHead = removeHead(head);
        // traverse(newHead);
        // Deletion of Tail
        // Node newTail = removeTail(head);
        // traverse(newTail);

        // Deletion of any Node
        // Node removeAnyNode = removeKthValue(head, 2);
        // traverse(head);
        
        // Deletion of any Node by Value
        // Node removeAnyNodeByVal = RemoveByValue(head, 2);
        // traverse(head);
        
        // Insertion at head
        // Node insertAtHead = insertAtHead(head, 0);
        // traverse(insertAtHead);
        
        // Insertion at tail
        // Node insertAtTail = insertAtTail(head, 6);
        // traverse(insertAtTail);

        // Insertion at Kth position
        // Node insertAtKth = insertAtKthPosition(head, 7, 3);
        // traverse(insertAtKth);

        // Insertion Before Value
        Node insertBeforeValue = insertBeforeValue(head, 6, 5);
        traverse(insertBeforeValue);
    }
}
