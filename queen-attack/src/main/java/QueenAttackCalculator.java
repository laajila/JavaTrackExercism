class QueenAttackCalculator {
    private Queen sersei;
    private Queen brenda;

    QueenAttackCalculator(Queen one, Queen two) {
        if (one == null || two == null)
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (one.getX() == two.getX() && one.getY() == two.getY())
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        sersei = one;
        brenda = two;
    }

    boolean canQueensAttackOneAnother() {
        int distanceX = sersei.getX() - brenda.getX();
        int distanceY = sersei.getY() - brenda.getY();
        int addition=brenda.getX() + brenda.getY() - (sersei.getY()+sersei.getX()) ;
        return distanceX == 0 || distanceY == 0 || distanceX == distanceY || addition==0;
    }
}
