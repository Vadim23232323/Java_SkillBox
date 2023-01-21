import com.skillbox.airport.Airport;

public class Airportblr {

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        System.out.println("Модели самолетов в аиропорте: " + airport.getAllAircrafts());

        System.out.println("Количество самолетов в аиропорте: " + airport.getAllAircrafts().size());



    }

}
