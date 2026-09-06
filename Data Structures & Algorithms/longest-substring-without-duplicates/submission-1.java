class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        while(i < s.length()) {
            if(set.add(s.charAt(i))) {
                i++;
            }
            else {
                set.remove(s.charAt(i - set.size()));
            }
            max_length = Math.max(max_length,set.size());
        }
        return max_length;
    }
}
