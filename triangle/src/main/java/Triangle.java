import java.util.Arrays;

class Triangle {
    private double[] sides={};

    Triangle(double side1, double side2, double side3) throws TriangleException {
        sides=new double[]{side1,side2,side3};
        Arrays.sort(sides);
        if(side1<=0 ||side2<=0||side3<=0) throw new TriangleException("a triangle can't have a side equal to 0.");
        //i dcan't calculate that the angles of this triangle sum is 180
        // but as a rule the biggesst side can't be bigger than the sum of the smaller sides
        // projectinng the smaller sides on the bigger shows this clearly
        if(this.sides[2]>=this.sides[1]+this.sides[0]) throw new TriangleException("a triangle can't have its bigger side superior to its inferior sides.");
    }

    boolean isEquilateral() {
        return this.sides[0]==this.sides[1] && this.sides[1]==this.sides[2];
    }

    boolean isIsosceles() {

        return this.sides[0]==this.sides[1] || this.sides[1]==this.sides[2];
    }

    boolean isScalene() {
        return this.sides[0]!=this.sides[1] && this.sides[1]!=this.sides[2] && this.sides[0]!=this.sides[2];
    }

}
