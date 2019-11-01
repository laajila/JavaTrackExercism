import java.util.*;

class ParallelLetterFrequency {
    String input;
    Map<Integer, Integer> count;
    Character[] al = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    List<Character> alphabet = Arrays.asList(al);

    ParallelLetterFrequency(String input) {
        this.input = input;
        count = new HashMap<>();
    }
    Map<Integer, Integer> letterCounts() {
        for (char x :
                input.toLowerCase().toCharArray()) {
            if (alphabet.contains(x)) {
                if (count.containsKey((int) x)) {
                    count.put((int)x, count.get((int)x) + 1);
                } else {
                    count.put((int) x, 1);
                }
            }
        }
        return this.count;
    }
}
