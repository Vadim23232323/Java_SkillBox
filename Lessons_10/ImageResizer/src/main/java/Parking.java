public class Parking {
    private int parkingSize  = 500;
    private int carCount = 0;

    public synchronized  void in()
    {
        if (parkingSize == carCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount++;
        System.out.println("���������� ������");
        System.out.println("��������� ����: " + (parkingSize - carCount));
        notify();
    }

    public synchronized void out(){
        if (carCount==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount--;
        System.out.println("���������� �������");
        System.out.println("��������� ����: " + (parkingSize - carCount));
        notify();
    }

}
