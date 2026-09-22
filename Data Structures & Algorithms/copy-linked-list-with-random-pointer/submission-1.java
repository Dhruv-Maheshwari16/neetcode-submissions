class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map1 = new HashMap<>();

        Node new_head = new Node(head.val);
        Node curr = new_head;
        Node temp = head.next;

        map1.put(head, new_head);

        while (temp != null) {
            Node new_temp = new Node(temp.val);

            curr.next = new_temp;

            map1.put(temp, new_temp);

            curr = new_temp;
            temp = temp.next;
        }

        Node temp1 = head;
        Node temp2 = new_head;

        while (temp1 != null) {

            if (temp1.random == null) {
                temp2.random = null;
            }
            else {
                temp2.random = map1.get(temp1.random);
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return new_head;
    }
}