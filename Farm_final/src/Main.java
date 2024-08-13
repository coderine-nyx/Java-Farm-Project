import animals.Chicken;
import animals.Cow;
import animals.Sheep;
import animals.Animal;
import chickendisco.ChickenDisco;
import farm.Farm;

import java.util.Scanner;

public class Main {
    static Farm farm = new Farm();
    static ChickenDisco chickenDisco = new ChickenDisco();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeFarm();

        while (true) {
            farm.printHunger();
            System.out.println("Tippe '1', um die Tiere zu füttern.");
            System.out.println("Mit '2' schickst du die Tiere in die Chicken Disco");

            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);

                if (choice == 1) {
                    handleFeeding();
                } else if (choice == 2) {
                    handleDisco();
                } else {
                    System.out.println("Bitte entscheide dich entweder für Option 1 oder Option 2!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bitte entscheide dich entweder für Option 1 oder Option 2!");
            }

            farm.increaseHunger();
            farm.nextRound();

            for (Animal animal : farm.animals) {
                if (animal.getHunger() >= 100) {
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n " + animal.getType() + " (" + animal.getName() + ") ist verhungert :(\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    return; // Beenden des Spiels, wenn ein Tier verhungert
                }
            }
        }
    }

    private static void handleFeeding() {
        System.out.print("Gib hier ein Tier an (Huhn, Kuh oder Schaf): ");
        String animalType = scanner.nextLine().trim().toLowerCase();

        Animal animal = farm.getAnimalByType(animalType);
        if (animal == null) {
            System.out.println("Kein passendes Tier gefunden!");
            return;
        }

        if (isHungry(animal)) {
            animal.feed(20);
        }
    }

    private static void handleDisco() {
        System.out.println("Geben Sie ein Tier an, das in die Disco gehen soll: ");
        String animalType = scanner.nextLine().trim().toLowerCase();

        Animal animal = farm.getAnimalByType(animalType);
        if (animal == null) {
            System.out.println("Kein passendes Tier gefunden!");
            return;
        }

        chickenDisco.enter(animal);
        chickenDisco.getStarted();
    }

    public static void initializeFarm() {
        Sheep sheep = new Sheep("Schafi", 60, 2, 10);
        Cow cow = new Cow("Mimi", 50, 4, 5);
        Chicken chicken = new Chicken("Werner", 50, 1, 3);

        farm.addAnimal(sheep);
        farm.addAnimal(cow);
        farm.addAnimal(chicken);
    }

    public static boolean isHungry(Animal animal) {
        if (animal.getHunger() >= 75) {
            System.out.println("Das Tier wird gefüttert!");
            return true;
        } else if (animal.getHunger() >= 50) {
            System.out.println("Das Tier ist nur ein bisschen hungrig! Soll es gefüttert werden?");
            String input = scanner.nextLine();
            return input.equalsIgnoreCase("Ja");
        } else {
            System.out.println("Das Tier kann nicht gefüttert werden!");
            return false;
        }
    }
}
