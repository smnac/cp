package cp.sort;

public class InsertionSort {

	void insertionsort(int[] arr) {
		int N=arr.length;
		
		for(int i=1;i<N;i++)
		{
			int temp=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
				
			
	}
	
	void printarr(int[] arr) {
		System.out.println();
		for(int i:arr)
			System.out.print(" "+i);
	}

	public static void main(String[] args) {
		int[] a = {64, 34, 25, 12, 22, 11, 90,34};
		InsertionSort ob=new InsertionSort();
		ob.insertionsort(a);
		ob.printarr(a);

	}

}
