package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> directions, WorldMap map) {
        this.map = map;
        this.animals = new ArrayList<>();
        this.directions = directions;

        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(MapDirection.NORTH, position);
            if (map.place(animal)) {
                this.animals.add(animal);
            } else {
                System.out.println("Nie można umieścić zwierzęcia");
            }
        }
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            MoveDirection direction = directions.get(i);
            int animalIndex = i % animals.size();
            Animal currentAnimal = animals.get(animalIndex);

            map.move(currentAnimal, direction);

            System.out.println(map);
        }
    }

}
