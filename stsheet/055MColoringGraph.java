/*
https://www.codingninjas.com/codestudio/problems/981273?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
*/

import java.util.* ;
import java.io.*; 
public class Solution {
	public static String graphColoring(int[][] mat, int m) {
		  int n=mat.length;
		  int[] color= new int[n];
		  return helper(mat,0,mat.length,color,m)==true?"YES":"NO";
	}

	private static boolean helper(int[][] mat,int index,int N,int[] color,int m)
	{
		if(index==N)
		  return true;

		  for(int i=1;i<=m;i++)
		  {
			  if(isSafe(mat,index,color,i))
			  {
				  color[index]=i;
				  if(helper(mat,index+1,N,color,m)==true)
				    return true;
				  color[index]=0;
			  }
		  }

		  return false;
	}

	private static boolean isSafe(int[][] mat,int index,int[] color,int val)
	{
		for(int i=0;i<mat.length;i++)
		{
			if(mat[index][i]==1)
			{
				if(color[i]==val)
					return false;
			}
		}

		return true;
	}
}
