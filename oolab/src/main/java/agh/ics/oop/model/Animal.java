package agh.ics.oop.model;

public class Animal implements WorldElement {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(MapDirection initialOrientation,
                  Vector2d initialPosition){
        this.orientation = initialOrientation;
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return orientation;
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case EAST  -> "E";
            case SOUTH -> "S";
            case WEST  -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    void move(MoveDirection direction, MoveValidator validator){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.sub(orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)){
                    position = newPosition;
                }
            }
        }
    }


}
