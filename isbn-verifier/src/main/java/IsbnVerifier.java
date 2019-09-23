import java.util.Arrays;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {


        char[] numbers = stringToVerify.toCharArray();

        Character[] ref = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int sum = 0;
        int k = 0;
        for (char number : numbers) {
            if (Arrays.asList(ref).contains(number)) {
                sum = sum + ((k + 1) * Character.getNumericValue(number));
                k++;
            } else if (number == 'X') {
                sum = sum + ((k + 1) * 10);
                k++;
            }
        }

        if (k != 10) return false;
        return sum % 11 == 0;


    }


}
