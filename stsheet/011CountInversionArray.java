/*

  TODO
  
https://www.codingninjas.com/codestudio/problems/count-inversions_615?leftPanelTab=0  
  
  */


public class Solution {
    public static long getInversions(long arr[], int n) {
        long[] temp = new long[n];
        return mergesort(arr,temp,0,n-1);
    }
        private static int mergesort(long[] arr,long[] temp,int low,int high) {
            int invcount=0;
        if(low<high)
        {
            int mid=(low+high)/2;
            invcount+=mergesort(arr,temp,low,mid);
            invcount+=mergesort(arr,temp,mid+1,high);
            invcount+=simple_merge(arr,temp,low,mid+1,high);
        }
            return invcount;
    }
    
    private static  int simple_merge(long[] arr,long[] temp, int low, int mid, int high) {
       int i=low;
       int j=mid;
      // long[] b = new long[20];
       int k=low;
        int invcount=0;
       
       while(i<=mid-1 && j<=high)
       {
           if(arr[i]<=arr[j])
               temp[k++]=arr[i++];
           else{
               temp[k++]=arr[j++];
               invcount=invcount+(mid-i);  //simple merge sort if a[i]>a[j] increase count by remaining elements of left half that is mid-i
           }
       }
       
       while(i<=mid-1)
           temp[k++]=arr[i++];
       
       while(j<=high)
           temp[k++]=arr[j++];
       
       for(int l=low;l<=high;l++)
       {
          arr[l]=temp[l]; 
       }
         return invcount;  
        
    }
    }
