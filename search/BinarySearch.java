package cp.search;


public class BinarySearch {
	
	int binarysearch(int[] a,int key)
	{
		int low=0;
		int high=a.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(a[mid]==key)
				return mid;
			else if(a[mid]<key)
				low=mid+1;
			else
				high=mid-1;
			
			
		}
		return -1;
		
	}
	
	int searchInfinite(int[] a, int key)
	{
		int low=0;
		int high=1;
		
		while(a[high]<key)
		{
			low=high;
			high=high*2;
		}
		return binarysearch(a,key,low,high);
		
	}
	
	int binarysearch(int[] a,int key,int low,int high)
	{
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(a[mid]==key)
			return mid;
		if(a[mid]<key)
			return binarysearch(a,key,mid+1,high);
		else
			return binarysearch(a,key,low,mid-1);
	}

	public static void main(String[] args) {
		int[] a = {10,20,25,30,35,40,45,70,85,90};
		int key=35;
		BinarySearch ob=new BinarySearch();
		int res=ob.searchInfinite(a,key);
		System.out.println("Item found at position : "+res);
		
		

	}

}
