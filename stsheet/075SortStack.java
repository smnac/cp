/*
https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
*/

import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty())
		{
			int x=stack.pop();
			sortStack(stack);
			sortedInsert(stack,x);
		}
	}

	private static void sortedInsert(Stack<Integer> stack,int item)
	{
		if(stack.isEmpty() || item >=stack.peek())
		{
			stack.push(item);
			return;
		}
		int temp = stack.pop();
		sortedInsert(stack,item); //again call with item
		stack.push(temp);
	}

}
