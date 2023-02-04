/*
84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/

*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] ps = previousSmaller(heights);
        int[] ns=nextSmaller(heights);
      
        
        int maxArea=0;
        
        for(int i=0;i<n;i++)
            maxArea = Math.max(maxArea,(ns[i]-ps[i]-1)*heights[i]);
        
        return maxArea;
         
    }
    
    int[] previousSmaller(int[] heights)
    {
        int n = heights.length;
        int[] ps = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                
                if(stack.isEmpty())
                {
                    ps[i]=-1;
                }
                else
                    ps[i]=stack.peek();
            
            
            stack.push(i);
            
        }
        
        return ps;
    }
    
    int[] nextSmaller(int[] heights)
    {
        int n = heights.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
           
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                {
                    stack.pop();
                }
                
                if(stack.isEmpty())
                {
                    ns[i]=n;
                }
                else
                    ns[i]=stack.peek();
            
            
            stack.push(i);
            
        }
        
        return ns;
    }
