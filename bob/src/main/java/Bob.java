class Bob {
    private static String[] answers = {"Sure.", "Whoa, chill out!", "Calm down, I know what I'm doing!",
            "Fine. Be that way!", "Whatever."};

    String hey(String phrase) {
        if (!isYelling(phrase) && isQuestion(phrase)) return answers[0];
        else if (isYelling(phrase) && !isQuestion(phrase)) return answers[1];
        else if (isYelling(phrase) && isQuestion(phrase)) return answers[2];
        else if (phrase.replaceAll("[\\n\\t\\r ]", "").isEmpty()) return answers[3];
        else return answers[4];

    }

    boolean isYelling(String phrase) {
        if (!thereIsAletter(phrase)) return false;
        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) return false;
            }
        }

        return true;
    }
    boolean thereIsAletter(String phrase){
        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    boolean isQuestion(String phrase) {
        return phrase.endsWith("?");
    }
}