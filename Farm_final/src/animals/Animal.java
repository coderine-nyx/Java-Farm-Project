package animals;

public abstract class Animal implements HungerManager {
    protected String name;
    protected int hunger;
    protected int age;

    public Animal(String name, int hunger, int age) {
        this.name = name;
        this.hunger = hunger;
        this.age = age;
    }

    @Override
    public void feed(int food) {
        this.hunger -= food;
        if (this.hunger < 0) {
            this.hunger = 0;
        }
    }

    @Override
    public void hunger() {
        this.hunger += HungerManager.hungerValue;
    }

    public void increaseAge() {
        this.age++;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getAge() {
        return age;
    }

    public abstract String getType();

    public void discoMove() {
        // Abstrakte Methode, die in Unterklassen implementiert werden sollte
    }

    public int getDecibel() {
        return 0; // Abstrakte Methode, die in Unterklassen implementiert werden sollte
    }
}
