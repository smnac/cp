/*
79. Word Search

https://leetcode.com/problems/word-search/
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

*/

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]==word.charAt(0) && searchForWord(i,j,board,word,0))
                    return true;
        return false;
        
    }
    
    private boolean searchForWord(int row,int col,char[][] board,String word,int index)
    {
        if(index>=word.length())
            return true;
        
        int m=board.length;
        int n=board[0].length;
        
        if(row< 0 || row>=m || col<0 || col>=n || board[row][col]!=word.charAt(index))
            return false;
        
        board[row][col]='#';
        
        int[] dr={0,1,0,-1};
        int[] dc ={1,0,-1,0};
        
        for(int i=0;i<4;i++)
            if(searchForWord(row+dr[i],col+dc[i],board,word,index+1))
                return true;
        
        
        board[row][col]=word.charAt(index);
        return false;
        
        
        
    }
}
