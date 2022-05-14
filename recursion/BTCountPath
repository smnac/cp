
public class BTCountPath {

	public static void main(String[] args) {
	
		
		int n=3;
		boolean[][] maze = new boolean[][]
				{
			{true,true,true},
			{true,true,true},
			{true,true,true}
				};
				int ans = countPath(maze,"",0,0,3);
		System.out.println(ans);

	}

	private static int countPath(boolean[][] maze,String p, int row, int col, int N) {
		
		if(row==N-1 && col==N-1) {
			System.out.println(p);
			return 1;
		}
		if(!maze[row][col])
		{
			return 0;
		}
		maze[row][col]=false;
		
		int down=0,right=0,left=0,up=0;
		if(row<N-1)
			down=countPath(maze,p+"D",row+1,col,N);
		if(col<N-1)
			right=countPath(maze,p+"R",row,col+1,N);
		if(row>0)
			up=countPath(maze,p+"U",row-1,col,N);
		if(col>0)
			left=countPath(maze,p+"L",row,col-1,N);
				
		maze[row][col]=true;
		return left+right+down+up;
	}

}
