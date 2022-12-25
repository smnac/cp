/*

Find Missing And Repeating

https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N

*/

/*
  Imp:
  1. hashmap
  2. sum of n numbers and sum of square of n numbers solve two equations
  3. xor method find two numbers

*/

class Solve {
    int[] findTwoElement(int nums[], int n) {
      
      int xor = 0;
      
      for(int i=0;i<n;i++)
      xor^=nums[i];
      
      for(int i=1;i<=n;i++)
      xor^=i;
      
      int msb = xor & ~(xor-1);
      
      int x=0;
      int y=0;
      
      for(int i=0;i<n;i++)
      {
          if((msb&nums[i])!=0)
            x^=nums[i];
          else
            y^=nums[i];
      }
      
       for(int i=1;i<=n;i++)
      {
          if((msb&i)!=0)
            x^=i;
          else
            y^=i;
      }
      
      for(int i=0;i<n;i++)
       {
           if(nums[i]==x)
            return new int[]{x,y};
           
           
           if(nums[i]==y)
            return new int[]{y,x};
       }
      
      
      
      
    return new int[]{x,y};
    }
  
  
