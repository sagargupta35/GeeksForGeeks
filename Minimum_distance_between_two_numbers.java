    static int minDist(int [] arr, int n, int x, int y) {
        // code here
        int min = Integer.MAX_VALUE;
        List<Integer> xArr = new ArrayList<>();
        List<Integer> yArr = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(arr[i] == x) xArr.add(i);
            else if(arr[i] == y) yArr.add(i);
        }

        for(int i = 0, j = 0; i<xArr.size() && j < yArr.size();){
            if(xArr.get(i) < yArr.get(j)){
                min = Math.min(Math.abs(xArr.get(i++)-yArr.get(j)), min);
            }else if(xArr.get(i) > yArr.get(j)){
                min = Math.min(Math.abs(xArr.get(i)-yArr.get(j++)), min);
            }
        }

        for (Integer integer : xArr) {
            min = Math.min(min, Math.abs(integer - yArr.get(yArr.size() - 1)));
        }

        for (Integer integer : yArr) {
            min = Math.min(min, Math.abs(integer - xArr.get(xArr.size() - 1)));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
