/*

https://www.interviewbit.com/problems/allocate-books/
Problem Description
 
 

Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.



Problem Constraints
1 <= N <= 105
 1 <= A[i], B <= 105

*/

public class Solution {
    public int books(int[] A, int B) {
        int n = A.length;
        if(n<B)
            return -1;
        int low=A[0];
        int high=0;
        for(int i=0;i<n;i++)
        {
            low=Math.min(low,A[i]);
            high+=A[i];
        }
        int res = -1;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isValidAllocation(A,n,mid,B))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return low;
    }
    
private boolean isValidAllocation(int[] A,int n,int mid,int B)
{
    int count=0, pages=0;
    for(int i=0;i<n;i++)
    {
        if(pages+A[i]<=mid){
            pages+=A[i];
            if(pages>mid)
             return false;
        }
        else
        {
            count++;
            pages=0;
            pages=A[i];
        }
    }
    
    if(count<B)
    return true;
    
 return false;
}
}
