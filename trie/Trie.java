package cp.trie;

public class Trie {
    static final int ALPHABET_SIZE=26;

    static class TrieNode {

        TrieNode[] children=new TrieNode[ALPHABET_SIZE];
        boolean isEndofWord;

        TrieNode()
        {
            isEndofWord=false;
            for(int i=0;i<ALPHABET_SIZE;i++)
            children[i]=null;

        }
    }

    static TrieNode root;

    static void insert(String str)
    {
        int level;
        int length=str.length();
        int index;

        TrieNode cur=root;

        for(int i=0;i<length;i++)
        {
            if(cur.children[str.charAt(i)-'a']==null)
            cur.children[str.charAt(i)-'a']=new TrieNode();

            cur=cur.children[str.charAt(i)-'a'];

        }
        cur.isEndofWord=true;
    }

    static boolean search(String str)
    {
        TrieNode cur = root;
        for(int i=0;i<str.length();i++)
        {
            if(cur.children[str.charAt(i)-'a']==null)
                return false;

                cur=cur.children[str.charAt(i)-'a'];
        }
        if(cur.isEndofWord)
        return true;

        return false;
    }

    public static void main(String[] args) {
        root=new TrieNode();
        insert("ayush");
        System.out.println(search("ayush"));
    }
}
