import java.util.Arrays;

class Acronym {
    private String[] words;

    Acronym(String phrase) {
        words = phrase.toUpperCase().split(" ");
    }

    String get() {
        StringBuffer acronym = new StringBuffer();
        for (String x :
                words) {
            for (int i = 0; i < x.length(); i++) {

                if (x.contains("-")) {
                    String[] splittedX = x.split("-");
                    for (String y :
                            splittedX) {
                        if (y.charAt(i) >= 'A' && y.charAt(i) <= 'Z') {
                            acronym.append(y.charAt(i));
                        }
                    }
                    break;
                }
                if (x.charAt(i) >= 'A' && x.charAt(i) <= 'Z') {
                    acronym.append(x.charAt(i));
                    break;
                }
            }
        }
        return acronym.toString();
    }

}
