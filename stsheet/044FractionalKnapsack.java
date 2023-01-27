/*
https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,(a,b)->{
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            if(r1<r2)
            return 1;
            else if(r1>r2)
            return -1;
            else
            return 0;
        });
        
        double total=0;
        int weightSofar=0;
     
        
        for(int i=0;i<n;i++)
        {
            if(weightSofar+arr[i].weight<=W)
            {
                weightSofar+=arr[i].weight;
                total+=arr[i].value;
               
            }
            else
            {
               total+=(W-weightSofar)*((double)arr[i].value/(double)arr[i].weight); 
               break;
            }
        }
        
        
        return total;
    }
}
