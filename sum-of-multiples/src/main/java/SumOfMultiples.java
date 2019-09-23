import java.util.Set;
import java.util.TreeSet;

class SumOfMultiples {
    int [] set;
    int number;

    SumOfMultiples(int number, int[] set) {
        this.set=set;
        this.number=number;
    }

    int getSum() {
        Set<Integer> uniqueMultiples = new TreeSet<Integer>();
        int sum=0;

        for (int x:
             this.set) {
            int mul=x;
            for (int i = 1; mul<number && x!=0; i++) {
                uniqueMultiples.add(mul);
                mul=x*i;
            }
        }

        for(Integer a : uniqueMultiples) {
            sum=sum+a;
        }
      return sum;
    }



}
