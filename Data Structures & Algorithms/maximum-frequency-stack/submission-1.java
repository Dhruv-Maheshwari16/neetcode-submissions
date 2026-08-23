class FreqStack {

    Deque<int[]> stack;
    Map<Integer,Integer> map;

    public FreqStack() {
        stack = new ArrayDeque<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        int[] temp = new int[2];
        map.put(val,map.getOrDefault(val,0)+1);
        temp[0] = val;
        temp[1] = map.get(val);
        if(stack.isEmpty()) {
            stack.push(new int[]{temp[0],temp[1]});
            return;
        }
        Deque<int[]> temp_stack = new ArrayDeque<>();
        while(!stack.isEmpty() && temp[1] < stack.peek()[1]) {
            int[] p = new int[2];
            p = stack.pop();
            temp_stack.push(new int[]{p[0],p[1]});
        }
        stack.push(new int[]{temp[0],temp[1]});
        while(!temp_stack.isEmpty()) {
            int[] p = new int[2];
            p = temp_stack.pop();
            stack.push(new int[]{p[0],p[1]});
        }
    }
    
    public int pop() {
        int temp = stack.pop()[0];
        map.put(temp,map.get(temp) - 1);
        return temp;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */