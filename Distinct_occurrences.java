class Solution
{
    int  subsequenceCount(String s, String t)
    {
	// Your code here
	    int n = s.length(), m = t.length();
        Integer [][] dp = new Integer[n][m];
        int mod = (int)Math.pow(10, 9) + 7;
        return subsequenceCount(s, t, 0, 0, dp,mod);
    }
    
    int  subsequenceCount(String s, String t, int ss, int st, Integer [][] dp, int mod) {
        if(ss >= s.length() || st >= t.length()) return 0;
        if(s.length()-ss < t.length()-st) return 0;
        if(dp[ss][st] != null) return dp[ss][st];
        int without = subsequenceCount(s, t, ss+1, st, dp, mod);
        int with = 0;
        boolean b = s.charAt(ss) == t.charAt(st);
        if(b) with = subsequenceCount(s, t, ss+1, st+1, dp, mod);
        if(st == t.length()-1 && b) with++;
        dp[ss][st] = (with%mod + without%mod)%mod;
        return dp[ss][st];
    }
}
