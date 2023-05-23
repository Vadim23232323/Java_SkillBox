import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        //FileOutputStream writer = new FileOutputStream("res/numbers.txt");

        //Клас для определения автоматического размера буфера
        PrintWriter writer = new PrintWriter("res/numbers.txt");

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};


        for (int regionCode = 1; regionCode < 100; regionCode++) {
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            StringBuilder builder = new StringBuilder();
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");

//                        builder.append("\n" + (firstLetter + padNumber(number, 3) +
//                                secondLetter + thirdLetter + padNumber(regionCode, 2)));

//                            Ручная установка размера буфера
//                            if (builder.length() > 1024) {
//                                writer.write(builder.toString().getBytes());
//                                builder = new StringBuilder();
//                            }
//                            Автоматическая установка размера буфера
                            writer.write(builder.toString());
                        }
                    }
                }
            }

        }

        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        if (padSize <= 0) {
            return numberStr;
        }

        StringBuilder paddedNumber = new StringBuilder(numberLength);
        for (int i = 0; i < padSize; i++) {
            paddedNumber.append('0');
        }
        paddedNumber.append(numberStr);

        return paddedNumber.toString();
    }
}
