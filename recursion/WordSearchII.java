/*

212. Word Search II

https://leetcode.com/problems/word-search-ii/
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

*/

class Solution {
   public List<String> findWords(char[][] board, String[] words) {
       int m=board.length;
       int n=board[0].length;
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res,m,n);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res,int m,int n) {
     if(i< 0 || i>=m || j<0 || j>=n)
         return;
    
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) 
        return;
    
    p = p.next[c - 'a'];
    if (p.word != null) {   /* word present */
        res.add(p.word);
        p.word = null;     /* After adding remove from trie */
    }

    board[i][j] = '#';
    int[] dr={0,1,0,-1};
    int[] dc ={1,0,-1,0};
        
    for(int k=0;k<4;k++)
        dfs(board, i+dr[k], j+dc[k] ,p, res,m,n); 

    board[i][j] = c;
}

public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
}
