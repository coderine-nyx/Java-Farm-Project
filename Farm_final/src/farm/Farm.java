package farm;

import animals.Animal;
import animals.Cat;
import animals.CollectResources;
import animals.Cow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Farm implements CollectResources {
    public List<Animal> animals = new ArrayList<>();
    private int roundCounter = 0;
    private Random random = new Random();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void printHunger() {
        for (Animal animal : animals) {
            System.out.println(animal.getType() + " " + animal.getName() + ": " + animal.getHunger());
        }
    }

    public void feedAllAnimals() {
        for (Animal animal : animals) {
            animal.feed(10);
        }
    }

    public Animal getAnimalByType(String type) {
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                return animal;
            }
        }
        return null;
    }

    public void increaseHunger() {
        for (Animal animal : animals) {
            animal.hunger();
        }
    }

    public void nextRound() {
        roundCounter++;
        if (roundCounter % 3 == 0) {
            increaseAgeOfAnimals();
        }

        if (random.nextInt(100) < 10) { // 10% Chance für Streunerkatze
            addAnimal(new Cat("Streuner", 50, 1, "Meow"));
            System.out.println("***************************************************\nEine Katze ist uns zugelaufen - sie ist nun Teil der Farm-Familie und hat auch ordentlich Bock auf die Disco!\n***************************************************");
        }
    }

    private void increaseAgeOfAnimals() {
        for (Animal animal : animals) {
            animal.increaseAge();
        }
    }

    @Override
    public void collectResources() {
        for (Animal animal : animals) {
            if (animal instanceof CollectResources) {
                ((CollectResources) animal).collectResources();
            }
        }
    }
}
