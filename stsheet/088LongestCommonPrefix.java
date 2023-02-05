/*

https://leetcode.com/problems/longest-common-prefix/
14. Longest Common Prefix

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int index=0;
        int n=strs.length;
        
        while(strs[0].length()>index && strs[n-1].length()>index && strs[0].charAt(index)==strs[n-1].charAt(index))
            index++;
        
        return index==0?"":strs[0].substring(0,index);
        
    }
}
