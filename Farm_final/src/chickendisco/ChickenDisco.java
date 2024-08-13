package chickendisco;

import animals.Animal;
import java.util.ArrayList;
import java.util.List;

public class ChickenDisco implements Disco {
    private int decibel = 0;
    private List<Animal> animals = new ArrayList<>();

    @Override
    public void enter(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void getStarted() {
        checkDecibel();
        for (Animal animal : animals) {
            animal.discoMove();
            decibel += animal.getDecibel();
        }
        checkDecibel();
    }

    private void checkDecibel() {
        if (decibel >= 100) {
            System.out.println("Die Polizei kommt vorbei und konfisziert die Anlage - die Party ist vorbei!");
        } else if (decibel >= 80) {
            System.out.println("Die Polizei kommt zum zweiten mal und droht, die Party aufzulösen");
        } else if (decibel >= 60) {
            System.out.println("Erster Polizeibesuch, es gibt eine Verwarnung");
        }
    }


    @Override
    public void dance() {
        for (Animal animal : animals) {
            animal.discoMove();
        }
    }
}
