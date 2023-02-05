/*

https://leetcode.com/problems/roman-to-integer/
13. Roman to Integer

*/

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            num+=hm.get(ch);
            if((ch=='V' || ch=='X') && i>0 && s.charAt(i-1)=='I')
                num=num-2;
            if((ch=='L' || ch=='C') && i>0 && s.charAt(i-1)=='X')
                num=num-20;
            if((ch=='D' || ch=='M') && i>0 && s.charAt(i-1)=='C')
                num=num-200;
        }
        
        return num;
        
        
    }
}
