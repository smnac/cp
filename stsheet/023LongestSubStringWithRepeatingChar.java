/*

  3. Longest Substring Without Repeating Characters
  https://leetcode.com/problems/longest-substring-without-repeating-characters/
  
  Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int max = 0;
        int x=0;
        int y=0;
        
        while(x<s.length())
        {
            if(!hs.contains(s.charAt(x)))
            {
                hs.add(s.charAt(x));
                x++;
                max=Math.max(max,hs.size());
            }
            else
            {
                hs.remove(s.charAt(y));
                y++;
            }
        }
        
        
        return max;
        
    }
}
