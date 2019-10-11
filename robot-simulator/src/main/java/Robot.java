class Robot {
    Orientation direction;
    GridPosition position;
    Robot(GridPosition position, Orientation direction) {
        this.direction=direction;
        this.position=position;
    }

    public GridPosition getGridPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return direction;
    }

    void turnRight(){
        if (direction==Orientation.NORTH) direction=Orientation.EAST;
        else if(direction==Orientation.EAST)direction=Orientation.SOUTH;
        else if(direction==Orientation.SOUTH) direction=Orientation.WEST;
        else if(direction==Orientation.WEST) direction=Orientation.NORTH;
    }
    void turnLeft(){
        if (direction==Orientation.NORTH) direction=Orientation.WEST;
        else if(direction==Orientation.WEST) direction=Orientation.SOUTH;
        else if(direction==Orientation.SOUTH)direction=Orientation.EAST;
        else if(direction==Orientation.EAST)direction=Orientation.NORTH;
    }

    void advance(){
        int x=position.getX(),y=position.getY();
        if (direction==Orientation.NORTH) y++;
        else if(direction==Orientation.WEST) x--;
        else if(direction==Orientation.SOUTH)y--;
        else if(direction==Orientation.EAST)x++;
        position=new GridPosition(x,y);
    }

    void simulate(String instructions){
        for (char move:
             instructions.toCharArray()) {
            if(move=='R') turnRight();
            else if(move=='L') turnLeft();
            else advance();

        }
    }
}
