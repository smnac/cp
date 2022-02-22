package cp.matrix;


/*

Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


*/

import java.util.ArrayList;
import java.util.List;

class SpiralPrint {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        List<Integer> ans=new ArrayList<>();
        while(true)
        {
            for(int i=left;i<=right;i++)
                ans.add(matrix[top][i]);
              top++;
            if(top > bottom)
                break;
            
            for(int i=top;i<=bottom;i++)
                ans.add(matrix[i][right]);
              right--;
            if(left>right)
                break;
            
            for(int i=right;i>=left;i--)
                ans.add(matrix[bottom][i]);
              bottom--;
            if(top > bottom)
                break;
            
            for(int i=bottom;i>=top;i--)
                ans.add(matrix[i][left]);
              left++;
            if(left>right)
                break;
            
            
        }
        return ans;
    }
}