public class LoaderNumberGenerator {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int numThreads = 5; // ���������� �������
        int maxNumber = 999; // ������������ �����
        char[] letters = {'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

        int regionCodesPerThread = (int) Math.ceil(99.0 / numThreads); // ���������� ��������� ����� �� ������ �����

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startRegionCode = i * regionCodesPerThread + 1;
            int endRegionCode = Math.min((i + 1) * regionCodesPerThread, 99);

            String outputFileName = "res/numbers_" + startRegionCode + "_" + endRegionCode + ".txt";

            NumberGenerator generator = new NumberGenerator(startRegionCode, endRegionCode, letters, maxNumber, outputFileName);

            threads[i] = new Thread(generator);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
