/*
165. Compare Version Numbers
https://leetcode.com/problems/compare-version-numbers/

*/

class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        
        //String test = "adarsha.ananda";
        //String[] t1=test.split("\\.");
        //System.out.println(t1[0]);
        int len=ver1.length>ver2.length?ver2.length:ver1.length;
        int index=0;
        for(int i=0;i<len;i++)
        {
            Integer num1=Integer.parseInt(ver1[i]);
            Integer num2=Integer.parseInt(ver2[i]);
           // System.out.println(num1+":"+num2);
            if(num1<num2)
                return -1;
            if(num1>num2)
                return 1;   
        }
        
        for(int i=len;i<ver1.length;i++){
            Integer num1=Integer.parseInt(ver1[i]);
            if(num1>0)
                return 1;
        }
        
        for(int i=len;i<ver2.length;i++){
            Integer num2=Integer.parseInt(ver2[i]);
            if(num2>0)
                return -1;
        }
        
        return 0;
            
        
    }
    
    
}
