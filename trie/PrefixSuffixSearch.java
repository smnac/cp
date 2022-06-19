/*

745. Prefix and Suffix Search

Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 

Constraints:

1 <= words.length <= 15000
1 <= words[i].length <= 10
1 <= prefix.length, suffix.length <= 10
words[i], prefix and suffix consist of lower-case English letters only.
At most 15000 calls will be made to the function f.

*/


class WordFilter {

   static final int ALPHABET_SIZE=26;

	static class TrieNode {
		TrieNode[] children;
		boolean isEndOfWord;
		Set<Integer> indexList;
		
		public TrieNode() {
			children = new TrieNode[ALPHABET_SIZE];
			isEndOfWord=false;
			indexList=new TreeSet<>((a,b)->Integer.compare(b,a));
		}
		
		
	}
	
	static TrieNode prefixTree;
	static TrieNode suffixTree;
	
	
	
	static void insert(String key,int itemIndex,TrieNode root)
	{
		
		int length=key.length();
		int index;
		
		TrieNode cur=root;
		//System.out.println(root.children[0]);
		
		
		for(int i=0;i<length;i++)
		{
			index=key.charAt(i)-'a';
			if(cur.children[index]==null)
				cur.children[index]=new TrieNode();
			
			cur=cur.children[index];
            cur.indexList.add(itemIndex);
			
			
			
		}
		
		cur.isEndOfWord=true;
		
		
	}
	
	static Set<Integer> search(String key,TrieNode root)
	{
		int length=key.length();
		int index;
		
		TrieNode cur=root;
		
		for(int i=0;i<length;i++)
		{
			index=key.charAt(i)-'a';
			if(cur.children[index]==null)
				return null;
			
			cur=cur.children[index];
		}
		
		return cur.indexList;
	}
	
	
    public WordFilter(String[] words) {
        
     prefixTree=new TrieNode();
     suffixTree=new TrieNode();
	
		for(int i=0;i<words.length;i++) {
			insert(words[i],i,prefixTree);
			StringBuilder sb=new StringBuilder(words[i]);
			insert(sb.reverse().toString(),i,suffixTree);
		}
    }
    
    public int f(String prefix, String suffix) {
        Set<Integer> pList = search(prefix,prefixTree);
        StringBuilder sb=new StringBuilder(suffix);
         Set<Integer> sList = search(sb.reverse().toString(),suffixTree);
        
        if(pList==null || sList==null)
            return -1;
       
       for(int index:pList)
       {
          // System.out.print(index+" ");
    	   if(sList.contains(index))
    		   return index;
       }
    
        return -1;
    }
}








