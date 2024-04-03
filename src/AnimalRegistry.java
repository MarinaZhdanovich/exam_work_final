import Model.*;

import java.util.ArrayList;
import java.util.List;


public class AnimalRegistry {
    private List<Animals> animals;
    private Counter counter;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        counter = new Counter();
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
        counter.add();
    }

    public List<Animals> getAnimals() {
        return animals;
    }

    public int getCounterValue() {
        return counter.getValue();
    }

    public void displayAnimals() {
        System.out.println("Список всех животных:");
        for (Animals animal : animals) {
            System.out.println(animal);
        }
    }
}



