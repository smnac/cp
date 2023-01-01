/*
1. Matrix Chain Multiplication
*/



public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++)
            Arrays.fill(dp[i],-1);
        return helper(arr,1,N-1,dp);  // imp, starting from index one 
	}
    
    private static int helper(int[] arr,int i,int j,int[][] dp)
    {
        
        if(i==j)
            return 0; // single matrix no multiplication cost
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int steps = arr[i-1]*arr[k]*arr[j]+helper(arr,i,k,dp)+helper(arr,k+1,j,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=min;
    }
}

//Tabulation

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int i=N-1;i>=1;i--)
        {
            for(int j=i+1;j<N;j++). //imp, i+1 to N
            {
               int min = Integer.MAX_VALUE;
               for(int k=i;k<j;k++)
                {
                int steps = arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
            min=Math.min(min,steps);
                }
                 dp[i][j]=min; 
            }
        }
         return dp[1][N-1]; //check the return of helper
	}
