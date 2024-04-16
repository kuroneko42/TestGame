package na.kuroneko;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> orePercent  = new TreeMap<>();
        orePercent.put("stone", 0.50);
        orePercent.put("coal", 0.20);
        orePercent.put("iron_ingot", 0.15);
        orePercent.put("gold_ingot", 0.10);
        orePercent.put("emerald", 0.04);
        orePercent.put("diamond", 0.01);
        int count = 0;

        Map<String, Integer> oreCount = new TreeMap<>();
        for (String o : orePercent.keySet()) {
            oreCount.put(o, 0);
        }

        while (true) {
            int num = scanner.nextInt();
            if (num == 1) {
                count++;
                Random random = new Random();
                double randomValue = random.nextDouble();

                double cumulativeProbability = 0.0;
                for (String o : orePercent.keySet()) {
                    cumulativeProbability += orePercent.get(o);
                    if (randomValue <= cumulativeProbability) {
                        System.out.println(o);
                        oreCount.put(o, oreCount.get(o) + 1);
                        break;
                    }
                }
            } else if (num == 2) {
                System.out.println("Block Break Count : " + count);
            } else if (num == 3) {
                for (Map.Entry<String, Integer> entry : oreCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else if (num == 4) {
                System.out.println("게임 종료");
                System.exit(0);
            }
        }
    }
}
