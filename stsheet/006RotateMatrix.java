class Solution {
    public void rotate(int[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<n;j++)
            {
               int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                
            }
            
            
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length/2;j++)
            {
               int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
                
            }
            
            
        }
        
    }
}
