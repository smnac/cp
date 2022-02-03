/* Given an integer array nums, return the maximum 
result of nums[i] XOR nums[j], where 0 <= i <= j < n */

package cp.bitwise;
class Node
{
    Node child[];
    
   Node()
   {
       child = new Node[2];
   }
};

class Trie
{
    private static Node root;
    
    Trie() {
        root=new Node();
    }
    
    public static void insert(int num)
    {
        Node cur =root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i) & 1;
            if(cur.child[bit]==null)
                cur.child[bit]=new Node();
            cur=cur.child[bit];
        }
    }
    
    public int getMax(int num) {
        Node cur=root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
        if(cur.child[1-bit]!=null) //see opposite bit is on to maximize
        {
            maxNum=maxNum | (1<<i);
            cur=cur.child[1-bit];
        }
        else //otherwise go with the given bit
        {
            cur=cur.child[bit];
        }
    }
        
        return maxNum;
    }
    
    
}

public class MaximumXOR {

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        
        for(int i=0;i<nums.length;i++)
            trie.insert(nums[i]);
        int max=-1;
        int curMax=0;
        for(int i=0;i<nums.length;i++){
            curMax=trie.getMax(nums[i]);
            max=max<curMax?curMax:max;
            }
        return max;
    }
    
}
