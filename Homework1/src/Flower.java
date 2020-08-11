public class Flower {
    private String name;
    private int petals;
    private double price;

    public Flower(String name, int petals, double price){
        this.name = name;
        this.petals = petals;
        this.price = price;
    }
    public void setName(String name){ this.name = name; }
    public void setPetals(int petals){ this.petals = petals; }
    public void setPrice(double price){ this.price = price; }
    public String getName() { return name; }
    public int getPetals(){ return petals; }
    public double getPrice(){ return price; }

}
