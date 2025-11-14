package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void placeWorking() {
        GrassField map = new GrassField(5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        assertTrue(map.place(animal));
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void placeOnOccupiedFieldByAnimal() {
        GrassField map = new GrassField(5);
        Animal a1 = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        Animal a2 = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        map.place(a1);
        assertFalse(map.place(a2));
    }

    @Test
    void moveWorking() {
        GrassField map = new GrassField(5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        map.place(animal);

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(2, 3), animal.getPosition());
        assertEquals(animal, map.objectAt(new Vector2d(2, 3)));
    }

    @Test
    void testIsOccupied() {
        GrassField map = new GrassField(5);
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(3, 4));
        map.place(animal);

        assertTrue(map.isOccupied(new Vector2d(3, 4)));
    }

}
