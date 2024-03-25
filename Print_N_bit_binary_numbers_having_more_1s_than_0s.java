class Solution {
    ArrayList<String> NBitBinary(int n) {
        // code here
        if(n == 1) return new ArrayList<>(List.of("1"));
        if(n == 2) return new ArrayList<>(List.of("11", "10"));
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sbr = new StringBuilder();
        boolean flag = true; //true -> 1;
        for(int i = 0; i<n; i++, flag = !flag){
            if(flag) sbr.append("1");
            else sbr.append("0");
        }
        NBitBinary(1, sbr, res, 1);
        return res;
    }
    
    static void NBitBinary(int st, StringBuilder sbr, ArrayList<String> res, int prev){
        if(st >= sbr.length()) return;
        if(st == sbr.length()-1){
            sbr.setCharAt(st, '1');
            res.add(sbr.toString());
            if(prev > 0){
                sbr.setCharAt(st, '0');
                res.add(sbr.toString());
            }
        }
        sbr.setCharAt(st, '1');
        NBitBinary(st+1, sbr, res, prev+1);
        if(prev > 0){
            sbr.setCharAt(st, '0');
            NBitBinary(st+1, sbr, res, prev-1);
        }
    }
}
