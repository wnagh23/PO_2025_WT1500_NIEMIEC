package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, Animal> animals = new HashMap<>();

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
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
}
