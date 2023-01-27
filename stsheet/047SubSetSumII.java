/*
https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

*/
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr,0,n,new ArrayList<>(),res);
        return res;
    }

    private static void helper(int[] arr,int index,int N,ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res)
    {
        
            res.add(new ArrayList<>(cur));
          


        for(int i=index;i<N;i++)
        {
            if(i>index && arr[i-1]==arr[i])
                continue;
            cur.add(arr[i]);
            helper(arr,i+1,N,cur,res);
            cur.remove(cur.size()-1);
        }
    }

}
