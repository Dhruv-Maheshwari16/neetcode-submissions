class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String s : arr) {
            if(!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            }
            else if(s.equals(".") || s.equals("") || s.equals("..")) {
                continue;
            }
            else {
                stack.push(s);
            }
        }

        StringBuilder s = new StringBuilder();

        if(stack.isEmpty()) {
            return "/";
        }

        while(!stack.isEmpty()) {
            StringBuilder temp = new StringBuilder();
            temp.insert(0,stack.pop());
            temp.insert(0,"/");
            s.insert(0,temp);
        }

        return s.toString();
    }
}