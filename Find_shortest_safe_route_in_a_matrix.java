class Solution {
    public static int findShortestPath(int[][] mat) {
        // code here
        int res = -1; //no path exists
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                mat[i][j] *= -2;
            }
        }
        for(int i = 0; i<mat.length; i++){
            int j = findShortestPath(mat, i, 0);
            if(j != -1){
                if(res == -1) res = j;
                else res = Math.min(res, j);
            }
        }
        return res;
    }

    static int findShortestPath(int [][] mat, int r, int c){
        if(!isValidMove(mat, r, c)) return -1;
        if(mat[r][c] != -2) return mat[r][c];
        mat[r][c] = -1;
        int j = mat[0].length;
        if(c == j-1) return 1;
        int down = findShortestPath(mat, r+1, c);
        int up = findShortestPath(mat, r-1, c);
        int right = findShortestPath(mat, r, c+1);
        int res = -2;
        List<Integer> list = new ArrayList<>();
        if (up != -1) list.add(up);
        if(right != -1) list.add(right);
        if(down != -1) list.add(down);
        for(int i = 0; i<list.size(); i++){
            if(res == -2) res = list.get(i);
            else res = Math.min(res, list.get(i));
        }
        return mat[r][c] = res+1;
    }

    static boolean isValidMove(int [][] mat, int r, int c){
        int i = mat.length, j = mat[0].length;
        if(r < 0 || r >= i) return false;
        if(c < 0 || c >= j) return false;
        if(mat[r][c] == 0) return false;
        if(r > 0){
            if(mat[r-1][c] == 0) return false;
        }
        if(r < i-1){
            if(mat[r+1][c] == 0) return false;
        }
        if(c == j-1) return true;
        return mat[r][c+1] != 0;
    }
}
