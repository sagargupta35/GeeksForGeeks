class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		Integer [][] dp = new Integer[n][m];
        return maxDotProduct(a, b, n-1, m-1, dp);
	} 
	
	static int maxDotProduct(int [] a, int [] b, int st1, int st2, Integer [][] dp){
        if(st1 < 0 || st2 < 0) return 0;
        if(dp[st1][st2] != null) return dp[st1][st2];
        if(st1 == st2){
            return dp[st1][st2] = a[st1] *b[st2] + maxDotProduct(a, b, st1-1, st2-1, dp);
        }
        int with = maxDotProduct(a, b, st1-1, st2-1, dp) + a[st1] *b[st2];
        int without = maxDotProduct(a, b, st1-1, st2, dp);
        return dp[st1][st2] = Math.max(with, without);
    }
}
