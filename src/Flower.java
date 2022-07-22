public class Flower {
    private String name;
    private int numerOfPetals;
    private float price;

    Flower(String name, int numerOfPetals, float price) {
        this.name = name;
        this.numerOfPetals = numerOfPetals;
        this.price = price;
        this.fuckSomeBigAss();
    }

    public void printFLower() {
        System.out.println("Name " + this.name);
        System.out.println("Number of petals " + this.numerOfPetals);
        System.out.println("Price " + this.price);
    }

    private void fuckSomeBigAss() {
        this.name = "fuck and tighten Bubble ass";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumerOfPetals(int numerOfPetals) {
        this.numerOfPetals = numerOfPetals;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getNumerOfPetals() {
        return numerOfPetals;
    }

    public float getPrice() {
        return price;
    }
}
