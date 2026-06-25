// // Import kar rahe hain java.util package (Yahan abhi use nahi ho raha, par future mein kaam aa sakta hai)
// public class BasicsOfLL {

//     // Node ek static inner class hai, jo ek Linked List ka ek element represent karti hai
//     public static class Node {
//         // data variable mein node ka value store hota hai
//         int data; // Yahan par node ka actual value store hota hai

//         // next variable mein next node ka reference store hota hai (pointer ki tarah)
//         Node next; // Ye next node ka address rakhta hai, linked list ko connect karta hai

//         // Constructor: Jab bhi naya Node banate hain, uska data set karte hain aur next ko null karte hain
//         public Node(int data) {
//             this.data = data; // Node ka value set kar diya
//             this.next = null; // Abhi next node nahi hai, isliye null rakha
//         }
//     }

//     public static void main(String[] args) {
//         Node First = new Node(10);
//         System.out.println(First.data);
//     }
// }




// Class Bnao => Constructor bnao data(type any) and next(type constructor) 
//  => main() method m new call to constructor store to a var =>  and do next , next , next etc for more data insertion
//  How to print ? jb tk var != null -> tb tk var.data print and var = var.next;
  
public class BasicsOfLL {
    
    public static class SinglyLL {
        int data;
        SinglyLL next;

        public SinglyLL(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        SinglyLL first = new SinglyLL(10);
        System.out.println(first.data);
        first.next = new SinglyLL(15);
        first.next.next = new SinglyLL(20);
        first.next.next.next = new SinglyLL(25);
        while(first != null) {
            System.out.println("data is : " + first.data );
            first = first.next;
        }
    }
}

