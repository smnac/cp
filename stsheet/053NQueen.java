/*
https://leetcode.com/problems/n-queens/
*/

class Solution {
     List<List<String>> ans ;
    public List<List<String>> solveNQueens(int n) {
        
         ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveBoard(board,0);
        return ans;
    }
    
    private void solveBoard(boolean[][] board,int col)
    {
        if(col==board.length){
         List<String> res = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                   String str="";
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j])
                        str=str+"Q";
                     else
                        str=str+"."; 
                }
               
                res.add(str);
            }
            ans.add(res);
            return;
        }
        
        for(int i=0;i<board.length;i++)
        {
            if(isSafe(board,i,col))
            {
                board[i][col]=true;
                solveBoard(board,col+1);
                board[i][col]=false;
            }
        }
        
    }
    
    /*private boolean isSafe(boolean[][] board,int row,int col)
    {
        
        int n=board.length;
        
        for(int i=row;i>=0;i--)
        {
            for(int j=col;j>=0;j--)
            {
                if(board[i][j]==true)
                    return false;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=col;j>=0;j--)
            {
                if(board[i][j]==true)
                    return false;
            }
        }
        
        for(int j=col;j>=0;j--)
            {
                if(board[row][j]==true)
                    return false;
            }
        
       System.out.println("return");
        return true;
    }*/
 
    private boolean isSafe(boolean[][] board, int row, int col) {
		
		//scan the current column upto row
        for(int i=0;i<col;i++)
			if(board[row][i]==true)
				return false;
		
		//left diagonal
		int count= Math.min(row, col);
		int r=row-1;
		int c=col-1;
		for(int i=0;i<count;i++)
			if(board[r--][c--]==true)
				return false;
		
		//right diagonal
		 count= Math.min(row, board.length-col-1);
		 r=row-1;
		 c=col+1;
		 
		 for(int i=0;i<count;i++)
				if(board[r--][c++]==true)
					return false;
		
		
		return true;
	}
}
