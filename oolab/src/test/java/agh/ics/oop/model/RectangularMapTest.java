package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void rightPlace() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        assertTrue(map.place(animal));
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void placeOnOccupiedField() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal a1 = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        Animal a2 = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        map.place(a1);
        assertFalse(map.place(a2));
    }

    @Test
    void moveWorking() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        map.place(animal);

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(2, 3), animal.getPosition());
        assertEquals(animal, map.objectAt(new Vector2d(2, 3)));
    }

    @Test
    void isOccupiedWorking() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        map.place(animal);

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(5, 5)));
    }

    @Test
    void objectAtWorking() {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        map.place(animal);

        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
        assertNull(map.objectAt(new Vector2d(3, 3)));
    }
}
