import java.util.*;

class Solution{
    public List<Integer> pattern(int n){
        // code here
        List<Integer> list = new ArrayList<>();
        if(n <= 0){
            list.add(n);
            return list;
        }
        list.add(n);
        patternRecurrsion(n-5, list, n, true);
        return list;
    }
    
    public void patternRecurrsion(int n, List<Integer> list, int real, boolean flag){
        if(n == real) {
            list.add(n);
            return;
        }
        list.add(n);
        if(n <= 0 && flag) flag = false;
        patternRecurrsion(flag ? n-5 : n+5, list, real, flag);
    }
}
