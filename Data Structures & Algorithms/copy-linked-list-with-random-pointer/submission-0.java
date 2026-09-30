/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        Map<Node, Node> oldToCopy=new HashMap<>();

        while(temp!=null){
            Node copy=new Node(temp.val);
            oldToCopy.put(temp, copy);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            Node copy=oldToCopy.getOrDefault(temp, null);
            copy.next=oldToCopy.getOrDefault(temp.next, null);
            copy.random=oldToCopy.getOrDefault(temp.random, null);

            temp=temp.next;
        }


        return oldToCopy.get(head);
    }
}
