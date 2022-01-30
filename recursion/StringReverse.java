package cp.recursion;

class StringReverse {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
     //   System.out.println(String.valueOf(s));
    }
    
    public void reverse(char[] s, int start,int end)
    {
        if(start>=end)
            return;
        char temp=s[start];
        s[start]=s[end];
        s[end]=temp;
        reverse(s,++start,--end);
    }
}
