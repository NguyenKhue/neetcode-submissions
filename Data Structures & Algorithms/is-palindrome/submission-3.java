class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            while(!isValidChar(s.charAt(i)) && i < j) i++;
            while(!isValidChar(s.charAt(j)) && j > i) j--;

            char ci = s.charAt(i);
            char lci = Character.toLowerCase(ci);
            char cj = s.charAt(j);
            char lcj = Character.toLowerCase(cj);
            
            if(lci == lcj) {
                i++;
                j--;
            } else {
                System.out.println(ci + ":" + cj + isValidChar('?'));
                return false;
            }
        }

        return true;
    }

    public boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z') | (c >= 'a' & c <= 'z') | (c >= '0' && c <= '9');
    }
}
