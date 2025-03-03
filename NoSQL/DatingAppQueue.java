import redis.clients.jedis.Jedis;

import java.util.Random;

public class DatingAppQueue {
    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String queueKey = "пользователя ";

        for (int i = 1; i <= 20; i++) {
            jedis.rpush(queueKey, "пользователя " + i);
        }

        Random random = new Random();

        while (true) {
            String userToDisplay = jedis.lpop(queueKey);
            System.out.println("На главной странице показываем " + userToDisplay);

            if (random.nextInt(10) == 0) {
                String userPaying = "пользователя " + (random.nextInt(20) + 1);
                System.out.println("> Пользователь " + userPaying + " оплатил платную услугу");

                jedis.lpush(queueKey, userPaying);
            } else {
                jedis.rpush(queueKey, userToDisplay);
            }

            Thread.sleep(1000);
        }
    }
}