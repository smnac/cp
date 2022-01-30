package sort;

public class BubbleSort {
	
	void bubblesort(int[] arr) {
		int N=arr.length;
		int temp;
		for(int i=0;i<N;i++)
			for(int j=0;j<N-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
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
		BubbleSort ob=new BubbleSort();
		ob.bubblesort(a);
		ob.printarr(a);

	}

}
