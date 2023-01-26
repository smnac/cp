/*
https://leetcode.com/problems/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


*/

class Solution {
    public int trap(int[] height) {
        int N=height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        
        left[0]=height[0];
        for(int i=1;i<N;i++)
            left[i]=Math.max(height[i],left[i-1]);
        
        
        right[N-1]=height[N-1];
        for(int i=N-2;i>=0;i--)
            right[i]=Math.max(height[i],right[i+1]);
        int trap=0;
        int total=0;
        for(int i=0;i<N;i++){
            trap=Math.min(left[i],right[i]) - height[i];
            if(trap>0)
                total+=trap;
        }
        
        
        return total;
    }
}
