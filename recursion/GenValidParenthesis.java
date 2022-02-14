package cp.recursion;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/


import java.util.ArrayList;
import java.util.List;

public class GenValidParenthesis {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(new StringBuilder(),0,0,n);
        return res;
    }
    //opc => open parenthesis count,close,total
    public void helper(StringBuilder cur,int opc,int cpc,int tpc)
    {
        if(cur.length() == 2*tpc) //when it meets parenthesis count
        {
            res.add(cur.toString());
            return;
        }
        
        if(opc<tpc)
        {
            cur.append("(");
            helper(cur,opc+1,cpc,tpc);
            cur.deleteCharAt(cur.length() -1); //backtrack
            
        }
        
        if(cpc<opc)
        {
            cur.append(")");
            helper(cur,opc,cpc+1,tpc);
            cur.deleteCharAt(cur.length() -1); //backtrack
        }
    }
}
