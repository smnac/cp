package cp.math;

/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N=nums.length;
        int[] result = new int[N];
        
        result[0]=1;
        
        for(int i=1;i<N;i++)
            result[i]=nums[i-1]*result[i-1];
        
        int R=1;
        for(int i=N-1;i>=0;i--){
            result[i]=result[i]*R;
            R=R*nums[i];
        }
        
        return result;
}
