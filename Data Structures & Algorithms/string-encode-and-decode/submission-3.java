class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder("");
        for(String s : strs) {
            res.append("#");
            res.append(s.length());
            res.append("#");
            res.append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int count = 0;
        while(i < str.length()) {
            if(str.charAt(i++) == '#') {
                String temp = "";
                while(str.charAt(i) != '#') {
                    temp += str.charAt(i++);
                }
                count = Integer.parseInt(temp);
                i++;
                res.add(str.substring(i,i + count));
                i = i + count;
            }
        }
        return res;
    }
}
