import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import java.util.Scanner;

public class Array_list {
    String text = "������ ������� ������ �����, ��� ����� �����.";

    //������� 5.1 ����� ������� � �������� ������������������
    public void getArrayViceVersa() {
        String[] word = text.split(",?\\.?\\s+?");
        for (int i = word.length - 1; i >= 0; i--) {
            System.out.println("����� � " + i + ": " + word[i]);
        }
    }

    //������� 5.2 ������� ������ ���� float � ������������� 30 ��������� (�� 32 �� 40 ��������).
    public void getPatientsTemperature() {
        float[] patientsTemperature = new float[30];
        int countHealthy = 0;
        float averageTemperature = (float) 0.0;
        float maxTemperature = (float) 0.0;
        float minTemperature = (float) 0.0;

        for (int i = 0; i < patientsTemperature.length; i++) {
            patientsTemperature[i] = (float) (Math.round(((Math.random() * 8) + 32) * 10.0) / 10.0);
            minTemperature = patientsTemperature[0];
            System.out.println("����������� �������� " + i + ": " + patientsTemperature[i]);

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
        System.out.println("���������� �������� ��������� ��������: " + countHealthy);
        System.out.println("������� ����������� ��������� �� ��������: " + averageTemperature / patientsTemperature.length);
        System.out.println("������������ ����������� �������� �� ��������: " + maxTemperature);
        System.out.println("����������� ����������� �������� �� ��������: " + minTemperature);

    }

    //������� 5.3 ������� � ������� ������ ��������� ������ �����. ��� ��� ���������� � ������� ���������� ������� �� X.
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
                System.out.print("����� �������� �������: " + i + " " + j + " " );
            }
            System.out.println();
        }


    }
}
