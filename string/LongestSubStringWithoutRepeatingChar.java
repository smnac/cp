package cp.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    
//Hashmap based implementation
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int cur=0;
        int count=0;
        int max=0;
        
        while(cur<s.length())
        {
            if(!map.containsKey(s.charAt(cur)))
            {
                map.put(s.charAt(cur),cur);
                cur++;
                count++;
                max=max<count?count:max;
    
            }
            else
            {
                cur=map.get(s.charAt(cur))+1;
                map.clear();
                count=0;
            }
        }
        
        return max;
        
    }

//Hashset based implementation
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> hs = new HashSet<>();
        int max=0;
        int x=0,y=0;
        
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
