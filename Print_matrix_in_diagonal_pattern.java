class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int [] arr = new int [n*n];
        int k = 0, i = 0, j = 0, max = (n-1)*2;
        if(n%2 == 0){
            while ((i+j) < max){
                arr[k++] = mat[i][j];
                int sum = i+j;
                if(i == 0){
                    if((sum&1) == 0) j++;
                    else{
                        i++; j--;
                    }
                } else if(j == 0){
                    if(sum == n-1) j++;
                    else if((sum&1) == 1) i++;
                    else {
                        i--;
                        j++;
                    }
                } else if(i == n-1){
                    if((sum & 1) == 0) i--;
                    j++;
                } else if(j == n-1){
                    if((sum&1) == 1) j--;
                    i++;
                } else{
                    if((sum & 1) == 1){
                        i++;
                        j--;
                    } else{
                        i--;
                        j++;
                    }
                }
            }
        } else {
            while ((i+j) < max){
                arr[k++] = mat[i][j];
                int sum = i+j;
                if( i == 0){
                    if((sum&1) == 0){
                        if(sum == n-1){
                            i++;
                        } else j++;
                    } else{
                        i++;
                        j--;
                    }
                } else if(j == 0){
                    if((sum&1) == 1) i++;
                    else{
                        i--;
                        j++;
                    }
                } else if(i == n-1){
                    if((sum&1) == 0) i--;
                    j++;
                } else if(j == n-1){
                    if((sum&1) == 1) j--;
                    i++;
                } else{
                    if((sum&1) == 0) {
                        i--;
                        j++;
                    } else{
                        i++;
                        j--;
                    }
                }
            }
        }
        arr[k] = mat[n-1][n-1];
        return arr;
    }
}
