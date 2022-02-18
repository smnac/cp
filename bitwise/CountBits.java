package cp.bitwise;
/*
   Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

   Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
*/


public class CountBits {

 /*   int count=0;
    while(n>0){
    n &= n - 1; //in every iteration it removes set bit 
    count++;    // count till it removes all the set bit => gives total set bits
    } 
*/

    //DP solution

    public int[] countBits(int n) {
        int[] dp =new int[n+1];
        for(int i=1;i<=n;i++)
            dp[i]=dp[i>>1] + (i&1); //number = number/2 + check and add last bit
        return dp;
        
    }
    
}
