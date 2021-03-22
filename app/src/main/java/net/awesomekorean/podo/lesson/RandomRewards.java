package net.awesomekorean.podo.lesson;

import java.util.Random;

public class RandomRewards {


    public static int randomRewards() {

        Random random = new Random();

        int reward1 = 4;    // 50%
        int reward2 = 6;   // 30%
        int reward3 = 8;   // 15%
        int reward4 = 10;   // 5%

        int reward = 0;

        int select = random.nextInt(100);
        System.out.println("select: " + select);

        if (select >= 0 && select <= 4) {
            reward = reward4;

        } else if (select >= 5 && select <= 19) {
            reward = reward3;

        } else if (select >= 20 && select <= 49) {
            reward = reward2;

        } else if (select >= 50 && select <= 99) {
            reward = reward1;

        }
        return reward;
    }
}
