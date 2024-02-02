class Solution
{
    int atoi(String s) {
	// Your code here
	boolean flag = s.charAt(0) == '-';
        boolean yes = true;
        int res = flag ? 0 : s.charAt(0)-'0';
        for(int i = 1; i<s.length(); i++){
            res *= 10;
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                yes = false;
                break;
            }
            res += s.charAt(i)-'0';
        }
        return yes ? (flag ? -1*res : res) : -1;
    }
}
