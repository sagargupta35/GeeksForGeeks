int [] prePro = new int [arr.length];
        int n = arr.length;
        int preMin = arr[0], preMax = arr[0], i = 1;
        while (i < n){
            preMax = Math.max(arr[i], preMax);
            prePro[i] = Math.max(prePro[i-1], preMax-preMin);
            if(preMin > arr[i]){
                preMax = arr[i];
                preMin = arr[i];
            }
            i++;
        }
        int [] sufPro = new int [n];
        int sufMax = arr[n-1];
        int sufMin = arr[n-1];
        i = n-2;
        while (i >= 0){
            sufMin = Math.min(sufMin, arr[i]);
            sufPro[i] = Math.max(sufPro[i+1], sufMax-sufMin);
            if(sufMax < arr[i]){
                sufMax = arr[i];
                sufMin = arr[i];
            }
            i--;
        }
        int max = sufPro[0];
        i = 1;
        while (i < n){
            max = Math.max(prePro[i-1]+sufPro[i], max);
            i++;
        }
