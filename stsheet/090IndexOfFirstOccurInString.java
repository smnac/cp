/*
28. Find the Index of the First Occurrence in a String
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
*/
class Solution {
    public int strStr(String haystack, String needle) {
        return KMPSearch(haystack,needle);
        
    }
    
    int KMPSearch(String txt,String pat)
        {
        int M=pat.length();
        int N=txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[]=new int[M];



        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);


            int i=0; // txt index
            int j=0; // pat index

            while((N-i)>=(M-j))
            {
                if(txt.charAt(i)==pat.charAt(j))
                {
                    i++;
                    j++;
                }
                if(j==M)
                {
                    return i-j;
                   // j=lps[j-1];
                }
                else if(i<N && txt.charAt(i)!=pat.charAt(j))
                {
                    if(j!=0)
                        j=lps[j-1];
                    else
                        i=i+1;
                }
            }

            return -1;

        }

    private void computeLPSArray(String pat, int M, int[] lps) {
            int j=0;
            int i=1;
            lps[0]=0;
            while(i<M)
            {
                if(pat.charAt(i)==pat.charAt(j)) {
                    lps[i] = j + 1;
                    i++;
                    j++;
                }

                else
                {
                    if(j!=0)
                        j=lps[j-1];
                    else
                    {
                        lps[i]=j;
                        i++;
                    }
                }
            }
    }
}
