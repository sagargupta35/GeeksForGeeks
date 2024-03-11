class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int i1 = 0, j1 = 0, i2 = mat2.length-1, j2 = mat2[0].length-1, res = 0;
        while ((i1< mat1.length && j1 < mat1[0].length) && (i2 >= 0 && j2 >= 0)){
            int k = mat1[i1][j1] + mat2[i2][j2];
            if(k == x){
                res++;
                j1++;
                if(j1 == mat1[0].length){
                    j1 = 0; i1++;
                }
            } else if(k < x){
                j1++;
                if(j1 == mat1[0].length){
                    j1 = 0; i1++;
                }
            } else {
                j2--;
                if(j2 < 0){
                    j2 = mat2[0].length-1;
                    i2--;
                }
            }
        }
        return res;
    }
}
