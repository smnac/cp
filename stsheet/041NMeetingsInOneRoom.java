/*

https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

*/

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
       
        int[][] meeting = new int[n][3];
        for(int i=0;i<n;i++)
        {
            meeting[i][0]=1;
            meeting[i][1]=start[i];
            meeting[i][2]=end[i];
        }
        
        Arrays.sort(meeting,(a,b)->a[2]-b[2]);
        int limit=meeting[0][2];
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(limit<meeting[i][1]) // check start time of next meeting
            {
                limit=meeting[i][2];  // within limits update finish time
                count++;
            }
        }
        return count;
    }
}
