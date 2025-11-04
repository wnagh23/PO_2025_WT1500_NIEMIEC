package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> directions;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> directions) {

        this.animals = new ArrayList<>();
        this.directions = directions;

        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(MapDirection.NORTH, position);
            this.animals.add(animal);
        }
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            MoveDirection direction = directions.get(i);
            int animalIndex = i % animals.size();
            Animal currentAnimal = animals.get(animalIndex);

            currentAnimal.move(direction);

            System.out.println("Zwierze " + animalIndex + ": " + currentAnimal.toString());
        }
    }

}
