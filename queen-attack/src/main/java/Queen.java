public class Queen {
    private int x;
    private int y;

    Queen(int x,int y){
        if(x<0) throw new IllegalArgumentException("Queen position must have positive row.");
        if(y<0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (x>7) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if(y>7) throw new IllegalArgumentException("Queen position must have column <= 7.");
        this.x=x;
        this.y=y;

    }

    int getX(){
        return this.x;
    }


    int getY(){
        return this.y;
    }

}
