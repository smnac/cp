import java.util.ArrayList;

/*
 * 
 *                   ""/"ABC"
 *                     /\                     
 *                    /  \
 *              "A"/"BC"  ""/"BC"  
 *
 *
 *     processed and unprocessed approach
 *     base condition : unprocessed empty state
 *
 */            



public class SubSequence {
	
	public static void main(String[] args) {
		generateSubSequence("","ABC");
		System.out.println(generateSubSequenceRet("","ABC").toString());
		
	}
	
	public static void generateSubSequence(String processed,String unprocessed)
	{
		if(unprocessed.isEmpty())
		{
			System.out.println(processed);
			return;
		}
		char ch =unprocessed.charAt(0);
		generateSubSequence(processed+ch,unprocessed.substring(1));
		generateSubSequence(processed,unprocessed.substring(1));
			
	}
	
	
	public static ArrayList<String> generateSubSequenceRet(String processed,String unprocessed)
	{
		if(unprocessed.isEmpty())
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add(processed);
			return res;
		}
		char ch =unprocessed.charAt(0);
		ArrayList<String> left = generateSubSequenceRet(processed+ch,unprocessed.substring(1));
		ArrayList<String> right = generateSubSequenceRet(processed,unprocessed.substring(1));
		
		left.addAll(right);
		return left;
		
		
	}	

}
