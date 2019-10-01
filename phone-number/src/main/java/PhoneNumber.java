import java.util.ArrayList;
import java.util.List;

class PhoneNumber {
    List<Integer> formattedNum = new ArrayList<Integer>();

    PhoneNumber(String Stringnum) {
        char[] charOfNum = Stringnum.toCharArray();
        String NotAllowedpunctuations="@:!";
        for (int i = 0; i < charOfNum.length; i++) {
            int number = Character.getNumericValue(charOfNum[i]);
            if (number >= 0 && number <= 9) formattedNum.add(number);
            else if (charOfNum[i] > 65) throw new IllegalArgumentException("letters not permitted");
            else if (NotAllowedpunctuations.contains(""+charOfNum[i]))
                throw new IllegalArgumentException("punctuations not permitted");
        }
        if (formattedNum.size() < 10) throw new IllegalArgumentException("incorrect number of digits");
        else if (formattedNum.size() > 11) throw new IllegalArgumentException("more than 11 digits");
        else if (formattedNum.size() == 11 && formattedNum.get(0) != 1)
            throw new IllegalArgumentException("11 digits must start with 1");
        if (formattedNum.get(formattedNum.size() - 10) == 0)
            throw new IllegalArgumentException("area code cannot start with zero");
        if (formattedNum.get(formattedNum.size() - 10) == 1)
            throw new IllegalArgumentException("area code cannot start with one");
        if ((formattedNum.get(formattedNum.size() - 7) == 0))
            throw new IllegalArgumentException("exchange code cannot start with zero");
        if ((formattedNum.get(formattedNum.size() - 7) == 1))
            throw new IllegalArgumentException("exchange code cannot start with one");

    }


    String getNumber() {
        System.out.println(formattedNum.toString());
        StringBuilder numString = new StringBuilder();
        for (int i = formattedNum.size()-10; i < formattedNum.size(); i++) {
            numString.append(formattedNum.get(i));
        }
        return numString.toString();
    }
}
