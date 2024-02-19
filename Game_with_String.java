class Solution{
    static int minValue(String s, int k){
        // code here
        int [] arr = new int [26];
        for(int i = 0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<Integer> tree = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<26; i++){
            if(arr[i] > 0) tree.add(arr[i]);
        }
        while (k-- > 0){
            Integer f = tree.poll();
            tree.add(f-1);
        }
        int sum = 0;
        for(int i : tree){
            sum += (i*i);
        }
        return sum;
    }
}
