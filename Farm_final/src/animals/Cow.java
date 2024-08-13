package animals;

import java.util.ArrayList;
import java.util.List;

public class Cow extends Animal {
    private int milk;

    protected static List<Cow> cows = new ArrayList<>();

    public void discoMove() {
        System.out.println(getName() + " geht ab und schreit Mooo Whooooo!");
    }

    public static List<Cow> getCows() {
        return cows;
    }

    public Cow(String name, int hunger, int age, int milk) {
        super(name, hunger, age);
        this.milk = milk;
    }

    @Override
    public void feed(int food) {
        super.feed(food / 2);
        milk++;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    @Override
    public String getType() {
        return "Kuh";
    }

    @Override
    public int getDecibel() {
        return 20;
    }
}
