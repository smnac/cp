
//https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int low=1;
        int high=x;
        int mid=0;
        
        while(low<high)
        {
            mid=low +(high-low)/2;
            if(mid<=x/mid && (mid+1)>x/(mid+1) )
                return mid;
            else if(mid<x/mid)
                low=mid+1;
            else
                high=mid;
        }
        
        return low;
        
    }
}
