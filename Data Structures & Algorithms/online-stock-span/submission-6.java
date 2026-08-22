class StockSpanner {

    Deque<int[]> stack;
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = 0;
    }
    
    public int next(int price) {
        int res;
        while(!stack.isEmpty() && price >= stack.peek()[0]) {
            stack.pop();
        }
        if(!stack.isEmpty()) {
            res = index - stack.peek()[1];
        }
        else {
            res = index + 1;
        }
        stack.push(new int[]{price,index++});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */