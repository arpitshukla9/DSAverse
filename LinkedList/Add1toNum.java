
// ITERATIVE + RECURSIVE (dono se kar sakte hai)
// YE RECURSIVE MEIN HAI
class Add1toNum {
    int addHelper(Node temp){
        if(temp == null) return 1;
        int carry = addHelper(temp.next);
        temp.data  += carry;
        if(temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }
    public Node addOne(Node head) {
        int carry = addHelper(head);
        if(carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}