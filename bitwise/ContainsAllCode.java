package cp.bitwise;
/* Check If a String Contains All Binary Codes of Size K */

/*
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
*/

import java.util.HashSet;

public class ContainsAllCode {

    public boolean hasAllCodes(String s, int k) {
        
        HashSet<Integer> hs = new HashSet<>();
        int allOnes= (1<<k)-1;
        int hashVal=0;
        for(int i=0;i<s.length();i++)
        {
            hashVal=((hashVal<<1) & allOnes) | (s.charAt(i)-'0');
            if(i>=k-1)
            {
                if(!hs.contains(hashVal))
                    hs.add(hashVal);
            }
            if(hs.size()==(1<<k))
                return true;
        } 
        return false;   
    }
    
}
