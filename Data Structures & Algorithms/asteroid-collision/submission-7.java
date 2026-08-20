class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = asteroids.length;
        int k = 0;
        while (k < n) {
            if(stack.isEmpty()) {
                stack.push(asteroids[k]);
                k++;
                continue;
            }

            int temp = stack.pop();

            if(temp <= 0) {
                stack.push(temp);
                stack.push(asteroids[k]);
                k++;
            } else {
                if(asteroids[k] >= 0) {
                    stack.push(temp);
                    stack.push(asteroids[k]);
                    k++;
                }
                else {
                    int diff = temp + asteroids[k];
                    if(diff == 0) {
                        k++;
                        continue;
                    }
                    else if(diff > 0) {
                        stack.push(temp);
                        k++;
                    }
                    else {
                        continue;
                    }
                }
            }
        }

        int[] result_temp = new int[n];
        int count = 0;

        while(!stack.isEmpty()) {
            result_temp[count++] = stack.pop();
        }

        int[] result = new int[count];

        for(int i = count - 1; i >= 0; i--) {
            result[i] = result_temp[count - i - 1];
        }

        return result;
    }
}