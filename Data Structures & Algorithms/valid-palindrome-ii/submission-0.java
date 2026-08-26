class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean a = true;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                a = false;
                break;
            }
            start++;
            end--;
        }

        if(a) {
            return true;
        }

        return (withoutRemoving(s.substring(start+1,end+1)) || 
            withoutRemoving(s.substring(start,end)));
    }

    private boolean withoutRemoving(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}