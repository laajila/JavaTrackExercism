import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BaseConverter {
    private int base;
    private int[] number;

    BaseConverter(int base, int[] number) {
        if(base<2) throw new IllegalArgumentException("Bases must be at least 2.");
        this.base = base;
        for (int i:
             number) {
            if(i<0) throw new IllegalArgumentException("Digits may not be negative.");
            if(i>=base) throw new IllegalArgumentException("All digits must be strictly less than the base.");
        }
        this.number = number;

    }

    int[] convertToBase(int base) {
        int number = 0;
        int sizeOfnewNumber = 0;
        List<Integer> newNumbers = new ArrayList<Integer>();

        if(base<2) throw new IllegalArgumentException("Bases must be at least 2.");
        if(this.number.length==0) return new int[]{0};


        for (int i = 0; i <this.number.length; i++) {
            number += this.number[i] * Math.pow(this.base, this.number.length-1-i);
        }
        if(number==0) return new int[]{0};
        if(number==1) return new int[]{1};
        sizeOfnewNumber = (int) Math.floor(Math.log(number) / Math.log(base) - 1e-10);
        

        for (int i = sizeOfnewNumber ; i >= 0; i--) {
            newNumbers.add((int)(number/Math.pow(base,i)));
            number=(int)(number%Math.pow(base,i));
        }

        return newNumbers.stream().mapToInt(i->i).toArray();
    }


}