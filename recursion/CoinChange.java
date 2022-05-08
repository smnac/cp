import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = {1,5,7};
		int amt=100;
		
		int[] dp = new int[amt+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
		int ans=minCoins(amt,coins,dp);
		System.out.println(ans);
		

	}

	private static int minCoins(int amt, int[] coins,int[] dp) {
		
		if(amt==0)
			return 0;
		
		int mcc=Integer.MAX_VALUE;
		
		for(int coin:coins)
		{
			if(amt-coin>=0)
			{
				int cc=0;
				if(dp[amt-coin]!=-1) {
					cc=dp[amt-coin];
				}
				else
				{
						cc = minCoins(amt-coin,coins,dp);
				}
				
				if(cc!=Integer.MAX_VALUE && cc+1<mcc)
					mcc=cc+1;
				
			}
		}
		dp[amt]=mcc;
		return mcc;
	}

}
