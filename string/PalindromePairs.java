/*

336. Palindrome Pairs

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.

*/


class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<words.length;i++)
            hm.put(words[i],i); // to get the index quickly
        
        //Empty word case
        
        if(hm.containsKey(""))
        {
            int index=hm.get("");
            
            for(int i=0;i<words.length;i++)
                if(i!=index && isPalindrome(words[i]))
                {
                    ans.add(Arrays.asList(index,i));
                    ans.add(Arrays.asList(i,index));
                }
        }
        
        //Reverse case
        
        for(int i=0;i<words.length;i++)
        {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            Integer index = hm.get(reverse);
            if(index!= null && index!=i)
            {
                ans.add(Arrays.asList(index,i));
                
            }
        }
        
        // split and check
        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            for(int j=1;j<word.length();j++)
            {
                String left=word.substring(0,j);
                String right=word.substring(j);
                
                if(isPalindrome(left))
                {
                    String reverseRight =new StringBuilder(right).reverse().toString();
                    if(hm.containsKey(reverseRight))
                    {
                        ans.add(Arrays.asList(hm.get(reverseRight),i));
                    }
                    
                }
                
                 if(isPalindrome(right))
                {
                    String reverseLeft =new StringBuilder(left).reverse().toString();
                    if(hm.containsKey(reverseLeft))
                    {
                        ans.add(Arrays.asList(i,hm.get(reverseLeft)));
                    }
                    
                }
            }
        
        
        
        }
        return ans;
    }
    
    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while(i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}
