/* 477. Total Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
The answer for the given input will fit in a 32-bit integer.

*/


class Solution {
    public int totalHammingDistance(int[] nums) {
        int res=0;
        for (int i=0;i<32;i++) {
        int oneCount = 0;
        for (int j=0;j<nums.length;j++) 
            oneCount += (nums[j] >> i) & 1;
        res += oneCount*(nums.length - oneCount); //x ways and y ways, total ways = x*y ways
        }
        
        return res;
        
      /*  ArrayList<String> binString = new ArrayList<>();
        for(int x:nums)
            binString.add(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        int res=0;
        for(int i=0;i<32;i++){
            int zc=0,oc=0;
            for(int j=0;j<nums.length;j++){
                if(binString.get(j).charAt(i)=='0')
                    zc++;
                else
                    oc++;
            }
            res=res+zc*oc;  //x ways and y ways, total ways = x*y ways
        }
                
        return res;*/
        
    }
    
    
}
