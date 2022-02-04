package cp.graph;

/*
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
*/

class UnionFind {
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;
    private int count;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                         // a standalone vertex with no connection to other vertices.
        }
        count=size;
    }

	// The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

	// The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
             count--;
        }
       
    }

    public int getCount() {
        return count;
    }
}


public class NumberOfIslandUF {
    public int findCircleNum(int[][] isConnected) {
        int M=isConnected.length;
        UnionFind uf = new UnionFind(M);
        for(int i=0;i<M;i++)
            for(int j=0;j<M;j++)
                if(isConnected[i][j]==1)
                    uf.union(i,j);
        return uf.getCount();
        
    } 
}
