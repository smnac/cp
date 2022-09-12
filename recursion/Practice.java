import java.util.ArrayList;
import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        System.out.println("Hello world");
        //System.out.println(fib(4));
       // int[] a=new int[]{10,20,30,40,50};
       // System.out.println(binarySearch(a,70,0,a.length-1));
       // printb(5);
       // System.out.println(revNumber(123,(int)Math.log10(123)));
        //System.out.println(countZeros(12300));
        int[] a=new int[]{10,20,30,40,50,25};
       // System.out.println(isSorted(a,0));
        //System.out.println(linearSearch(a,0,80));
       // System.out.println(linearSearchAll(a,0,20,new ArrayList<>()));
        // System.out.println(linearSearchAllWithoutArgList(a,0,20));
       // triangle(4,0);
        for(int item:a)
            System.out.print(item +" ");
        System.out.println();
        //bubbleSort(a,a.length-1,0);
        selectionSort(a,a.length,0,0);
        for(int item:a)
            System.out.print(item +" ");
        System.out.println();

    }

    private static void selectionSort(int[] a,int r,int c,int max)
    {
        if(r==0)
            return;
        if(c<r)
        {
            if(a[c]>a[max])
            {
                selectionSort(a,r,c+1,c);
            }
            else {
                selectionSort(a, r, c + 1, max);
            }
        }
        else
        {
            int temp=a[max];
            a[max]=a[r-1];
            a[r-1]=temp;
            selectionSort(a, r-1, 0, 0);
        }
    }

    private static void bubbleSort(int[] a,int r, int c)
    {
        if(r==0)
            return;
        if(c<r)
        {
            if(a[c]>a[c+1])
            {
                int temp = a[c];
                a[c]=a[c+1];
                a[c+1]=temp;
            }
            bubbleSort(a,r,c+1);
        }
        else
        {
            bubbleSort(a,r-1,0);
        }
    }
    private static void triangle(int r,int c)
    {
        if(r==0)
            return;

        if(c<r)
        {
            triangle(r,c+1);
            System.out.print("* ");

        }
        else
        {

            triangle(r-1,0);
            System.out.println();
        }
    }

    private static ArrayList linearSearchAllWithoutArgList(int[] a, int index, int key) {
       ArrayList<Integer> res = new ArrayList<>();
        if(index==a.length)
            return res;
        if(a[index]==key)
            res.add(index);
        res.addAll(linearSearchAllWithoutArgList(a,index+1,key));
        return res;
    }
    private static ArrayList linearSearchAll(int[] a, int index, int key, ArrayList<Integer> res) {

        if(index==a.length)
            return res;
        if(a[index]==key)
            res.add(index);
        return linearSearchAll(a,index+1,key,res);
    }

    private static int linearSearch(int[] a, int index,int key) {
        if(index>=a.length)
            return -1;
        if(a[index]==key)
            return index;
        return linearSearch(a,index+1,key);
    }

    private static boolean isSorted(int[] a, int index) {
        if(index==a.length-1)
            return true;
        return a[index]<a[index+1] && isSorted(a,index+1);
    }

    private static void printb(int num)
    {
        if(num==0)
            return;
      //  System.out.println(num);
        printb(num-1);
        System.out.println(num);

    }
    static int base=1;
    private static int revNumber(int num,int digits)
    {
        if(num<10) {
            // System.out.print(num);
            return num;
        }
        return num%10*(int)Math.pow(10,digits)+revNumber(num/10,digits-1);
    }

    private static int countZeros(int nums)
    {
        if(nums==0)
            return 0;
        if(nums%10==0)
            return 1 + countZeros(nums/10);
        else
            return countZeros(nums/10);

    }

    private static int sumOfDigits(int num)
    {
        if(num<10)
            return num;
        return num%10 * sumOfDigits(num/10);

    }
    private static int binarySearch(int[] a,int key,int low,int high)
    {
        if(low>high)
            return -1;
        int mid = low + (high-low)/2;
        if(a[mid]==key)
            return mid;
        if(a[mid]>key)
            return binarySearch(a,key,low,mid-1);
        else
            return binarySearch(a,key,mid+1,high);
    }

    private static int fib(int n)
    {
        if(n<2)
            return n;

        return fib(n-1) + fib(n-2);
    }

    private static void print(int n) {
        if(n==5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }
}
