/*

139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/

// Recursion

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,new HashSet<>(wordDict),0);
    }
    
    private boolean helper(String s,Set<String> wordDict,int start)
    {
        if(start==s.length())
            return true;   // reached already end and hence found all the word in dict
        
        for(int end=start+1;end<=s.length();end++)
        {
            if(wordDict.contains(s.substring(start,end)) && helper(s,wordDict,end))
                return true;
        }
        
        return false;
    }
}

//DP




class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return helper(s,new HashSet<>(wordDict),0,dp);
    }
    
    private boolean helper(String s,Set<String> wordDict,int start,Boolean[] dp)
    {
        if(start==s.length())
            return true;   // reached already end and hence found all the word in dict
        
        if(dp[start]!=null)
            return dp[start];
        
        for(int end=start+1;end<=s.length();end++)
        {
            if(wordDict.contains(s.substring(start,end)) && helper(s,wordDict,end,dp))
                return dp[start]=true;
        }
        
        return dp[start]=false;
    }
}






