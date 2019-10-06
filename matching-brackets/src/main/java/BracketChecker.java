import java.util.Stack;

class BracketChecker {

    String sentence;

    BracketChecker(String sentence) {
this.sentence=sentence;
    }

    boolean isOpenning(char c) {
        return "([{".contains(Character.toString(c));
    }

    boolean isClosing(char c) {
        return "]})".contains(Character.toString(c));
    }

    char inverseBracket(char c) {
        if (c == ']') return '[';
        else if (c == ')') return '(';
        else if (c == '}') return '{';
        else if (c == '(') return ')';
        else if (c == '{') return '}';
        else return ']';
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
         Stack<Character> openingBrackets = new Stack<>();

        for (char c :
                sentence.toCharArray()) {
            if (isOpenning(c)) openingBrackets.push(c);
            if (isClosing(c)) {
                if(openingBrackets.size()==0) return false;
                if (inverseBracket(openingBrackets.pop())!=c) return false;
            }
        }
        return openingBrackets.size() == 0;
    }
}
