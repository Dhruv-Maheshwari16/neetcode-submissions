class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class MyHashSet {

    Node[] arr = new Node[10];

    public MyHashSet() {
        for(int i = 0; i < 10;i++) {
            arr[i] = new Node(-1);
        }
    }
    
    public void add(int key) {
        int hashKey = key%10;
        Node temp = arr[hashKey];
        while(temp.next != null) {
            if(temp.next.data == key) {
                return ;
            }
            temp = temp.next;
        }
        temp.next = new Node(key);
    }
    
    public void remove(int key) {
        int hashKey = key%10;
        Node temp = arr[hashKey];
        while(temp.next != null) {
            if(temp.next.data == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) {
        int hashKey = key%10;
        Node temp = arr[hashKey];
        while(temp != null) {
            if(temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */