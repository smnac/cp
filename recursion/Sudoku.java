class Solution {
    public void solveSudoku(char[][] board) {
       
        
        helper(board,0,0);
        
        
    }
    
    boolean helper(char[][] board,int row,int col)
    {
       
        if(row==8 && col>8)
            return true;
        
        if(col>8){
            col=col%9;
            row=row+1;
        }
        
        if(board[row][col]=='.'){
        for(int num=1;num<=9;num++)
        {
            if(isSafe(board,row,col,(char)(num+'0')))
            {
                board[row][col]=(char)(num+'0');
                if(helper(board,row,col+1))
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
        else if(helper(board,row,col+1))
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
