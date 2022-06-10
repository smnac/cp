/*
692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i] <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]

*/


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCountMap = new HashMap<>();
        for(String word:words)
            wordCountMap.put(word,wordCountMap.getOrDefault(word,0)+1);
        
       Queue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)->{
           if(a.getValue()==b.getValue())
               return a.getKey().compareTo(b.getKey());
           return Integer.compare(b.getValue(),a.getValue());
               
       });
        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet())
        {
            pq.add(entry);
        }
        
        List<String> res = new ArrayList<>();
        
        while(k>0)
        {
            res.add(pq.poll().getKey());
            k--;
        }
        
        return res;
    }
}
