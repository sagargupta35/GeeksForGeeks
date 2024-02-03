class Solution
{
   long DecimalValue(Node head)
   {
 	    if(head == null) return 0;
        long val = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        while (head != null){
            val = ((val*2) + head.data)%mod;
            head = head.next;
        }
        return val;
   }
}
