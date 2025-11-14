package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final MapVisualizer visualizer = new MapVisualizer(this);

    public GrassField(int numberOfGrassFields) {
        int range = (int) Math.sqrt(numberOfGrassFields * 10);

        Random random = new Random();

        while (grasses.size() < numberOfGrassFields) {
            int x = random.nextInt(range + 1);
            int y = random.nextInt(range + 1);
            Vector2d position = new Vector2d(x, y);

            if (!grasses.containsKey(position)) {
                grasses.put(position, new Grass(position));
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {
            return true;
        }
        return grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement element = super.objectAt(position);
        if (element != null) {
            return element;
        }
        return grasses.get(position);
    }

    @Override
    public String toString() {
        if (animals.isEmpty() && grasses.isEmpty()) {
            return "";
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Vector2d position : animals.keySet()) {
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        for (Vector2d position : grasses.keySet()) {
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        Vector2d lowerLeft = new Vector2d(minX, minY);
        Vector2d upperRight = new Vector2d(maxX, maxY);

        return visualizer.draw(lowerLeft, upperRight);
    }

    public Collection<Animal> getAnimals() {
        return animals.values();
    }

    public Collection<Grass> getGrasses() {
        return grasses.values();
    }

    @Override
    public Collection<WorldElement> getElements() {
        List<WorldElement> list = new ArrayList<>(animals.values());
        list.addAll(grasses.values());
        return list;
    }
}
