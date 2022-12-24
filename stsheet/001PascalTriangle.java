/*

118. Pascal's Triangle

https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30


*/

/* Imp

 Basically 3 patterns
 1. print complete triangle
 2. get value of give row and column (for this just do nCr (row-1Ccol-1))
 3. get complete nth row 
    nCr -> r terms above & r terms below (important pattern) 
    5C2 5 x 4 / 2 x 1
    4C3 4 x 3 x 2 / 3 x 2 x 1
    
    calculated value of n * (n-1) * (n-2) .... (n-k+1)
    for(int i=0;i<k;i++)
    {
     res*=(n-i);
     res/=(i+1);
    }
  */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur,prev=null;
        
        for(int i=0;i<numRows;i++)
        {
            cur=new ArrayList<>();
            for(int j=0;j<=i;j++) // 0th row will have 0 col
            {
                if(j==0 || j==i) //first col and last col is always 1 for any row
                    cur.add(1);
                else
                    cur.add(prev.get(j-1)+prev.get(j));
            }
            prev=cur;    //store it to prev and move to create next row
            res.add(cur);
        }
        
        return res;
        
    }
}
