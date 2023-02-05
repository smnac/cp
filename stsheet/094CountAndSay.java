/*
38. Count and Say
https://leetcode.com/problems/count-and-say/
*/
class Solution {
    public String countAndSay(int n) {
        
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        String str="11";
       
for(int i=3;i<=n;i++)
{
    int count=1;
    int len =str.length();
    StringBuilder temp=new StringBuilder();
    for(int j=1;j<len;j++)
    {
        count=1;
        while(j<len && str.charAt(j-1)==str.charAt(j)){
            count++;
            j++;
        }
        temp.append(count);
        temp.append(str.charAt(j-1));
    }
    if(str.charAt(len-2)!=str.charAt(len-1)){
        temp.append(""+1);
        temp.append(str.charAt(len-1));
    }
    str=temp.toString();
                
    }

        return str;
        
    }
}
