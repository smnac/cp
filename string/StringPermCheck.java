package cp.string;

/* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */

import java.util.Arrays;

public class StringPermCheck {
    public boolean checkInclusion(String s1, String s2) {
        
        int a=s1.length(), b=s2.length();
        
        if(a>b || b==0)
            return false;
        
        if(a==0)
            return true;
        
        int[] x= new int[26];
        int[] y=new int[26];
        
        for(int i=0;i<a;i++)
        {
            x[s1.charAt(i)-'a']++;
            y[s2.charAt(i)-'a']++;
        }
        
        for(int i=a;i<b;i++)
        {
            if(Arrays.equals(x,y))
                return true;
            y[s2.charAt(i-a)-'a']--;
            y[s2.charAt(i)-'a']++;
        }
        
        if(Arrays.equals(x,y))
                return true;
        
        return false;
        
        
        
    } 
}
