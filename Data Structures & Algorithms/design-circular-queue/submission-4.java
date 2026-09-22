class MyCircularQueue {

    int length;
    int count = 0;

    Node front;
    Node rear;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public MyCircularQueue(int k) {
        length = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(isEmpty()) {
            front = new Node(value);
            rear = front;
            count++;
            return true;
        }
        count++;
        rear.next = new Node(value);
        rear = rear.next;
        return true;  
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = front.next;
        rear.next = null;
        count--;

        return true;
    }
    
    public int Front() {
        if(front != null) {
            return front.val;
        }
        return -1;
    }
    
    public int Rear() {
        if(front != null) {
            return rear.val;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */