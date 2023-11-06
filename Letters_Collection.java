class Solution{
      static List<int []> getQueries(int i, int j, int type, int n, int m){
        List<int []> list = new ArrayList<>();
        int im1 = i-1;
        int ip1 = i+1;
        int jm1 = j-1;
        int jp1 = j+1;
        int jm2 = j-2;
        int jp2 = j+2;
        int ip2 = i+2;
        int im2 = i-2;
        if(type == 1){
            if(validate.test(im1, n)){
                list.add(new int [] {im1, j});
                if(validate.test(jm1, m)) {
                    list.add(new int [] {im1, jm1});
                }
                if(validate.test(jp1, m)){
                    list.add(new int [] {im1, jp1});
                }
            }
            if(validate.test(ip1, n)){
                list.add(new int [] {ip1, j});
                if(validate.test(jm1, m)) list.add(new int [] {ip1, jm1});
                if(validate.test(jp1, m)) list.add(new int [] {ip1, jp1});
            }
            if(validate.test(jm1, m)) list.add(new int []{i, jm1});
            if(validate.test(jp1, m)) list.add(new int []{i, jp1});
        } else{
            if(validate.test(jm2, m)){
                if(validate.test(im2, n)) list.add(new int [] {im2, jm2});
                if(validate.test(im1, n)) list.add(new int [] {im1, jm2});
                if(validate.test(ip1, n)) list.add(new int [] {ip1, jm2});
                if(validate.test(ip2, n)) list.add(new int [] {ip2, jm2});
                list.add(new int [] {i, jm2});
            }
            if(validate.test(jp2, m)){
                if(validate.test(im2, n)) list.add(new int [] {im2, jp2});
                if(validate.test(im1, n)) list.add(new int [] {im1, jp2});
                if(validate.test(ip1, n)) list.add(new int [] {ip1, jp2});
                if(validate.test(ip2, n)) list.add(new int [] {ip2, jp2});
                list.add(new int [] {i, jp2});
            }
            if(validate.test(jm1, m)){
                if(validate.test(im2, n)) list.add(new int [] {im2, jm1});
                if(validate.test(ip2, n)) list.add(new int [] {ip2, jm1});
            }
            if(validate.test(jp1, m)){
                if(validate.test(im2, n)) list.add(new int [] {im2, jp1});
                if(validate.test(ip2, n)) list.add(new int [] {ip2, jp1});
            }
            if(validate.test(im2, n)) list.add(new int [] {im2, j});
            if(validate.test(ip2, n)) list.add(new int [] {ip2, j});
        }
        return list;
    }

    static class validate{
        static boolean test(int k1, int k2){
            return k1 >= 0 && k1<k2;
        }
    }
}
