class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int max = 0;
        int [] suf = new int [n];
        suf[n-1] = a[n-1];
        for(int i = n-2; i>=0; i--) suf[i] = Math.max(suf[i+1], a[i]);
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while (n-left-1 > max){
            if(min > a[left]){
                min = a[left];
                if(left < n-1 && min <= suf[left+1]) {
                    boolean found = false;
                    int temp = right;
                    for (int i = n - 1; i >= right && i - left > max; i--) {
                        if (a[i] >= min) {
                            found = true;
                            temp = i;
                            break;
                        }
                    }
                    if (found) {
                        if (temp - left > max) {
                            max = temp - left;
                            right = temp;
                        }
                    }
                }
            }
            left++;
        }
        return max;
    }
}
