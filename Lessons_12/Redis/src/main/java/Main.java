import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        // ����������� � Redis �������
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        try {
            for (int i = 5; i < 10; i++) {
                jedis.set("" + i, "redis" + i);
                System.out.println(i);
            }
            // ���������� �������� ������ � Redis


            System.out.println("������ ������� ��������� � Redis ���� ������.");
        } catch (Exception e) {
            System.err.println("������ ��� ���������� ������ � Redis: " + e.getMessage());
        } finally {
            // �������� ���������� � Redis
            jedis.close();
        }
    }
}
