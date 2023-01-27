/*

https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

*/

public class Solution {
	public static double findNthRootOfM(int n, int m) {
		double low = 1;
		double high = m;

		while((high-low)>1e-6)
		{
			double mid = (low + high)/2.0;
			if(multiplyN(mid,n)<m)
			{
				low=mid;
			}
			else{
				high=mid;
			}
		}

		return low;
	}

	private static double multiplyN(double mid,int N)
	{ double ans=1.0;
		for(int i=1;i<=N;i++)
			ans=ans*mid;
		return ans;
	}
}
