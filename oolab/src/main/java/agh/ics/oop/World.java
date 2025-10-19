package agh.ics.oop;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class World {

    static void main(String[] args) {
        System.out.println("system wystartowal");
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case "l":
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case "r":
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                    default:
                        System.out.println("Prosze podac prawidlowy kierunek");
            }

        };
        System.out.println("system zakonczyl dzialanie");
    }



}


