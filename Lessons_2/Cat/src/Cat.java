
public class Cat
{
    private double originWeight;
    public double weight;
    private double minWeight;
    private double maxWeight;
    private String color;
    private String name;
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
    public Cat (double weight, String name) {

        this.weight = weight;
        this.name = name;
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
        System.out.println("C???? ????????? ??? " + amountMeel);
        return amountMeel;
    }


    public void drink(Double amount)
    {
        weight = weight + amount;
    }


    public String getName()
    {
        return name;
    }
    public Double getWeight()
    {

        return weight;
    }

    public void goToTheToilet()
    {
        weight = weight - 35;
        System.out.println("Cat c????? ? ?????? ");
    }

    public void setCatColorTypes(Cat?olorTypes type)
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
        System.out.println("?????????? ?????: " + count);
        return count;
    }
}