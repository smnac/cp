/*
https://practice.geeksforgeeks.org/problems/subset-sums2234/1

*/

public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> res = new ArrayList<>();
         helper(num,0,num.length,0,res);
         Collections.sort(res);
         return res;
    }

    private static void helper(int num[],int index,int N,int sum,ArrayList<Integer> res)
    {
        if(index==N)
        {
            res.add(sum);
            return;
        }
        helper(num,index+1,N,sum,res);
        helper(num,index+1,N,sum+num[index],res);
      

    }

}
