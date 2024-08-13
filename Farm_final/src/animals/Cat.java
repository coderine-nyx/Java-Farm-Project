package animals;

public class Cat extends Animal {
    private String meow;

    public Cat(String name, int hunger, int age, String meow) {
        super(name, hunger, age);
        this.meow = meow;
    }

    @Override
    public String getType() {
        return "Katze";
    }
}
