
/*
214. Shortest Palindrome

You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.

*/


public class ShortestPalindrome {
  
	public static String shortestPalindrome(String s) {
		System.out.println(s);
	
	    String temp = s+"#"+new StringBuilder(s).reverse().toString();
	    int[] table = createLPSArray(temp);
	    
	    //here fetch non-palindrome part and reverse and add as prefix to original string
	    return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	    
	}

	private static int[] createLPSArray(String temp) {
		int N=temp.length();
		int[] lps=new int[N];
		 lps[0]=0;
		 int x=0;
		 for(int i=1;i<N;i++)
		 {
			 x = lps[i-1];
			 while(temp.charAt(i)!=temp.charAt(x))
			 {
				 if(x==0)
				 {
					 x=-1;
					 break;
				 }
				 x=lps[x-1];
			 }
			 
			 lps[i]=x+1;
		 }
		 
		 for(int item:lps)
			 System.out.print(item);
		
		System.out.println();
		
		
		return lps;
		
		
	}

	public static void main(String[] args) {
		
		System.out.println(shortestPalindrome("adarsha"));

	}

}
