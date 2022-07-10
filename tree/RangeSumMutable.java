// 307. Range Sum Query - Mutable
/*

Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.

*/

 class FenwickTree {
	
	int[] binaryIndexTree;
	int size;
	public FenwickTree(int[] input) {
		this.size=input.length+1;
		binaryIndexTree=new int[size]; // remember 1 more than required size
		for(int i=1;i<size;i++)
			updateTree(input[i-1],i);
		
	}
	 public void updateTree(int val, int index) {
		while(index<size)
		{
			binaryIndexTree[index]+=val;
			index=getNext(index);
		}
		
	}
	
	public int getSum(int index)
	{
		index=index+1; //just move to next index
		int sum=0;
		while(index>0)
		{
			sum+=binaryIndexTree[index];
			index=getParent(index);
		}
		return sum;
	}
	private int getParent(int index) {
		return index - (index & -index);

	}
	private int getNext(int index) {
		return index + (index & -index);
	}
	
	

}

class NumArray {
    FenwickTree ft;
    int[] input;
    public NumArray(int[] nums) {
        input=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            input[i]=nums[i];
        ft = new FenwickTree(nums);
    }
    
    public void update(int index, int val) {
        int diff=val-input[index];
        ft.updateTree(diff,index+1);
        input[index]=val;
    }
    
    public int sumRange(int left, int right) {

        return ft.getSum(right)-ft.getSum(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
