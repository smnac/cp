
public class FenwickTree {
	
	int[] binaryIndexTree;
	int size;
	public FenwickTree(int[] input) {
		this.size=input.length+1;
		binaryIndexTree=new int[size]; // remember 1 more than required size
		for(int i=1;i<size;i++)
			updateTree(input[i-1],i);
		
	}
	private void updateTree(int val, int index) {
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
	
	public static void main(String[] args) {
		int[] a= {0,1,2,3,4,5,6,7,8};
		FenwickTree ft=new FenwickTree(a);
		System.out.println(ft.getSum(2));
		System.out.println(ft.getSum(4));

	}

}


