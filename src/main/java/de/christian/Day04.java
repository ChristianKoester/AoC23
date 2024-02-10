package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day04 {
    public static void run() throws FileNotFoundException {
        String file = "src/main/resources/day04.txt";
        Scanner scanner = new Scanner(new FileReader(file));
        int sum1 = 0;
        ArrayList<Integer> wins = new ArrayList<>();
        while (scanner.hasNextLine()) {
            ArrayList<Integer> winningNumbers = new ArrayList<>();
            ArrayList<Integer> myNumbers = new ArrayList<>();
            String line = scanner.nextLine();
            String[] lineSplit = line.split(":");
            String[] numbers = lineSplit[1].trim().split("\\|");
            String[] help = numbers[0].trim().split(" ");
            for (String number: help) {
                if (!number.isEmpty())
                    winningNumbers.add(Integer.parseInt(number));
            }
            help = numbers[1].trim().split(" ");
            for (String number: help) {
                if (!number.isEmpty())
                    myNumbers.add(Integer.parseInt(number));
            }
            sum1 += part1(winningNumbers, myNumbers);
            wins.add(part2(winningNumbers,myNumbers));

        }
        scanner.close();
        System.out.println("Day 04 | Part 01: " + sum1);
        System.out.println("Day 04 | Part 02: " + part2(wins));
    }

    private static int part1(ArrayList<Integer> win, ArrayList<Integer> my) {
        int count = 0;
        for (int i: win) {
            if (my.contains(i))
                count = (count == 0) ? 1 : count * 2;
        }
        return count;
    }

    private static int part2(ArrayList<Integer> win, ArrayList<Integer> my) {
        int count = 0;
        for (int i: win) {
            if (my.contains(i))
                count++;
        }
        return count;
    }
    
    private static int part2(ArrayList<Integer> wins) {
        int sum = 0;
        int[] copies = new int[wins.size()];
        Arrays.fill(copies, 1);
        for (int i = 0; i < wins.size(); i++) {
            for (int n = 1; n <= wins.get(i); n++) {
                copies[i+n] += copies[i];
            }
            sum += copies[i];
        }
        
        return sum;
    }
}
