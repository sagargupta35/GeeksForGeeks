class Solution{
    static int countWays(int n, String s){
        // code here
        int [][][] dp = new int [n][n][];
        for(int i = 0; i<n; i++){
            int [] res = new int [2];
            if(s.charAt(i) == 'T') res[0]++;
            else res[1]++;
            dp[i][i] = res;
        }
        for(int l = 2; l<=n; l++){
            int max = n - (2*l) + 1;
            for(int i = 0; i<=max; i+=2){
                int j = i + (2*l) - 2;
                int [] res = new int [2];
                for (int k = i + 1; k < j; k += 2) {
                    int[] left = dp[i][k - 1];
                    int[] right = dp[k + 1][j];
                    int t = 0, f = 0;
                    switch (s.charAt(k)) {
                        case '|':
                            t = (left[0] * (right[0] + right[1]) + (right[0] * left[1])) % 1003;
                            f = ((left[1] * right[1])) % 1003;
                            break;
                        case '&':
                            t = (left[0] * right[0]) % 1003;
                            f = ((left[1] * (right[0] + right[1]) % 1003) % 1003 + (right[1] * left[0])) % 1003;
                            break;
                        default:
                            t = ((left[0] * right[1]) % 1003 + (left[1] * right[0]) % 1003) % 1003;
                            f = ((left[0] * right[0]) % 1003 + (left[1] * right[1]) % 1003) % 1003;
                            break;
                    }
                    res[0] += t;
                    res[1] += f;
                }
                res[0] %= 1003;
                res[1] %= 1003;
                dp[i][j] = res;
            }
        }
        return dp[0][n-1][0];
    }
}
