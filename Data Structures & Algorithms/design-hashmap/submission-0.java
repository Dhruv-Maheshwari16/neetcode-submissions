class Node {
    int key;
    int val;
    Node next;

    public Node(int key,int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}


class MyHashMap {

    Node[] arr = new Node[10];

    public MyHashMap() {
        for(int i = 0; i < 10;i++) {
            arr[i] = new Node(-1,-1);
        }
    }

    private int hashfunction(int key) {
        return key%10;
    }
    
    public void put(int key, int value) {
        Node temp = arr[hashfunction(key)];
        while(temp.next != null) {
            if(temp.next.key == key) {
                temp.next.val = value;
                return;
            }
            temp = temp.next;
        }
        temp.next = new Node(key,value);
    }
    
    public int get(int key) {
        Node temp = arr[hashfunction(key)].next;
        while(temp != null) {
            if(temp.key == key) {
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node temp = arr[hashfunction(key)];
        while(temp.next != null) {
            if(temp.next.key == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */