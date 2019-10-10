class RomanNumeral {
    private String translationToRoman;

    RomanNumeral(int value) {
        StringBuilder romanValue = new StringBuilder();
        //1000->3000
        if (value >= RomanLetters.M.getValue()) {
            for (int i = 0; i < value / RomanLetters.M.getValue(); i++) {
                romanValue.append(RomanLetters.M.getLetter());
            }
            value = value % RomanLetters.M.getValue();
        }
        //900->999 pivot
        if (value >= 900) {
            romanValue.append("CM");
            value = value % 900;
        }
        //500->899
        if (value > RomanLetters.D.getValue()) {
            romanValue.append(RomanLetters.D.getLetter());
            value = value % 500;
        }
        //400->499 pivot
        if (value >= 400) {
            romanValue.append("CD");
            value = value % 400;
        }
        //100->399
        if (value >= RomanLetters.C.getValue()) {
            for (int i = 0; i < value / RomanLetters.C.getValue(); i++) {
                romanValue.append(RomanLetters.C.getLetter());
            }
            value = value % 100;
        }
        //90->99 pivot
        if (value >= 90) {
            romanValue.append("XC");
            value = value % 90;
        }
        //50->89
        if (value >= RomanLetters.L.getValue()) {
            romanValue.append(RomanLetters.L.getLetter());
            value = value % 50;
        }
        //40->49
        if (value >= 40) {
            romanValue.append("XL");
            value = value % 40;
        }
        if (value >= RomanLetters.X.getValue()) {
            for (int i = 0; i < value / RomanLetters.X.getValue(); i++) {
                romanValue.append(RomanLetters.X.getLetter());
            }
            value = value % 10;
        }
        //9 pivot
        if (value == 9) {
            romanValue.append("IX");
            value = value %9;
        }
        //5->8
        if (value >= RomanLetters.V.getValue()) {
            romanValue.append("V");
            value = value % RomanLetters.V.getValue();
        }
        //4 pivot
        if (value == 4) {
            romanValue.append("IV");
            value = value %4;
        }
        // 1->3
        for (int i = 0; i < value; i++) {
            romanValue.append(RomanLetters.I.getLetter());

        }

        this.translationToRoman = romanValue.toString();
    }

    String getRomanNumeral() {
        return this.translationToRoman;
    }
}
