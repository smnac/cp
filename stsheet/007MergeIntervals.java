/*


56. Merge Intervals

https://leetcode.com/problems/merge-intervals/


Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]); // sort based on start time
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]); // take first item to result
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=res.getLast()[0] && intervals[i][0]<=res.getLast()[1]).  // compare subsequent item from the rear end of result imp: getLast()
            {
                res.getLast()[1]=Math.max(res.getLast()[1],intervals[i][1]);
            }
            else
                res.add(intervals[i]);
        }
        
        return res.toArray(new int[res.size()][2]);
        
    }
}
