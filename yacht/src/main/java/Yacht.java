import java.util.Arrays;

class Yacht {
    int[] dice;
    YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        if (yachtCategory == YachtCategory.YACHT) return yacht(dice);
        if (yachtCategory == YachtCategory.ONES) return sumSameNumbers(dice,1);
        if (yachtCategory == YachtCategory.TWOS) return  sumSameNumbers(dice,2);
        if (yachtCategory == YachtCategory.THREES) return sumSameNumbers(dice,3);
        if (yachtCategory == YachtCategory.FOURS) return sumSameNumbers(dice,4) ;
        if (yachtCategory == YachtCategory.FIVES)  return sumSameNumbers(dice,5);
        if (yachtCategory == YachtCategory.SIXES) return sumSameNumbers(dice,6);
        if (yachtCategory == YachtCategory.FULL_HOUSE) return sumFull(dice);
        if (yachtCategory == YachtCategory.FOUR_OF_A_KIND) return sum4(dice);
        if (yachtCategory == YachtCategory.LITTLE_STRAIGHT) return littleStraight(dice);
        if (yachtCategory == YachtCategory.BIG_STRAIGHT) return bigStraight(dice);
        if (yachtCategory == YachtCategory.CHOICE) return sumAll(dice);
        return 0;

    }

    int sumSameNumbers(int[] numbers,int a){
        int sum=0;
        for (int x :
                numbers) {
            if (x == a) sum += x;
        }
        return sum;
    }

    int sumFull(int[] numbers){
        Arrays.sort(numbers);
        System.out.println(sumAll(numbers));
        if((numbers[0]==numbers[1] && numbers[4]==numbers[3]) && (numbers[2]==numbers[0] || numbers[2]==numbers[4])){
            return sumAll(numbers);
        }
        return 0;


    }
    int sum4(int[] numbers){
        Arrays.sort(numbers);

        if(numbers[0]!=numbers[1] && numbers[3]!=numbers[4]) return 0;
        if(numbers[2]!=numbers[3]) return 0;
        return numbers[2]*4;
    }

    int littleStraight(int[] numbers){
        Arrays.sort(numbers);
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]!=i+1) return 0;
        }
        return 30;
    }

    int bigStraight(int[] numbers){
        Arrays.sort(numbers);
        for (int i = 0; i <numbers.length ; i++) {
            if(numbers[i]!=i+2) return 0;
        }
        return 30;
    }

    int sumAll(int[] numbers){
        int sum=0;
        for (int x:
             numbers) {
            sum+=x;
        }
        return sum;
    }

    int yacht(int [] numbers){
        for (int i = 1; i <numbers.length ; i++) {
            if(numbers[i]!=numbers[0]) return 0;
        }
        return 50;
    }



}
