package cp.recursion;

public class CountBits {
    public  int countSetBits(int n)
    {
 
        // base case
        if (n == 0)
            return 0;
        else
            return 1 + countSetBits(n & (n - 1));
    }
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        if((n & (n-1))==0)
            return true;
        else
            return false;
        
    }
    public boolean isPowerOfFour(int n) {
        
        if(n<=0)
            return false;
        
        return (n&(n-1))==0 && (n&0b01010101010101010101010101010101)>0;
        //for power of 4 1 should be on only at the odd place
    }
    
}
