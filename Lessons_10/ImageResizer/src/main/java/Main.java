import java.io.File;

public class Main
{

    private static int NEW_WIDTH = 300;
    private static final String SRC_FOLDER = "data\\src\\";
    private static final String DST_FOLDER = "data\\dst\\";

    public static void main(String[] args)
    {
        File srcDir = new File(SRC_FOLDER);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        // --------------------------------------- ����� Thread ----------------------------------------------

//        int middle = files.length / 2;
//        File[] files1 = new File[middle];
//        System.arraycopy(files,0,files1,0,files1.length);
//        ImageResizer resazer1 = new ImageResizer(files1, NEW_WIDTH, DST_FOLDER, start);
//        resazer1.start();
//
//        File[] files2 = new File[files.length-middle];
//        System.arraycopy(files,middle,files2,0,files2.length);
//        ImageResizer resazer2 = new ImageResizer(files2, NEW_WIDTH, DST_FOLDER, start);
//        resazer2.start();

        // ------------------------------------- ��������� Runnable ----------------------------------------------

//        int middle = files.length / 2;
//        File[] files1 = new File[middle];
//        System.arraycopy(files,0,files1,0,files1.length);
//        ImageResizerInterface resazer1 = new ImageResizerInterface(files1, NEW_WIDTH, DST_FOLDER, start);
//        new Thread(resazer1).start();
//
//        File[] files2 = new File[files.length-middle];
//        System.arraycopy(files,middle,files2,0,files2.length);
//        ImageResizerInterface resazer2 = new ImageResizerInterface(files2, NEW_WIDTH, DST_FOLDER, start);
//        new Thread(resazer2).start();
//
//        new Thread(()->{
//            for (int i = 0; i < 990000; i++) {
//                System.out.println(i);
//            }
//        }).start();


        // ------------------------------------- ������� 11.1 ----------------------------------------------

        // �������� ���������� ���� ��
        int numOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("���������� ���� ����������: " + numOfCores);

        // �������� ������� �� ������� ���-�� ������ �� ���������� ����
        int remainder = files.length  % numOfCores;

        // ������������� ��������� ������ ����� ��������
        int[] filesToThreads = new int[numOfCores];
        // System.out.println("��������� �������: " + remainder);

        for(int i = 0; i < numOfCores; i++){
            filesToThreads[i] = files.length / numOfCores;
            System.out.println("�������� ������� filesToThreads " + "[" + i + "]: " + filesToThreads[i]);
            if (remainder > 0) {
                filesToThreads[i]++;
                remainder--;
            }
        }

        // �������� ������ ������ � ����� ��� ���������� ������� ������
        System.out.println("������ ������ filesToThreads: " + filesToThreads.length);
        int srcPos = 0;
        for(int i = 0; i < filesToThreads.length; i++) {
            File[] files1 = new File[filesToThreads[i]];
            System.arraycopy(files, srcPos, files1, 0, filesToThreads[i]);
            ImageResizer imageResizer = new ImageResizer(files1, NEW_WIDTH, DST_FOLDER, start);
            imageResizer.start();
            srcPos = srcPos + filesToThreads[i];
        }

    }
}
