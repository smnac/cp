/*

https://www.codingninjas.com/codestudio/problems/1112581?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
*/

import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr.get(n-1));

        for(int i=n-2;i>=0;i--)
        {
            while(!stack.isEmpty()&& stack.peek()>= arr.get(i))
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            res.add(stack.peek());
            else
            res.add(-1);

            stack.push(arr.get(i));
        }

        Collections.reverse(res);
        return res;
    }
}
