package cp.interview;

import java.util.HashMap;
import java.util.Map;

/*
Youtube application on a Smart TV

A B C D
E F G H
I J K L
M N O P
Q R S T
U V W X
Y Z
SPACE CLEAR SEARCH
<<<<<<< HEAD
A->B-Z 
=======
>>>>>>> 3647604eeca12fd92c89a2e172c17854d1b4bd69

Write a function which returns minimum number of clicks
you will have to do in order to search for a term, given the following
constraints:
- Starting point is A
- You can move UP, DOWN, LEFT, RIGHT
- You will have to click the letter as well
eg:
input output
<<<<<<< HEAD
GOOGLE 19
WHATFIX 43 */
=======
WHATFIX 43 
*/
>>>>>>> 3647604eeca12fd92c89a2e172c17854d1b4bd69



public class Keyboard {

    static class Point
    {
        int x;
        int y;
        Point(int a,int b)
        {
            x=a;
            y=b;
        }
    }
    static int getMinDist(String str)
    {
        Map<Character,Point> hm = new HashMap<>();
        char c='A';
        for(int i=0;i<8;i++)
         for(int j=0;j<4;j++)
        hm.put(c++,new Point(i,j));

        int dist=0;
        Point prev=null;
        Point cur=null;
        for(int i=0;i<str.length();i++)
        {
            if(prev==null){
            cur=hm.get(str.charAt(i));
            dist=cur.x+cur.y;
            }
            else
            {
                cur=hm.get(str.charAt(i));

                dist=dist+Math.abs(prev.x-cur.x)+Math.abs(prev.y-cur.y);
            }
            prev=cur;

        }

        return dist+str.length();

    }

    public static void main(String[] args) {
        System.out.println(getMinDist("WHATFIX"));
    }
    
}

