/*

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

*/


// 1. Using two stacks, 1 for string , 1 for count

class Solution {
    public String decodeString(String s) {
        
        int index=0;
        int length=s.length();
        
        int start=0,end=0;
        Stack<Integer> counts = new Stack<>();
        Stack<String> results = new Stack<>();
        String ans="";
        
        while(index<length)
        {
            if((Character.isDigit(s.charAt(index))))
            {
            start=index;
            end=index;
            while(Character.isDigit(s.charAt(index)))
            {
                end++;
                index++;
            }
            
            counts.push(Integer.parseInt(s.substring(start,end)));
            }
            else if(s.charAt(index)=='[')
            {
                results.push(ans);
                ans="";
                index++;
                
            }
            else if(s.charAt(index)==']')
            {
                StringBuilder temp=new StringBuilder(results.pop());
                int len=counts.pop();
                for(int i=0;i<len;i++)
                   temp.append(ans);
                ans=temp.toString();
                index++;
                
            }
            else
            {
                ans+=s.charAt(index++);
                
            }
        }
               
        return ans;
    }
}


// 2. Recursion


class Solution {
    public String decodeString(String s) {
        
        return helper(s,new int[]{0});
        
    }
    
    private String helper(String s, int[] index)
    {
        
        StringBuilder sb = new StringBuilder();
        int num=0;
        
        while(index[0]<s.length())
        {
            char ch=s.charAt(index[0]);
            index[0]++;
            
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
                
            }
            else if(ch=='[')
            {
                String innerInput = helper(s,index);
                
                while(num>0)
                {
                    sb.append(innerInput);
                    num--;
                }
                    
            }
            
            else if(ch==']')
            {
                break;
            }
            
            else
            {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}


