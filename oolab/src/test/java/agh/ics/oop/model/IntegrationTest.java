package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class IntegrationTest {

    @Test
    void animalPlacementAndMove() {
        WorldMap map = new RectangularMap(5, 5);

        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
        boolean placed = map.place(animal);

        assertTrue(placed);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(2, 3), animal.getPosition());
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    void simulationRun() {
        WorldMap map = new RectangularMap(5, 5);
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> moves = List.of(
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD
        );

        Simulation simulation = new Simulation(positions, moves, map);
        simulation.run();

        assertNotNull(map.objectAt(new Vector2d(3, 3)));
    }
}

