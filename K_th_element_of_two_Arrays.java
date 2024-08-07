class Solution {
    public long kthElement(int k, int[] arr1, int[] arr2) {
        // code here
        if(arr1.length >= k){
            if(arr1[k-1] <= arr2[0]) return arr1[k-1]; 
        } 
        if(arr2.length >= k){
            if(arr2[k-1] <= arr1[0]) return arr2[k-1];
        }
        long j = helper(k, arr1, arr2);
        if(j != -1) return j;
        return helper(k, arr2, arr1);
    }

    public long helper(int k, int [] arr1, int [] arr2){
        int lo = 0, hi = Math.min(arr1.length-1, k-1);
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            int rem = k - (mid+1);
            if(rem > arr2.length) lo = mid+1;
            else{
                if(rem == 0){
                    if(arr1[mid] <= arr2[0]) return arr1[mid];
                    else hi = mid-1;
                } else if(rem == arr2.length){
                    if(arr2[arr2.length-1] <= arr1[mid]) return arr1[mid];
                    else lo = mid+1;
                } else{
                    if(arr2[rem-1] <= arr1[mid] && arr2[rem] >= arr1[mid]) return arr1[mid];
                    else {
                        if(arr2[rem-1] > arr1[mid]) lo = mid+1;
                        else hi = mid-1;
                    }
                }
            }
        }
        return -1L;
    }
}
