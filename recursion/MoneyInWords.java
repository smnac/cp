//273. Integer to English Words

class Solution {
    Map<Integer,String> hm ;
    public String numberToWords(int num) {
        hm = new HashMap<>();
        
       hm.put(0, "Zero");
       hm.put(1, "One");
       hm.put(2, "Two");
       hm.put(3, "Three");
       hm.put(4, "Four");
       hm.put(5, "Five");
       hm.put(6, "Six");
       hm.put(7, "Seven");
       hm.put(8, "Eight");
       hm.put(9, "Nine");
       hm.put(10, "Ten");
       hm.put(11, "Eleven");
       hm.put(12, "Twelve");
       hm.put(13, "Thirteen");
       hm.put(14, "Fourteen");
       hm.put(15, "Fifteen");
       hm.put(16, "Sixteen");
       hm.put(17, "Seventeen");
       hm.put(18, "Eighteen");
       hm.put(19, "Nineteen");
       hm.put(20, "Twenty");
       hm.put(30, "Thirty");
       hm.put(40, "Forty");
       hm.put(50, "Fifty");
       hm.put(60, "Sixty");
       hm.put(70, "Seventy");
       hm.put(80, "Eighty");
       hm.put(90, "Ninety");
        
        if(hm.containsKey(num))
            return hm.get(num);
        
        StringBuilder sb=new StringBuilder();
        helper(num,sb);
        
        return sb.toString().trim();
        
        
    }
    
    void helper(int num, StringBuilder sb)
    {
        if(num==0)
            return;
        else if(num<20)
        {
            sb.append(hm.get(num)).append(" ");
        }
        else if(num<100)
        {
            sb.append(hm.get(num-num%10)).append(" ");
            helper(num%10,sb);
        }
        
        else if(num<1000)
        {
          splitAndProcess(num,sb,"Hundred ",100);  
        }
        
        else if(num<1000000)
        {
          splitAndProcess(num,sb,"Thousand ",1000);  
        }
        
        else if(num<1000000000)
        {
          splitAndProcess(num,sb,"Million ",1000000);  
        }
        else //Billion and above
        {
          splitAndProcess(num,sb,"Billion ",1000000000);  
        }
    }
    
    void splitAndProcess(int num, StringBuilder sb, String suffix, int reducer)
    {
        helper(num/reducer,sb);
        sb.append(suffix);
        helper(num%reducer,sb);
    }
}
