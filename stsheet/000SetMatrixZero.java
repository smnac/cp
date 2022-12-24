/* 73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col0=false;
        int M=matrix.length;
        int N=matrix[0].length;
        for(int row=0;row<M;row++)
        {
            if(matrix[row][0]==0)
                col0=true;   //Important column 0 case don't modify corresponding row 0  
            
            for(int col=1;col<N;col++)
            {
                if(matrix[row][col]==0)
                    matrix[row][0]=matrix[0][col]=0;
                
            }
        }
        
        for(int row=M-1;row>=0;row--)
        {
            for(int col=N-1;col>=1;col--)
            {
                if(matrix[row][0]==0 || matrix[0][col]==0)
                    matrix[row][col]=0;
            }
            
            if(col0)
                matrix[row][0]=0;
        }
            
        
    }
}
