/*

https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?leftPanelTab=1
*/

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		ArrayList<Integer> res = new ArrayList<>();
		Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

		for(int i=0;i<k;i++)
		{
			pq.offer(new int[]{kArrays.get(i).get(0),i,0});
		}

		while(!pq.isEmpty())
		{
			int[] item = pq.poll();
			res.add(item[0]);
			if(kArrays.get(item[1]).size()>item[2]+1)
			{
				pq.offer(new int[]{kArrays.get(item[1]).get(item[2]+1),item[1],item[2]+1});
			}

		}
		return res;
	}
}
