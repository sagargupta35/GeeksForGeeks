class Solution
{
    public static int wordBreak(String s, ArrayList<String> arr)
    {
        //code here
        byte [] dp = new byte[s.length()];
        byte res = wordBreak(s, arr, "", 0, dp);
        if(res == -1) return 0;
        return 1;
    }
    
    public static byte wordBreak(String s, ArrayList<String> arr, String prev, int st, byte [] dp) {
        //code here
        if(st == s.length()-1){
            if(arr.contains(prev+s.charAt(st))) return 1;
            return -1;
        }
        if(prev.isEmpty() && dp[st] != 0) return dp[st];
        byte join = wordBreak(s, arr, prev+s.charAt(st), st+1, dp);
        byte notJoin = 0;
        if(arr.contains(prev+s.charAt(st))) notJoin = wordBreak(s, arr, "", st+1, dp);
        if(prev.isEmpty()) dp[st] = join;
        if(join == 1 || notJoin == 1) return 1;
        return -1;
    }
}
