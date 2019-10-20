class Frame {
    private int roll1 = 0;
    private int  roll2 = 0;
    private int lastThrow=0;
    private String type;
    private int score;

    Frame(int roll1, int roll2) {
        if (roll1 > 10 && roll2 > 10) throw new IllegalStateException("Pin count exceeds pins on the lane");
        if (roll1 < 0 && roll2 < 0) throw new IllegalStateException("Negative roll is invalid");
        this.roll1 = roll1;
        this.roll2 = roll2;
        if (roll1 == 10) {
            this.type = "strike";
            score=10;
        } else if (roll1 + roll2 == 10) {
            this.type = "spare";
            score=10;
        } else {
            this.type = "open";
            score=roll1 + roll2;
            if (roll1 + roll2 > 10) throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
    }

    int getRoll1(){
        return this.roll1;
    }
    int getRoll2(){
       return this.roll2;
    }

    public void addToLastThrow(int lastThrow) {
        this.lastThrow =this.lastThrow+ lastThrow;
    }

    public int getLastThrow() {
        return lastThrow;
    }

    public int getScore() {
        return score;
    }

    String getType(){
        return this.type;
    }
}