class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }

        int[] characters = new int[26];
        for(int i=0; i < s.length();i++) {
            int charAsciiVal = s.charAt(i);
            if(charAsciiVal < 97 || charAsciiVal>122) {
                return false;
            }
            characters[charAsciiVal-97]++;
        }    

        for(int i=0; i < t.length();i++) {
            int charAsciiVal = t.charAt(i);
            if(charAsciiVal < 97 || charAsciiVal>122) {
                return false;
            }
            characters[charAsciiVal-97]--;
        }    

        for(int i=0; i < characters.length;i++) {
            if(characters[i] != 0) {
                return false;
            }
        }    
        return true;
    }
}
