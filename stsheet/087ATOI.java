/*

https://leetcode.com/problems/string-to-integer-atoi/
8. String to Integer (atoi)

*/

class Solution {
    public int myAtoi(String s) {
        int res = 0;
        int sign =1;
        
        int n = s.length();
        int i=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i<n && s.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        else if(i<n && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        
        
        while((i<n) && 0<= (int)s.charAt(i)-'0' && (int)s.charAt(i)-'0'<=9){
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && (int)s.charAt(i)-'0'>Integer.MAX_VALUE%10)){
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            // int num = ((int)s.charAt(i)-'0');
            // res = res *10;
            // res = res + num;
            // i++;
            res*=10;
            res+=((int)s.charAt(i)-'0');
            i++;
        }
        
        return res * sign;
        
    }
}
