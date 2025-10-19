package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    static void main(String[] args) {

        System.out.println("System wystartowal");

        MoveDirection[] directions = OptionsParser.optionsParser(args);

        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
            }

        };
        System.out.println("System zakonczyl dzialanie");
    }



}


