/*
474. Ones and Zeroes

You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.


*/



class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];
        return findSubset(strs,m,n,0,dp);
        
    }
    
    public int findSubset(String[] strs,int m,int n,int index,int[][][] dp)
    {
        if(index==strs.length || m+n==0)
            return 0;
        
        if(dp[m][n][index]>0)
            return dp[m][n][index];
        
        int[] count = getCountOfZeroOne(strs[index]);
        
        int left=0,right=0;
        if(m>=count[0] && n>=count[1])
            left=1+findSubset(strs,m-count[0],n-count[1],index+1,dp); //consider
        right=findSubset(strs,m,n,index+1,dp);  //not consider
        
        return dp[m][n][index]=Math.max(right,left);
            
    }
    
    int[] getCountOfZeroOne(String input)
    {
        int[] res = new int[2];
        
        for(char c:input.toCharArray())
            res[c-'0']++;
        
        return res;
    }
}
