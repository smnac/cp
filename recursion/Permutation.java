import java.util.ArrayList;

/*
 * 
 *                   ""/"ABC"
 *                     /                     
 *                    /  
 *              "A"/"BC"
 *                / \
 *               /   \ 
 *         "AB"/"C"  "BA"/"C"   consider next char in all position of processed string 
 *            /
 *           /
 *        ABC  ACB CAB   BAC BCA CBA        first,middle and last position  
 *           
 *     processed and unprocessed approach
 *     base condition : unprocessed empty state
 *
 */            



public class Permutation {

	
	public static void main(String[] args) {
		String str="ABC";
		
		permute("",str);
		System.out.println(permuteRet("",str));
	}

	private static void permute(String processed, String unprocessed) {
		
		if(unprocessed.isEmpty())
		{
			System.out.println(processed);
			return;
		}
		char ch=unprocessed.charAt(0);
		for(int i=0;i<=processed.length();i++) // = is important
		{
			String left = processed.substring(0,i);
			
			String right=processed.substring(i);
			permute(left+ch+right,unprocessed.substring(1));
		}
		
	}
	
   private static ArrayList<String> permuteRet(String processed, String unprocessed) {
		
		if(unprocessed.isEmpty())
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add(processed);
			return res;
		}
		
		ArrayList<String> ans = new ArrayList<String>();
		char ch=unprocessed.charAt(0);
		for(int i=0;i<=processed.length();i++) // = is important
		{
			String left = processed.substring(0,i);
			
			String right=processed.substring(i);
			ans.addAll(permuteRet(left+ch+right,unprocessed.substring(1)));
		}
		
		return ans;
		
	}
}
