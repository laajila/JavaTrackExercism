import java.util.Arrays;

class LargestSeriesProductCalculator {
    char[] numbers;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.length() != 0 && inputNumber.length() <= 19) {
            try {
                Long.parseLong(inputNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
        this.numbers = inputNumber.toCharArray();
        System.out.println(Arrays.toString(numbers));

    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        //lentgth
        if (numbers.length < numberOfDigits)
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");
        if (numberOfDigits == 0) return 1;
        long max = 0;
        for (int i = 0; i <= numbers.length - numberOfDigits ; i++) {
                long product = 1;
                for (int j = i; j < numberOfDigits + i; j++) {
                    product = product * Character.getNumericValue(numbers[j]);
                }
            if (product > max) max = product;
        }

        return max;
    }

}

