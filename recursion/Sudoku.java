class Solution {
    public void solveSudoku(char[][] board) {
       
        
        helper(board,0);
        
        
    }
    
    boolean helper(char[][] board,int cell)
    {
       if(cell==81)
            return true;
        
      int row=cell/9;
       int col=cell%9;
        
        if(board[row][col]=='.'){
        for(int num=1;num<=9;num++)
        {
            if(isSafe(board,row,col,(char)(num+'0')))
            {
                board[row][col]=(char)(num+'0');
                if(helper(board,cell+1))
                {
                    return true;
                }
                else
                {
                    board[row][col]='.'; //backtrack
                }
            }
        }
    }
        else if(helper(board,cell+1))
                {
                    return true;
                }
        
        return false;
    }
    
    boolean isSafe(char[][] board,int row,int col,char num)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==num || board[row][i]==num)
                return false;
        }
        
        int sMatr=row-row%3;
        int sMatc=col-col%3;
        
        for(int i=sMatr;i<sMatr+3;i++)
            for(int j=sMatc;j<sMatc+3;j++)
                if(board[i][j]==num)
                    return false;
        return true;
    }
}
