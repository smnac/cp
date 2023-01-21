/*
https://practice.geeksforgeeks.org/problems/power-set4302/1#
Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

Example 1:

Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 subsequences that 
can be formed from abc.
Example 2:

Input: str = "aa"
Output: a a aa
Explanation : There are 3 subsequences that 
can be formed from aa.

*/

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        int n =s.length();
        List<String> res = new ArrayList<>();
        for(int i=0;i<(1<<n);i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++)
            {
                if((i&(1<<j))>0)
                sb.append(s.charAt(j));
            }
            if(!sb.toString().isEmpty())
            res.add(new String(sb.toString()));
        }
        
        Collections.sort(res);
        return res;
    }
}
