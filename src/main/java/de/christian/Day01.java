package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day01 {

    public static void run() throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader("src/main/resources/day01.txt"));
        int sum1 = 0;
        int sum2 = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            sum1 += calculate(line);
            sum2 += calculate(Replace(line));
        }
        System.out.println("Day 01 | Part 01: " + sum1);
        System.out.println("Day 01 | Part 02: " + sum2);
        in.close();
    }

    private static int calculate(String line) {
        int a = -1;
        int b = -1;
        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                if (a == -1) {
                    a = Character.getNumericValue(c);
                }
                b = Character.getNumericValue(c);
            }
        }
        return a * 10 + b;
    }



    private static String Replace(String str) {
        str = str.toLowerCase();
        for (int i = 0; i <= str.length(); i++) {
            if (str.startsWith("one", i))
                str = str.replace("one", "o1e");
            else if (str.startsWith("two", i))
                str = str.replace("two", "t2o");
            else if (str.startsWith("three", i))
                str = str.replace("three", "t3ree");
            else if (str.startsWith("four", i))
                str = str.replace("four", "f4ur");
            else if (str.startsWith("five", i))
                str = str.replace("five", "f5ve");
            else if (str.startsWith("six", i))
                str = str.replace("six", "s6x");
            else if (str.startsWith("seven", i))
                str = str.replace("seven", "s7ven");
            else if (str.startsWith("eight", i))
                str = str.replace("eight", "e8ght");
            else if (str.startsWith("nine", i))
                str = str.replace("nine", "n9ne");
        }
        return str;
    }
}
