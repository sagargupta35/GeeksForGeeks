class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node ins = new Node(data);
        if(head == null){
            ins.next = ins;
            return ins;
        }
        Node temp = head;
        if(head.data >= data){
            while (temp.next != head) temp = temp.next;
            ins.next = head;
            temp.next = ins;
            return ins;
        }
        while (temp.next.data < data && temp.next != head) temp = temp.next;
        ins.next = temp.next;
        temp.next = ins;
        return head;
    }
}
