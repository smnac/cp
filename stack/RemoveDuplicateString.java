/*

1209. Remove All Adjacent Duplicates in String II
Medium

3509

67

Add to List

Share
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.

*/

class RemoveDuplicateString {
    public String removeDuplicates(String s, int k) {
        
    Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek()[0]==ch)
            {
                stack.peek()[1]++;
            }
            else
            {
                stack.push(new int[]{ch,1});
            }
            
            if(stack.peek()[1]==k)
                stack.pop();
        }
        
        StringBuilder res=new StringBuilder();
        
        while(!stack.isEmpty())
        { int[] cc = stack.pop();
            for(int i=0;i<cc[1];i++)
            res.append((char)cc[0]);
        }
        
        return res.reverse().toString();
        
    }
 
 public String removeDuplicatesRecursion(String s, int k) {
        int count=1;
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                count++;
            else
                count=1;
            
            if(count==k)
            {
                return removeDuplicates(s.substring(0,i-k+1)+s.substring(i+1),k);
            }
        }
        
        return s;
    
        
    }
}
