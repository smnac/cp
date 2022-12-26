/*

Count Subarrays with Given XOR

https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

Problem Statement
Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1 :
2
5 8
5 3 8 3 10
3 7
5 2 9
Sample Output 1 :
2
1
Explanation Of Sample Input 1 :
In the first test case, the subarray from index 1 to index 3 i.e. {3,8,3} and the subarray from index 2 to index 2 i.e. {8} have bitwise XOR equal to 8.

In the second test case, the subarray from index 0 to index 1 i.e. {5,2} has bitwise XOR equal to 7.
Sample Input 2 :
2
6 11
10 1 0 3 4 7
5 4
4 3 1 2 4
Sample Output 2 :
3
4

*/

import java.io.*;
import java.util.*;
public class Solution {
    public int solve(int[] A, int B) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int c = 0; 
        int cpx = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            cpx = cpx ^ A[i]; 
            if(visited.get(cpx^B) != null) 
                c += visited.get(cpx ^ B); 
            if(cpx == B) {
                c++; 
            }
            if(visited.get(cpx) != null) 
                visited.put(cpx, visited.get(cpx) + 1); 
            else 
                visited.put(cpx, 1); 
        }
        return c; 
    }
}

class TUF {
	public static void main (String[] args) {
		Solution obj = new Solution();
		int[] A = new int[]{4,2,2,6,4};
		int countTotal=obj.solve(A,6);
		System.out.println("The total number of subarrays having a given XOR 
                k is "+countTotal);
	}
}
