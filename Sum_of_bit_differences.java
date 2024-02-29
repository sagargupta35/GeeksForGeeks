long sumBitDifferences(int[] arr, int n) {
        // code here
        long ans = 0;
        for(int i = 0; i<31; i++){
            int cur = 1 << i;
            int zero = 0, one = 0;
            for(int j = 0; j<n; j++){
                if((arr[j]&cur) != 0) one++;
                else zero++;
            }
            ans += ((long)zero*one);
        }
        return ans*2L;
    }
