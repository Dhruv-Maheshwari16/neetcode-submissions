class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Use 128 to cover all ASCII characters (both 'a'-'z' and 'A'-'Z')
        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];

        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        
        // Tracks how many useful characters from 't' we currently have in our window
        int count = 0; 

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq[rightChar]++;

            // If this is a character we need, and we haven't over-collected it yet
            if (tFreq[rightChar] > 0 && windowFreq[rightChar] <= tFreq[rightChar]) {
                count++;
            }

            // Once our window contains all characters required from 't'
            while (count == t.length()) {
                
                // 1. Record the current window if it's the smallest so far
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                }

                // 2. Try to shrink the window from the left
                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;

                // If we remove a character that we actually needed, decrease the valid count
                if (tFreq[leftChar] > 0 && windowFreq[leftChar] < tFreq[leftChar]) {
                    count--;
                }
                
                left++; // Shrink the window
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}