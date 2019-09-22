import java.util.Arrays;

class PigLatinTranslator {

    String translate(String word) {
        StringBuilder pigPhrase = new StringBuilder();
        if (word.contains(" ")) {
            for (String x:
                 word.split(" ")) {
                pigPhrase.append(translate(x)).append(" ");
            }
           return pigPhrase.toString().trim();
        } else {
            StringBuilder pigWord = new StringBuilder(word.toLowerCase());
            char[] consonant = "bcdfghjklmnpqrstvxz".toCharArray();
            char[] vowels = "aeiou".toCharArray();
            char[] wordsArray = word.toCharArray();
            //rule 1
            if (Arrays.binarySearch(vowels, wordsArray[0]) >= 0 || pigWord.substring(0, 2).equals("xr")
                    || pigWord.substring(0, 2).equals("yt")) {
                return pigWord.append("ay").toString();
            } else if (pigWord.charAt(0) == 'y') {
                return pigWord.deleteCharAt(0).append(wordsArray[0]).append("ay").toString();
            } else if (pigWord.substring(0, 2).equals("qu")) {
                return pigWord.delete(0, 2).append("qu").append("ay").toString();

            } else if (Arrays.binarySearch(consonant, wordsArray[0]) >= 0
                    && word.contains("y")
                    && word.charAt(word.length() - 1) != 'y') {
                String[] splitted = word.split("y");
                if (splitted.length > 2) {
                    return "y"
                            + String.join("y", Arrays.copyOfRange(splitted, 1, splitted.length - 1))
                            + splitted[0]
                            + "ay";
                } else if (splitted.length == 2) {
                    return "y" + splitted[1] + splitted[0] + "ay";
                } else {
                    return "y" + splitted[0] + "ay";
                }


            } else {
                int c = 0;
                for (int i = 0; i < wordsArray.length; i++) {
                    if (wordsArray[i] == 'q') {
                        if (i < wordsArray.length - 1 && wordsArray[i + 1] == 'u') {
                            c++;
                        }
                    }
                    if (Arrays.binarySearch(consonant, wordsArray[i]) >= 0) {
                        c++;
                    } else {
                        break;
                    }
                }
                return pigWord.delete(0, c).append(word, 0, c).append("ay").toString();

            }


        }
    }
}
