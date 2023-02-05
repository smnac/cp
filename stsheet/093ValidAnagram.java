/*
https://leetcode.com/problems/valid-anagram/
242. Valid Anagram

*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sa = new int[26];
        for(int i=0;i<s.length();i++){
            sa[s.charAt(i)-'a']++;
        }
        
        for(int j=0;j<t.length();j++){
            sa[t.charAt(j)-'a']--;
        }
        
        for(int count:sa){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}
