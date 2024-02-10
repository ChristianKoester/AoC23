package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day05 {
    public static void run() throws FileNotFoundException {
        String file = "src/main/resources/day05.txt";
        Scanner scanner = new Scanner(new FileReader(file));
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
        }
        scanner.close();
        part1();
        part2();
    }

    private static void part1() {
        System.out.println("Day 05 | Part 01: ");
    }

    private static void part2() {
        System.out.println("Day 05 | Part 02: ");
    }
}
