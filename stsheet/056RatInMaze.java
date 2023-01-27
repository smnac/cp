/*
https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

*/

public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if(m[0][0]==1){
        visited[0][0]=true;
        helper(m,0,0,n,visited,"",res);
        return res;
        }
        res.add("-1");
        return res;
    }
    
    private static void helper(int[][] mat,int row,int col,int N,boolean[][] visited,String cur,ArrayList<String> res)
    {
        if(row==N-1 && col==N-1)
        {
            res.add(cur);
            return;
        }
        int[] dirx={1,-1,0,0};
        int[] diry={0,0,1,-1};
        String str="DURL";
        for(int i=0;i<4;i++)
        {
            int newrow= row+dirx[i];
            int newcol= col+diry[i];
            char ch=str.charAt(i);
            if(newrow>=0 && newrow<N && newcol>=0 && newcol<N && mat[newrow][newcol]==1 && !visited[newrow][newcol])
            {
                visited[newrow][newcol]=true;
                helper(mat,newrow,newcol,N,visited,cur+ch,res);
                visited[newrow][newcol]=false;
            }
        }
        
        
    }
}
