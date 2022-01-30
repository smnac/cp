package cp.sort;

public class QuickSort {

	void quicksort(int[] arr,int low,int high) {
		if(low<high)
		{
			int j=partition(arr,low,high);
			quicksort(arr,low,j-1);
			quicksort(arr,j+1,high);
		}
			
	}
	
	private int partition(int[] arr, int low, int high) {
		
		int pivot=arr[low];
		int i=low+1;
		int j=high;
		int temp;
		
		while(i<j)
		{
			while(pivot>=arr[i] && i<= high) i++;
			while(pivot<arr[j] && j>=0 ) j--;
			if(i<j) { // don't forget
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			}
		}
		
		temp=arr[low];
		arr[low]=arr[j];
		arr[j]=temp;
		return j;
		
		
	}

	void printarr(int[] arr) {
		System.out.println();
		for(int i:arr)
			System.out.print(" "+i);
	}

	public static void main(String[] args) {
		int[] a = {64, 34, 25, 12, 22, 11, 90,34};
		QuickSort ob=new QuickSort();
		ob.quicksort(a,0,a.length-1);
		ob.printarr(a);

	}

}
