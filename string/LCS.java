/*
583. Delete Operation for Two Strings

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.

*/


class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
         dp = new int[word1.length()][word2.length()];
        int res = lcs(word1,word2,0,0);   
        return word1.length() + word2.length() - 2*res;
    }
    
    int lcs(String word1, String word2,int i,int j)
    {
        if(i==word1.length() || j==word2.length())
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))
            return dp[i][j]=1+lcs(word1,word2,i+1,j+1);
        
         return dp[i][j]=Math.max(lcs(word1,word2,i,j+1),lcs(word1,word2,i+1,j));
        
    }
}
