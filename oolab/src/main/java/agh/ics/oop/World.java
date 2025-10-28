package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

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


        }

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection dir = MapDirection.EAST;

        System.out.println(dir);
        System.out.println(dir.next());
        System.out.println(dir.previous());
        System.out.println(dir.toUnitVector());

        System.out.println("System zakonczyl dzialanie");
    }


}


