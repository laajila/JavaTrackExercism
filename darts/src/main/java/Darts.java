import java.util.Random;

class Darts {
    private double radius;

    Darts(double x, double y) {
        radius = Math.sqrt(x * x + y * y);
    }

    int score() {
        if (radius <= 1.0) {
            return 10;
        }
        if (radius <= 5.0) {
            return 5;
        }
        if (radius <= 10.0) {
            return 1;
        }
        return 0;
    }

}
