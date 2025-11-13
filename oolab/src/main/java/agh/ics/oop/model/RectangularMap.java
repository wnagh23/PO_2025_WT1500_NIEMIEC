package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final MapVisualizer visualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        boolean inside =
                position.getX() >= 0 && position.getX() < width &&
                        position.getY() >= 0 && position.getY() < height;

        if (!inside) {
            return false;
        }

        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (!canMoveTo(position)) {
            return false;
        }
        animals.put(position, animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();

        animal.move(direction, this);

        Vector2d newPosition = animal.getPosition();

        if (!oldPosition.equals(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(
                new Vector2d(0, 0),
                new Vector2d(width - 1, height - 1)
        );
    }
}
