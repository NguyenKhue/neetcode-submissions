class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            countS.put(si, countS.getOrDefault(si, 0) + 1);

            char ti = t.charAt(i);
            countT.put(ti, countT.getOrDefault(ti, 0) + 1);
        }

        return countS.equals(countT);
    }
}
