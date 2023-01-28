/*

https://www.interviewbit.com/problems/maximum-sum-combinations/

*/

import java.util.*;
public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n=A.length;
        Arrays.sort(A,Collections.reverseOrder());
        Arrays.sort(B,Collections.reverseOrder());
        PriorityQueue<int[]> pq = new PriorityQueue<>(n,(a,b)->b[1]-a[1]);
        pq.offer(new int[]{A[0]+B[0],0,0});
        Set<int[]> set = new HashSet<>();
        
        
        int[] res = new int[C];
        int count=0;
        int index=0;
        while(count<C)
        {
           int[] item = pq.poll();
           int i = item[1];
           int j = item[2];
           res[index++]=item[0];
           if(!hs.contains(new int[]{i+1,j}) && i+1<n)
           {
               pq.offer(new int[]{A[i+1]+B[j],i+1,j});
               hs.add(new int[]{i+1,j});
           }
           
           if(!hs.contains(new int[]{1,j+1}) && j+1<n)
           {
               pq.offer(new int[]{A[i]+B[j+1],i,j+1});
               hs.add(new int[]{i,j+1});
           }
                 
        }
        return res;
    }
}
