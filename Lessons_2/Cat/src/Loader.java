
public class Loader
{
    public static void main(String[] args)
    {

        // Lessons 1
        Cat murka = new Cat();

        Cat vasya = new Cat();

        System.out.println("Вес Мурки: " + murka.getWeight());

        System.out.println("Вес Васи: " + vasya.getWeight());

        murka.feed(500.0);

        vasya.feed(900.0);

        System.out.println("Вес Мурки после обеда: " + murka.getWeight());

        System.out.println("Вес Васи после обеда: " + vasya.getWeight());

        while (vasya.getStatus()!="Exploded") {
            System.out.println("Вася ест: ");
            vasya.feed(400.0);

        }

        System.out.println("Статус Васи: " + vasya.getStatus());

        while (murka.getStatus() != "Dead") {
            murka.meow();
        }
            System.out.println("Статус Мурки : " + murka.getStatus());


        // ############################################################################################################
        // Lessons 2
        System.out.println("Вес Мурки до похода в туалет: " + murka.getWeight());

        murka.goToTheToilet();

        System.out.println("Вес Мурки после похода в туалет: " + murka.getWeight());

        murka.feed(300.0);
        murka.feed(200.0);
        murka.feed(100.0);
        murka.mealAmount();




//        Computer myNotebook = new Computer();
//
//        myNotebook.processor = new Processor();
//
//        myNotebook.processor.coreCount=4;
//
//        myNotebook.processor.frequency=2200;

    }
}