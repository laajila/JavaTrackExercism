public enum RomanLetters {
    I(1,"I"),
    V(5,"V"),
    X(10,"X"),
    L(50,"L"),
    C(100,"C"),
    D(500,"D"),
    M(1000,"M");

    private final int value;
    private final String letter;

    RomanLetters(int value,String letter){
        this.value=value;
        this.letter=letter;
    }


    public int getValue() {
        return value;
    }
    public String getLetter() {
        return letter;
    }
}
