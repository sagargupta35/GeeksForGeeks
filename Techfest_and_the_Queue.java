public static int [] sieve(long b){
        int [] sieve = new int [(int)b+1];
        for(int  i= 2; i<=b; i++){
            if(sieve[i] == 0){
                for(int j = i*i; j<=b; j+=i) sieve[j] = i;
            }
        }
        return sieve;
    }
