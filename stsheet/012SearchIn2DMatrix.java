/*
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = m*n-1;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            int mr=mid/n;
            int mc=mid%n;
            if(matrix[mr][mc]==target)
                return true;
            else if(matrix[mr][mc]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        
        return false;
        
    }
}

//GFG row wise and col wise sorted matrix

class GFG {
 
    /* Searches the element x in mat[][]. If the
    element is found, then prints its position
    and returns true, otherwise prints "not found"
    and returns false */
    private static void search(int[][] mat, int n, int x)
    {
 
        // set indexes for top right
        int i = 0, j = n - 1;
        // element
 
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("Element found at " + i
                                 + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }
 
        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }
    // Driver code
    public static void main(String[] args)
    {
        int mat[][] = { { 10, 20, 30, 40 },
                        { 15, 25, 35, 45 },
                        { 27, 29, 37, 48 },
                        { 32, 33, 39, 50 } };
 
        // Function call
        search(mat, 4, 29);
    }
}
