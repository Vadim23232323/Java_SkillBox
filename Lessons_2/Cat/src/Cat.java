
public class Cat
{
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private String color;
    private double amountMeel;
    public static int count = 0;
    public static final int COUNT_EYE = 2;
    public static final double MIN_WEIGT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;



    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }
    public Cat (Double weight) {

        this.weight = weight;
    }

    public void setColor(String color) {
        this.color=color;
    }public String getColor() {
        return color;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        System.out.println("Feed");
        amountMeel=amountMeel+amount;
    }

    public Double mealAmount()
    {
        System.out.println("Cумма съеденной еды " + amountMeel);
        return amountMeel;
    }


    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {

        return weight;
    }

    public void goToTheToilet()
    {
        weight = weight - 35;
        System.out.println("Cat cходил в туалет ");
    }

    public void setCatColorTypes(CatСolorTypes type)
    {

    }
    public String getStatus()
    {
        if(weight < MIN_WEIGT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public static Integer getCount()
    {
        System.out.println("Количество котов: " + count);
        return count;
    }
}