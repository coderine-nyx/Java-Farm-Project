package animals;

import java.util.ArrayList;
import java.util.List;

public class Chicken extends Animal {
    private int eggs;

    protected static List<Chicken> chickens = new ArrayList<>();

    public void doMoonwalk() {
        }

    public static List<Chicken> getChickens() {
        return chickens;
    }

    public Chicken(String name, int hunger, int age, int eggs) {
        super(name, hunger, age);
        this.eggs = eggs;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    @Override
    public String getType() {
        return "Huhn";
    }

    @Override
    public void discoMove() {
        System.out.println(getName() + " gönnt sich ein Bier an der Bar.");
    }

    @Override
    public int getDecibel() {
        return 10;
    }
}
