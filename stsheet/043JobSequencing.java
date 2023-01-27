
/*
https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int lastday=0;
        for(Job job:arr)
          if(job.deadline>lastday)
             lastday=job.deadline;
        int[] allocation = new int[lastday+1];
        Arrays.fill(allocation,-1);

        int profit=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline;j>0;j--)
            {
                if(allocation[j]==-1)
                {
                    allocation[j]=arr[i].id;
                    profit+=arr[i].profit;
                    count++;
                    break;
                }
            }
        }
        return new int[]{count,profit};
    }
}
