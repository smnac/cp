package cp.recursion;

public class ClimbingStairs {
   
        int[] dp;
        public int climbStairs(int n) {
            
            dp = new int[n+1];
            return helper(n);
            
        }
        
        public int helper(int n)
        {
            if(n==0)
                return 1;
            if(n<0)
                return 0;
            if(dp[n]>0)
                return dp[n];
            
            dp[n]=helper(n-1)+helper(n-2);
            return dp[n];
        }
    }

