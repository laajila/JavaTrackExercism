class PrimeCalculator {

    int nth(int nth)  {
        if(nth<=0) throw new IllegalArgumentException("");
        int count=0;
        int i=2;
        while(true){
            if(isPrime(i)){
                count++;
            }
            if (count==nth) return i;
            i++;
        }
    }

    private boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        int i=2;
        while(i*i<=n){
            if (n%i==0) return false;
            i++;
        }
        return true;
    }

}
