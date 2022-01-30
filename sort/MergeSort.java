package cp.sort;

public class MergeSort {

	void mergesort(int[] arr,int low,int high) {
		if(low<high)
		{
			int mid=(low+high)/2;
			mergesort(arr,low,mid);
			mergesort(arr,mid+1,high);
			simple_merge(arr,low,mid,high);
		}
			
	}
	
	private void simple_merge(int[] arr, int low, int mid, int high) {
	   int i=low;
	   int j=mid+1;
	   int[] b = new int[20];
	   int k=low;
	   
	   while(i<=mid && j<=high)
	   {
		   if(arr[i]<=arr[j])
			   b[k++]=arr[i++];
		   else
			   b[k++]=arr[j++];
	   }
	   
	   while(i<=mid)
		   b[k++]=arr[i++];
	   
	   while(j<=high)
		   b[k++]=arr[j++];
	   
	   for(int l=low;l<=high;l++)
	   {
		  arr[l]=b[l]; 
	   }
		   
		
	}

	

	void printarr(int[] arr) {
		System.out.println();
		for(int i:arr)
			System.out.print(" "+i);
	}

	public static void main(String[] args) {
		int[] a = {64, 34, 25, 12, 22, 11, 90,34};
		MergeSort ob=new MergeSort();
		ob.mergesort(a,0,a.length-1);
		ob.printarr(a);

	}

}
