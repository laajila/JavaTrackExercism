import java.util.*;

class WordProblemSolver {

    int solve(String question) {
        List<String> list = Arrays.asList(question.split(" "));
        List<String> words = new ArrayList<>(list);

        Stack<String> operations = new Stack<>();
        Stack<Integer> numbers = new Stack<>();


        //multiplied,plus, minus,divided
        if (!words.get(0).equals("What") || !words.get(1).equals("is"))
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        while (words.contains("by")) {
            words.remove("by");
        }
        while (words.contains("?")) {
            words.remove("?");
        }


        for (int i = 2; i < words.size(); i++) {
            if (i % 2 == 0) {
                int num;
                try {
                    num = Integer.parseInt(words.get(i).replace("?", ""));
                } catch (Exception e) {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }
                numbers.push(num);
            } else {
                String op = words.get(i);
                if (op.equals("multiplied") || op.equals("plus") || op.equals("minus")
                        || op.equals("divided")) {
                    operations.push(op);

                } else {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }
            }
            if (operations.size() == 1 && numbers.size() == 2) {
                String op = operations.pop();
                if (op.equals("multiplied")) numbers.push(numbers.pop() * numbers.pop());
                if (op.equals("plus")) numbers.push(numbers.pop() + numbers.pop());
                if (op.equals("minus")) {
                    int two = numbers.pop();
                    int one = numbers.pop();
                    numbers.push(one - two);
                } ;
                if (op.equals("divided")) {
                    int two = numbers.pop();
                    int one = numbers.pop();
                    numbers.push(one / two);
                }
            }


            if (operations.size() > 1 && numbers.size() > 2) {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }
        }

        if (operations.size() == 0 && numbers.size() == 1) return numbers.pop();
        else throw new IllegalArgumentException("I'm sorry, I don't understand the question!");

    }
}
