class Solution {
    boolean sameFreq(String s) {
        // code here
        int [] arr = new int [26];
        int n = s.length();
        for(int i = 0; i<n; i++){
            arr[s.charAt(i)-'a']++;
        }
        int f = -1, sec = -1, c1 = 0, c2 = 0;
        boolean res = true;
        for(int i = 0; i<26; i++){
            if(arr[i] != 0){
                if(f == -1 || f == arr[i]){
                    f = arr[i];
                    c1++;
                } else if(sec == -1 || sec == arr[i]){
                    sec = arr[i];
                    c2++;
                } else{
                    res = false;
                    break;
                }
            }
        }
        if(!res) return false;
        if(sec == -1) return true;
        if(c1 > 1 && c2 > 1) return false;
        return Math.abs(f-sec) <= 1;
    }
}
