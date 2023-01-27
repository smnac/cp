/*

https://www.codingninjas.com/codestudio/problems/983635?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

*/
public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		Set<String> dict = new HashSet<>();
		for(String str:dictionary)
			dict.add(str);
		ArrayList<String> res = new ArrayList<>();
		helper(s,dict,"",res);
		return res;
	}

	private static void helper(String s,Set<String> dict,String ans,ArrayList<String> res)
	{
		if(s.length()==0)
		{
			res.add(ans);
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			String left = s.substring(0,i+1);
			if(dict.contains(left))
			{
				String right = s.substring(i+1);
				helper(right,dict,ans+left+" ",res);
			}
		}
	}
}
