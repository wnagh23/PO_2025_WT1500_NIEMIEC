package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalSimulationTest {

    @Test
    void animalOrientationAfterTurns() {
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getDirection());
    }

    @Test
    void animalPositionAfterMoves() {
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        animal.move(MoveDirection.RIGHT); // teraz EAST
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 3), animal.getPosition());

        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    void animalStaysInsideBoundaries() {
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2, 4));

        animal.move(MoveDirection.FORWARD); // (2,5) – poza mapą, nie powinien się ruszyć
        assertEquals(new Vector2d(2, 4), animal.getPosition());

        animal.move(MoveDirection.RIGHT); // EAST
        animal.move(MoveDirection.FORWARD); // (3,4) – OK
        assertEquals(new Vector2d(3, 4), animal.getPosition());
    }

    @Test
    void optionsParserCorrectInput() {
        String[] args = {"f", "b", "r", "l"};
        var result = OptionsParser.optionsParser(args);

        assertEquals(List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        ), result);
    }

    @Test
    void optionsParserIncorrectInput() {
        String[] args = {"f", "x", "left", "b"};
        var result = OptionsParser.optionsParser(args);

        assertEquals(List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        ), result);
    }




}


