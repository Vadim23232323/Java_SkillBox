
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();

        Cat vasya = new Cat();

        System.out.println("��� �����: " + murka.getWeight());

        System.out.println("��� ����: " + vasya.getWeight());

        murka.feed(500.0);

        vasya.feed(900.0);

        System.out.println("��� ����� ����� �����: " + vasya.getWeight());

        System.out.println("��� ���� ����� �����: " + vasya.getWeight());

        while (vasya.getStatus()!="Exploded") {
            vasya.feed(400.0);
        }

        System.out.println("������ ����: " + vasya.getStatus());

        while (murka.getStatus() != "Dead") {
            murka.meow();
        }
            System.out.println("������ ����� : " + murka.getStatus());

//        Computer myNotebook = new Computer();
//
//        myNotebook.processor = new Processor();
//
//        myNotebook.processor.coreCount=4;
//
//        myNotebook.processor.frequency=2200;

    }
}