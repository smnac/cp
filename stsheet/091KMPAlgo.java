
class KMP_String_Matching{
        void KMPSearch(String pat,String txt)
        {
        int M=pat.length();
        int N=txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[]=new int[M];



        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);
        for(int i=0;i<M;i++)
            System.out.print(lps[i]+" ");

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
                    System.out.println("Found pattern at index : "+(i-j));
                    j=lps[j-1];
                }
                else if(i<N && txt.charAt(i)!=pat.charAt(j))
                {
                    if(j!=0)
                        j=lps[j-1];
                    else
                        i=i+1;
                }
            }



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
class Solution
{
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}
