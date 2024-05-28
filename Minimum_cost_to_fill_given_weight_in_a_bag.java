class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int [] dp = new int [w+1];
        for(int i = 1; i<=w; i++){
            dp[i] = cost[0]*i;
        }
        for(int i = 1; i<n; i++){
            int [] temp = new int [w+1];
            for(int prev = 1; prev <= w; prev++){
                int notTaken = dp[prev];
                int taken = Integer.MAX_VALUE;
                if((i+1) <= prev){
                    taken = cost[i] + temp[prev - (i+1)];
                }
                temp[prev] = Math.min(taken, notTaken);
            }
            dp = temp;
        }
        return dp[w];
    }
}
