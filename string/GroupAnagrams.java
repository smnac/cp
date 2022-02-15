package cp.string;

/*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> result = new HashMap<>();
        
        for(String str:strs)
        {
            
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr); //sort and use it as key
            
           /* int[] count = new int[26]; //count number of char
            for(int i=0;i<str.length();i++)
                count[str.charAt(i)-'a']++;
            
            StringBuilder sb=new StringBuilder();
            
            for(int i=0;i<26;i++)
                sb.append(count[i]+"#");
            
            String key=sb.toString();*/
            result.putIfAbsent(key,new ArrayList<>());
            result.get(key).add(str);
        }
        
        return new ArrayList<>(result.values());
        
    } 
}
