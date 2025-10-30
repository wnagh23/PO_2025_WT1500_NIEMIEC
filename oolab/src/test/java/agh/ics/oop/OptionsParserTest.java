package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsParserTest {

    @Test
    void inputInvalidArguments() {
        String[] input = {"f", "x", "r", "z", "b"};

        List<MoveDirection> expected = List.of(
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD
        );

        List<MoveDirection> result = OptionsParser.optionsParser(input);

        assertEquals(expected, result);
    }

}