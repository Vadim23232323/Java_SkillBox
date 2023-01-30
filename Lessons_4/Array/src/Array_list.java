import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import java.util.Scanner;

public class Array_list {
    String text = "Каждый охотник желает знать, где сидит фазан.";

    //Задание 5.1 Вывод массива в обратной последовательности
    public void getArrayViceVersa() {
        String[] word = text.split(",?\\.?\\s+?");
        for (int i = word.length - 1; i >= 0; i--) {
            System.out.println("Слово № " + i + ": " + word[i]);
        }
    }

    //Задание 5.2 Создает массив типа float с температурами 30 пациентов (от 32 до 40 градусов).
    public void getPatientsTemperature() {
        float[] patientsTemperature = new float[30];
        int countHealthy = 0;
        float averageTemperature = (float) 0.0;
        float maxTemperature = (float) 0.0;
        float minTemperature = (float) 0.0;

        for (int i = 0; i < patientsTemperature.length; i++) {
            patientsTemperature[i] = (float) (Math.round(((Math.random() * 8) + 32) * 10.0) / 10.0);
            minTemperature = patientsTemperature[0];
            System.out.println("Температура пациента " + i + ": " + patientsTemperature[i]);

            if (patientsTemperature[i] >= 36.2 & patientsTemperature[i] <= 36.9) {
                countHealthy++;
            }
            if (patientsTemperature[i] > maxTemperature) {
                maxTemperature = patientsTemperature[i];
            }

            if (patientsTemperature[i] < minTemperature) {
                minTemperature = patientsTemperature[i];
            }
            averageTemperature = (averageTemperature + patientsTemperature[i]);
        }
        System.out.println("Количество здоровых пациентов больницы: " + countHealthy);
        System.out.println("Средняя температура пациентов по больнице: " + averageTemperature / patientsTemperature.length);
        System.out.println("Максимальная температура пациента по больнице: " + maxTemperature);
        System.out.println("Минимальная температура пациента по больнице: " + minTemperature);

    }

    //Задание 5.3 Создает с помощью циклов двумерный массив строк. При его распечатке в консоли выводиться крестик из X.
    public void getX() {
        String[] []  x = new String[7] [7];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (i == j || x.length - i - 1 == j)
                    x [i] [j] = "X";
                else
                    x [i] [j] = " ";
            }
            x [i] [i] = "X";
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j] + " " );
            }
            System.out.println();
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print("Номер элемента массива: " + i + " " + j + " " );
            }
            System.out.println();
        }


    }
}
