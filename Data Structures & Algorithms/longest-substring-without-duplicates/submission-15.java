class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int l = 0, r = 0;
        var set = new HashMap<Character, Integer>();
        int longest = 0;

        while(r < s.length()) {
            var c = s.charAt(r);

            if(!set.containsKey(c)) {
                set.put(c, r);
                r++;
            } else {
                longest  = Math.max(longest, r - l);
                System.out.println(l + "->" + c);
                l=set.get(c) + 1;
                r = l + 1;
                set.clear();
                set.put(s.charAt(l), l);
            }
        }

        System.out.println(r + ":" + l);
        longest = Math.max(longest, r - l);

        return longest;
    }
}
