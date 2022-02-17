package cp.dp;

/*

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999


*/

class minCostStairsClaim {
    /*  
    //Bottom-Up approach
    public int minCostClimbingStairs(int[] cost) {
          int N=cost.length;
          int[] dp = new int [N+1];
              dp[0]=0;
              dp[1]=0;
          for(int i=2;i<=N;i++)
              dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
          
          return dp[N];
          
      }*/
      
      //Top-Down approach
      int[] dp;
       public int minCostClimbingStairs(int[] cost) {
           dp=new int[cost.length+1];
          return minCost(cost,cost.length);
           
          
      }
      
      
      int minCost(int[] cost,int step)
      {
          if(step==0 || step==1)
              return 0; //cost to reach stair 1 or 2 is zero
          
          if(dp[step]>0)
              return dp[step];
           dp[step]=Math.min(cost[step-1]+minCost(cost,step-1),cost[step-2]+minCost(cost,step-2));
          return dp[step];
      }
}