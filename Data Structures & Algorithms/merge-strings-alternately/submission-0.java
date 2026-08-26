class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res =  new StringBuilder();
        int left = 0;
        int right = 0;
        int n = Math.min(word1.length(),word2.length());
        while(n != 0) {
            res.append(word1.charAt(left++));
            res.append(word2.charAt(right++));
            n--;
        }

        while(left < word1.length()) {
            res.append(word1.charAt(left++));
        }
        
        while(right < word2.length()) {
            res.append(word2.charAt(right++));
        }

        return res.toString();
    }
}