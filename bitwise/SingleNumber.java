package cp.bitwise;

public class SingleNumber {
  
/*
Given a non-empty array of integers nums, every element appears 
twice except for one. Find that single one.
You must implement a solution with a linear runtime 
complexity and use only constant extra space.

Input: nums = [4,1,2,1,2]
Output: 4
*/

    public int singleNumber(int[] nums) {
        int res=0;
        
        for(int i=0;i<nums.length;i++)
            res=res^nums[i];
        return res;
    }


/*
Given an integer array nums where every element appears 
three times except for one, which appears exactly once. 
Find the single element and return it.

You must implement a solution with a linear runtime complexity 
and use only constant extra space.

Input: nums = [0,1,0,1,0,1,99]
Output: 99

*/



    public int singleNumber2(int[] nums) {
        
        int[] countBit = new int[32];
        
        for(int num:nums)
            for(int i=0;i<32;i++)
                if((num&(1<<i))!=0)
                    countBit[i]++;
        int ans=0;
        for(int i=0;i<32;i++)
            if(countBit[i]%3 != 0)
                ans=ans + (1<<i);
        return ans;
    }
/*
    Given an integer array nums, in which exactly two elements 
    appear only once and all the other elements appear exactly 
    twice. Find the two elements that appear only once. 
    You can return the answer in any order.

    You must write an algorithm that runs in linear 
    runtime complexity and uses only constant extra space.
    
    Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

    */


    public int[] singleNumber3(int[] nums) {
        int[] res=new int[2];
        int temp=0;
        for(int n:nums)
            temp^=n;
       int rmsb=temp&~(temp-1); //right most set bit
        
        for(int n:nums)
        if((n&rmsb)>0)
            res[0]=res[0]^n; //xor all rmsb set numbers
        res[1]=res[0]^temp;  //obtain second number
        return res;
    }

/*
Given an array of integers nums containing n + 1 integers 
where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, 
return this repeated number.

You must solve the problem without modifying the array 
nums and uses only constant extra space.
*/

public int findDuplicate(int[] nums) {
    int res=0;
   for(int i=0;i<nums.length;i++)
       if(nums[Math.abs(nums[i])]>=0)
           nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
       else {
           res= Math.abs(nums[i]);
           break;
       }
   
    for(int n:nums)
        n=Math.abs(n); //restore orginial array
    return res;
}
}
