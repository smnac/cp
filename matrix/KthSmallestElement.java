/*

378. Kth Smallest Element in a Sorted Matrix

https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
*/


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low = matrix[0][0];
        int high=matrix[n-1][n-1];
        
        while(low<high)
        {
            int mid = low + (high-low)/2;
            
            if(searchMidCount(matrix,mid)<k)
                low=mid+1;
            else
                high=mid;
        }
        
        return low; // return low or high
        
    }
    
    private int searchMidCount(int[][] matrix,int key)
    {
        int n=matrix.length;
        int i = 0;
        int j=n-1;
        int count=0;
        while(i<n && j>=0)
        {
            if(matrix[i][j]<=key)
            {
                i++;
                count+=j+1;  //for every row add column num of elements
            }
            else
                j--;
        }
        return count; //return count of elements <= mid
    }
}

