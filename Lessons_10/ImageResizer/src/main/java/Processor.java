public class Processor extends Thread{


    @Override
    public void run() {
        double sum = 0;
        for(;;) {
            if (isInterrupted()) {
                sum += Math.random();
                break;
            }
        }
    }
}
