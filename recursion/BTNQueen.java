
public class BTNQueen {
	
	
	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
				int ans = placeQueens(board,0);
				System.out.println(ans);
	}

	private static int placeQueens(boolean[][] board, int row) {
		
		   if(row==board.length)
		   {
			   return 1;
		   }
		   
		   int count=0;
		   
		   for(int col=0;col<board.length;col++)
		   {
			   if(isSafe(board,row,col))
			   {
				   board[row][col]=true;
				   count +=placeQueens(board,row+1);
				  board[row][col]=false;	   
			   }
		   }
		
		return count;
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		
		for(int i=0;i<row;i++)
			if(board[i][col]==true)
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
