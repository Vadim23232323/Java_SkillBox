public class Main
{


    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.count);

        sumDigits(328);


    }


    public static Integer sumDigits(Integer number)
    {
        int summ=0;
        for (int i = 0; i < number.toString().length(); i++) {

            summ += Character.getNumericValue(number.toString().charAt(i));


        }
        System.out.println(summ);
        return number;

    }

}
