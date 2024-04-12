class Solution {
    static long pairAndSum(int n, long arr[]) {
        // code here
        int [] bits = new int [32];
        for(int j = 0; j<n; j++) {
            for (int i = 1, k = 0; i <= arr[j]; i *= 2, k++) {
                if ((arr[j] & i) > 0) bits[k]++;
            }
        }
        long sum = 0;
        int k = 0;
        for(long i = 1; k<bits.length; k++, i*=2){
            sum += getNc2(bits[k]) * i;
        }
        return sum;
    }
    
    static long getNc2(int n){
        if((n&1) == 0) return (long)n/2 * (n-1);
        return (long)n * (n-1)/2;
    }
}
