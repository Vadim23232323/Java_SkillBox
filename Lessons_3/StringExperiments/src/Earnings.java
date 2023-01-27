import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Earnings {
    String text = "Вася заработал 6700 рублей, Петя - 76754 рубля, а Маша - 3324200 рублей";
    String earnings1, earnings2, earnings3, earningsV, earningsP, earningsM;
    int indexCommaV = 0, indexCommaM = 0, indexComma1 = 0, indexComma2 = 0, summaEarnings = 0;

    public void getEarnings() {

        indexCommaV = text.indexOf(",");

        earnings1 = text.substring(0, indexCommaV + 1);

        indexCommaM = text.lastIndexOf("Маша");

        earnings3 = text.substring(indexCommaM);

        earnings2 = text.substring(indexCommaV + 2, indexCommaM - 3);

        System.out.println("Заработок друзей: " + " \n " + earnings1 + " \n " + earnings2 + " \n " + earnings3);

        indexComma1 = earnings1.lastIndexOf(" рублей,");

        indexComma2 = earnings1.indexOf("л ");

        earningsV = earnings1.substring(indexComma2 + 2, indexComma1);

        indexComma1 = earnings2.lastIndexOf(" рубля,");

        indexComma2 = earnings2.indexOf("- ");

        earningsP = earnings2.substring(indexComma2 + 2, indexComma1);

        indexComma1 = earnings3.lastIndexOf(" рублей");

        indexComma2 = earnings3.indexOf("- ");

        earningsM = earnings3.substring(indexComma2 + 2, indexComma1);

        summaEarnings = Integer.valueOf(earningsV) + Integer.valueOf(earningsM) + +Integer.valueOf(earningsP);

        System.out.println("Сумма заработка всех друзей: " + summaEarnings);

    }

    public void getAmountEarnings() {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            summaEarnings += Integer.valueOf(matcher.group());

        }
        System.out.println("Сумма заработка всех людей: " + summaEarnings);
    }
}
