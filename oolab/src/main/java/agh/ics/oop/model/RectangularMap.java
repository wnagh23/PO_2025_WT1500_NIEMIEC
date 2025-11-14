package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap extends AbstractWorldMap {

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
    public String toString() {
        return visualizer.draw(
                new Vector2d(0, 0),
                new Vector2d(width - 1, height - 1)
        );
    }
}
