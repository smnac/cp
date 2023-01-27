
/*
https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
*/
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform=1,ans=1;
        int ai=1,di=0;
        while(ai<n && di<n)
        {
            if(arr[ai]<=dep[di])
            {
                platform++;
                ai++;
            }
            else if(arr[ai]>dep[di])
            {
                platform--;
                di++;
            }
            
            if(platform>ans)
                ans=platform;
        }
        return ans;
        
    }
    
}
