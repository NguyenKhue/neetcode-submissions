class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            while(!isValidChar(s.charAt(i)) && i < j) i++;
            while(!isValidChar(s.charAt(j)) && j > i) j--;

            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
        
            if(ci == cj) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z') | (c >= 'a' & c <= 'z') | (c >= '0' && c <= '9');
    }
}
