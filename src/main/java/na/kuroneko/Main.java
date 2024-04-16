package na.kuroneko;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ore = {"stone", "coal", "iron_ingot", "gold_ingot", "emerald", "diamond"};
        double[] randomList = {0.50, 0.20, 0.15, 0.10, 0.04, 0.01};
        int count = 0;

        Map<String, Integer> oreCount = new TreeMap<>();
        for (String o : ore) {
            oreCount.put(o, 0);
        }

        while (true) {
            int num = scanner.nextInt();
            if (num == 1) {
                count++;
                Random random = new Random();
                double randomValue = random.nextDouble();

                double cumulativeProbability = 0.0;
                for (int i = 0; i < ore.length; i++) {
                    cumulativeProbability += randomList[i];
                    if (randomValue <= cumulativeProbability) {
                        System.out.println(ore[i]);
                        oreCount.put(ore[i], oreCount.get(ore[i]) +1);
                        break;
                    }
                }
            }
            if (num == 2) {
                System.out.println("Block Break Count : " + count);
            }
            if (num == 3) {
                for (Map.Entry<String, Integer> entry : oreCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            if (num == 4) {
                break;
            }
        }
        System.out.println("게임 종료");

    }
}