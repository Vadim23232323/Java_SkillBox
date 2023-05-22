import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        // Подключение к Redis серверу
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        try {
            for (int i = 5; i < 10; i++) {
                jedis.set("" + i, "redis" + i);
                System.out.println(i);
            }
            // Выполнение операции записи в Redis


            System.out.println("Запись успешно выполнена в Redis базу данных.");
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении записи в Redis: " + e.getMessage());
        } finally {
            // Закрытие соединения с Redis
            jedis.close();
        }
    }
}
