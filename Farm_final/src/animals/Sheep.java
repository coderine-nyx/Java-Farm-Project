package animals;

import java.util.ArrayList;
import java.util.List;

public class Sheep extends Animal {
    private int wool;

    public Sheep(String name, int hunger, int age, int wool) {
        super(name, hunger, age);
        this.wool = wool;
    }

    protected static List<Sheep> sheeps = new ArrayList<>();

    public static List<Sheep> getSheeps() {
        return sheeps;
    }

    @Override
    public void feed(int food) {
        super.feed(food);
        wool++;
    }

    public int getWool() {
        return wool;
    }

    public void setWool(int wool) {
        this.wool = wool;
    }

    @Override
    public String getType() {
        return "Schaf";
    }

    @Override
    public void discoMove() {
        System.out.println(getName() + " packt den Moonwalk aus und slided über den Dancefloor!");
    }

    @Override
    public int getDecibel() {
        return 15;
    }
}
