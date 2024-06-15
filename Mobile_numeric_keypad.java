class Solution {
    public long getCount(int n) {
        // Your code goes here
        if(n == 1) return 10;
        var map = getMap();
        long [][] dp = new long[10][n+1];
        for(int i = 0; i<10; i++) dp[i][1] = 1;
        for(int k = 2; k<=n; k++){
            for(int st = 0; st < 10; st++){
                int [] cur = map.get(st);
                long temp = 0;
                for(int j : cur){
                    temp += dp[j][k-1];
                }
                dp[st][k] = temp;
            }
        }
        long sum = 0;
        for(int i = 0; i<10; i++) sum += dp[i][n];
        return sum;
    }

    static Map<Integer, int []> getMap(){
        Map<Integer, int[]> res = new HashMap<>();
        res.put(0, new int [] {8, 0});
        res.put(1, new int [] {2, 4, 1});
        res.put(2, new int [] {1, 3, 5, 2});
        res.put(3, new int [] {2, 6, 3});
        res.put(4, new int [] {1, 5, 7, 4});
        res.put(5, new int [] {2, 4, 6, 8, 5});
        res.put(6, new int [] {3, 5, 9, 6});
        res.put(7, new int [] {4, 8, 7});
        res.put(8, new int [] {7, 5, 9, 0, 8});
        res.put(9, new int [] {6, 8, 9});
        return res;
    }
}
