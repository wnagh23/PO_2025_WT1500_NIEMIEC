package agh.ics.oop.model;

public class Animal {

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
        return "Zwierzak znajduje sie na pozycji " + position
                + " ustawiony jest w strone " + orientation;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (insideBoundaries(newPosition)){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.sub(orientation.toUnitVector());
                if (insideBoundaries(newPosition)){
                    position = newPosition;
                }
            }
        }
    }

    private boolean insideBoundaries(Vector2d position){
        return position.getX() >= 0 && position.getX() <= 4
                && position.getY() >= 0 && position.getY() <= 4;
    }
}
