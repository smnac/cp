/*
Minimum Characters For Palindrome

https://www.codingninjas.com/codestudio/problems/893000?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0



*/

public class Solution {

    public static int minCharsforPalindrome(String s) {
        //Base Case        
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        //Looking for the largest palindromic string by iterating a pointer in reverse        
        int j = s.length() - 1;
        while (!isPalin(0, j, s)) {
            j--;
        }

        return s.length() - (j + 1);
    }

    //Function to check if the string is palindrome    
    public static boolean isPalin(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
