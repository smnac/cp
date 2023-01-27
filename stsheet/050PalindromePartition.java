/*
https://leetcode.com/problems/palindrome-partitioning/
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(s,0,ans,res);
        return res;
    }
    
    private void helper(String s,int index,List<String> ans, List<List<String>> res)
    {
        if(index==s.length())
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=index;i<s.length();i++)
        {
            if(checkPalindrome(s,index,i))
            {
                ans.add(s.substring(index,i+1));
                helper(s,i+1,ans,res);
                ans.remove(ans.size()-1);
            }
        }
    }
    
    private boolean checkPalindrome(String s,int start,int end)
    {
        
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
