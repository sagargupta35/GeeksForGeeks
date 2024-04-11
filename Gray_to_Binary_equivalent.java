class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        
        // Your code here
        if(n == 0) return 0;
        int pow = 1;
        while (pow <= n) pow *= 2;
        pow /= 2;
        int res = 0, prev = 0;
        while (pow > 0){
            if((prev == 0 && (pow&n) > 0) || (prev == 1 && (pow&n) == 0)){
                prev = 1;
                res ^= pow;
            } else prev = 0;
            pow /= 2;
        }
        return res;
    }
       
}
