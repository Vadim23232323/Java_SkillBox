import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        Pattern numberPhone = Pattern.compile("\\+\\d+");
        Pattern email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

//        if (components.length !=4 || components[3].length() != 13 || matcherNumberPhone.find() || matcherEmail.find()) {
//            throw new IllegalArgumentException("Неврное число или формат введенных данных!!! повторите попытку.");
//        }
        if (components.length !=4) {
            throw new IllegalArgumentException("Неврное число введенных данных!!! повторите попытку.");

        }
        else {
            Matcher matcherNumberPhone = numberPhone.matcher(components[3]);
            Matcher matcherEmail = email.matcher(components[2]);
            if (components[3].length() !=13 || !matcherNumberPhone.find() || !matcherEmail.find()) {
                throw new IllegalArgumentException("Неврное формат номера телефона или Email!!! повторите попытку.");
            }
            else {
                String name = components[0] + " " + components[1];
                storage.put(name, new Customer(name, components[3], components[2]));
                System.out.println("Запись успешно добавлена");
            }

        }
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}