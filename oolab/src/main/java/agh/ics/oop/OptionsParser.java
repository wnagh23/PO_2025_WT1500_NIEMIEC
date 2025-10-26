package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] optionsParser(String[] args) {

        MoveDirection[] directions = new MoveDirection[args.length];

        int correctCounter = 0;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "f":
                    directions[correctCounter] = MoveDirection.FORWARD;
                    correctCounter++;
                    break;
                case "b":
                    directions[correctCounter] = MoveDirection.BACKWARD;
                    correctCounter++;
                    break;
                case "l":
                    directions[correctCounter] = MoveDirection.LEFT;
                    correctCounter++;
                    break;
                case "r":
                    directions[correctCounter] = MoveDirection.RIGHT;
                    correctCounter++;
                    break;
            }

        }

        MoveDirection[] directionsFixed = Arrays.copyOfRange(directions, 0, correctCounter);

        return directionsFixed;

    }

}

