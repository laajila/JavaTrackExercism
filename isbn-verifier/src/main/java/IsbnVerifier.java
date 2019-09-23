class IsbnVerifier {

    boolean isValid(String stringToVerify) {


        char[] numbers = stringToVerify.toCharArray();
        int sum = 0;
        for (int i = 0, k = 0; i < numbers.length && k < 10; i++) {
            if ((numbers[i] > '0' && numbers[i] < '9')) {
                sum = sum + ((k + 1) * Character.getNumericValue(numbers[i]));
                k++;
            } else if (numbers[i] == 'X') sum = sum + ((k + 1) * 10);
        }

        return sum % 11 == 0;


    }


}
