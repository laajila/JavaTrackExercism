import java.util.*;

class Sieve {
    private int maxPrime;
    private Set<Integer> notprimes= new TreeSet<>();
    Sieve(int maxPrime) {
        this.maxPrime=maxPrime;
        for (int i = 2; i <= maxPrime; i++) {
            int notPrime;
            notPrime = 0;
            for (int j = 2; notPrime < maxPrime; j++) {
                notPrime=j*i;
                notprimes.add(notPrime);
            }
        }
    }

    List<Integer> getPrimes() {
        List<Integer> primes=new ArrayList<Integer>();
        for (int i = 2; i <=this.maxPrime ; i++) {
            if(!notprimes.contains(i)) primes.add(i);
        }
        return primes;
    }


}
