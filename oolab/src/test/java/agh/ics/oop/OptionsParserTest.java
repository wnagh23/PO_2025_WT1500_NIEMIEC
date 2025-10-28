package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void inputInvalidArguments() {
        String[] input = {"f", "x", "r", "z", "b"};
        MoveDirection[] expected = {
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD
        };

        MoveDirection[] result = OptionsParser.optionsParser(input);
        assertArrayEquals(expected, result);
    }

}