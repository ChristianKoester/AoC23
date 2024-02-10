package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day02 {

    public static void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/main/resources/day02.txt"));
        part1(scanner);
        scanner.close();

        scanner = new Scanner(new FileReader("src/main/resources/day02.txt"));
        part2(scanner);
        scanner.close();
    }

    private static void part1(Scanner scanner) {
        int sum = 0;
        int i = 1;
        int red = 12;
        int green = 13;
        int blue = 14;
        while (scanner.hasNextLine()) {
            boolean isValid = true;
            String line = scanner.nextLine();
            String[] lineSplit = line.split(":");
            String[] games = lineSplit[1].trim().split(";");
            for (String game:games) {
                String[] cubes = game.trim().split(",");
                for (String cube: cubes) {
                    String[] pair = cube.trim().split(" ");
                    isValid = switch (pair[1]) {
                        case "red" -> Integer.parseInt(pair[0]) <= red;
                        case "green" -> Integer.parseInt(pair[0]) <= green;
                        case "blue" -> Integer.parseInt(pair[0]) <= blue;
                        default -> true;
                    };
                    if (!isValid)
                        break;
                }
                if (!isValid)
                    break;
            }
            if (isValid)
                sum += i;
            i++;
        }
        System.out.println("Day 02 | Part 01: " + sum);
    }

    private static void part2(Scanner scanner) {
        int sum = 0;
        while (scanner.hasNextLine()) {
            int red = 0;
            int green = 0;
            int blue = 0;
            String line = scanner.nextLine();
            String[] lineSplit = line.split(":");
            String[] games = lineSplit[1].trim().split(";");
            for (String game:games) {
                String[] cubes = game.trim().split(",");
                for (String cube: cubes) {
                    String[] pair = cube.trim().split(" ");
                    switch (pair[1]) {
                        case "red" -> red = Math.max(Integer.parseInt(pair[0]), red);
                        case "green" -> green = Math.max(Integer.parseInt(pair[0]), green);
                        case "blue" -> blue = Math.max(Integer.parseInt(pair[0]), blue);
                    }
                }
            }
            int subtotal = red * green * blue;
            sum += subtotal;
        }
        System.out.println("Day 02 | Part 02: " + sum);
    }
}

