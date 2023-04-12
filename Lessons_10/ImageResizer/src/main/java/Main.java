import java.io.File;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    private static int NEW_WIDTH = 300;
    private static final String SRC_FOLDER = "data\\src\\";
    private static final String DST_FOLDER = "data\\dst\\";
    private static Vector<Double> numbers = new Vector<Double>();

    public static void main(String[] args) {
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
//        int numOfCores = Runtime.getRuntime().availableProcessors();
//        System.out.println("���������� ���� ����������: " + numOfCores);
//
//        // �������� ������� �� ������� ���-�� ������ �� ���������� ����
//        int remainder = files.length  % numOfCores;
//
//        // ������������� ��������� ������ ����� ��������
//        int[] filesToThreads = new int[numOfCores];
//        // System.out.println("��������� �������: " + remainder);
//
//        for(int i = 0; i < numOfCores; i++){
//            filesToThreads[i] = files.length / numOfCores;
//            System.out.println("�������� ������� filesToThreads " + "[" + i + "]: " + filesToThreads[i]);
//            if (remainder > 0) {
//                filesToThreads[i]++;
//                remainder--;
//            }
//        }
//
//        // �������� ������ ������ � ����� ��� ���������� ������� ������
//        System.out.println("������ ������ filesToThreads: " + filesToThreads.length);
//        int srcPos = 0;
//        for(int i = 0; i < filesToThreads.length; i++) {
//            File[] files1 = new File[filesToThreads[i]];
//            System.arraycopy(files, srcPos, files1, 0, filesToThreads[i]);
//            ImageResizer imageResizer = new ImageResizer(files1, NEW_WIDTH, DST_FOLDER, start);
//            imageResizer.start();
//            srcPos = srcPos + filesToThreads[i];
//        }


        // ------------------------------------- ��������� ���������� ----------------------------------------

//        for (int i = 0; i < 4; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 100000; j++) {
//                    ValueStorage.IncrementValue();
//                }
//                System.out.println(ValueStorage.getValue());
//            }).start();
//        }

        // ------------------------------------- �������� ����� Volatile ----------------------------------------

//        Task task = new Task();
//        new Thread(task).start();
//
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
//
//        task.stop();
//        System.out.println("Main: " + task.getCounterValue());


        // --------------------------------------- Synchronized-������ ----------------------------------------

//        ArrayList<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            threads.add(new Thread(Main::someHeavyMethod));
//        }
//        threads.forEach(t -> t.start());
//    }
//
//    private static synchronized void someHeavyMethod(){
//        for (int i = 0; i < 100000; i++) {
//            numbers.add(Math.random() / Math.random());
//        }
//        System.out.println(numbers.size());
//        numbers.clear();
//    }

        // --------------------------------------- Synchronized-����� ----------------------------------------

//        ArrayList<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            threads.add(new Thread(Main::someHeavyMethod));
//        }
//        threads.forEach(t -> t.start());
//    }
//
//    private static void someHeavyMethod(){
//        for (int i = 0; i < 10; i++) {
//            double value = Math.random() / Math.random();
//           synchronized (numbers) {
//               numbers.add(value);
//           }
//        }
//        System.out.println(numbers.size());
//        numbers.clear();
//    }

        // --------------------------------------- ������ Wait � Notify ----------------------------------------

//        Parking parking = new Parking();
//
//        Thread thread1 = new Thread(new Producer(parking));
//        Thread thread2 = new Thread(new Consumer(parking));
//
//        thread1.start();
//        thread2.start();

        // ------------- ���������������� ������ Vector, StringBuffer, Collections.synchronized  --------------

//        ArrayList<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            threads.add(new Thread(()->{
//                for (int j = 0; j < 100000; j++) {
//                    numbers.add(Math.random());
//                }
//                System.out.println(numbers.size());
//            }));
//        }
//        threads.forEach((Thread::start));


        // ------------------------------------ �������� ���������� � Deadlock  ---------------------------------------

//        final Friend vasya = new Friend("����");
//        final Friend vitya = new Friend("����");
//
//        new Thread(()->vasya.throwBallTo(vitya)).start();
//        new Thread(()->vitya.throwBallTo(vasya)).start();

        // ------------------------------------ ��������� Callable ---------------------------------------

//        Callable callable = ()->{
//            double sum = 0;
//            for (int i = 0; i < 1000; i++) {
//                sum+=Math.random();
//            }
//            if (sum/1000 <0.6) {
//                throw new IllegalArgumentException("������ �������� �����");
//            }
//          return sum / 1000;
//        };
//
//        FutureTask<Double> futureTask = new FutureTask<>(callable);
//        new Thread(futureTask).start();
//
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            System.out.println("����������: " + e.getMessage());
//        }


        // -------------------------------- Executors, Executor � ExecutorService, Shutdown -----------------------------------

        // Runnable
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> {
//            for (; ; ) {
//                System.out.println(Math.random());
//            }
//        });

        // Callable & Runnable
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        Future<Double> future = service.submit(()->{
//            double sum = 0;
//            for (int i=0; i< 100000; i++) {
//                sum+=Math.random();
//            }
//            return sum;
//        });
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        service.shutdown();

        // -------------------------------------- TheadPoolExecutor -----------------------------------------

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);



        // ----------------------------------- ScheduledExecutorService -------------------------------------

//        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
//
//        // ������ ������ ����� ��������� �����
//        service.schedule(()->{
//            for (;;){
//                System.out.println("Hi!");
//            }
//        }, 1, TimeUnit.MINUTES);
//
//        // ������ ������ ����� ��������� ����� � ��������� ����� ��������� �����
//        service.scheduleAtFixedRate(()->{
//            for (;;){
//                System.out.println("Hi!");
//            }
//            }, 1, 10,TimeUnit.MINUTES);
//
//        // ������ ������ ����� ����� ����� ���������� ������
//        service.scheduleWithFixedDelay(
//                ()->{
//                    for (;;){
//                        System.out.println("Hi!");
//                    }
//                }, 1, 10,TimeUnit.MINUTES
//        );


        // ------------------------------- ������������ � ���������� ������ -------------------------------------

        Thread thread = new Processor();
        Thread interrupter = new Thread(new Interrupter(thread));

        thread.start();
        interrupter.start();

    }
}