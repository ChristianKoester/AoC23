package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day03 {
    public static void run() throws FileNotFoundException {
        String file = "src/main/resources/day03.txt";
        int lineCount;
        try (Stream<String> stream = Files.lines(Path.of(file))) {
            lineCount = (int) stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(new FileReader(file));
        char[][] input = new char[lineCount][];
        int i = 0;
        while (scanner.hasNextLine()) {
            input[i] = scanner.nextLine().toCharArray();
            i++;
        }
        scanner.close();

        part01(input);
        part02(input);
    }

    private static void part01(char[][] input){
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            StringBuilder partNumber = new StringBuilder();
            boolean isPartNumber = false;
            for (int j = 0; j < input[i].length; j++) {
                if (Character.isDigit(input[i][j])) {
                    partNumber.append(input[i][j]);
                    isPartNumber = hasAdjacentSymbol(input,i,j) || isPartNumber;
                }
                else {
                    if (isPartNumber && (!partNumber.isEmpty())) {
                        sum += Integer.parseInt(partNumber.toString());
                    }
                    partNumber = new StringBuilder();
                    isPartNumber = false;
                }
            }
            if (isPartNumber && (!partNumber.isEmpty())) {
                sum += Integer.parseInt(partNumber.toString());
            }
        }
        System.out.println("Day 03 | Part 01: " + sum);
    }

    private static boolean hasAdjacentSymbol(char[][] input, int i, int j) {
        boolean hasSymbol = false;
        for (int k = Math.max(i-1,0); k <= Math.min(i+1, input.length - 1); k++) {
            for (int l = Math.max(j-1, 0); l <= Math.min(j+1, input[k].length - 1); l++) {
                if (!Character.isDigit(input[k][l]) && input[k][l] != '.') {
                    hasSymbol = true;
                }
            }
        }
        return hasSymbol;
    }

    private static void part02(char[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == '*')
                    sum += getRatio(input,i,j);
            }
        }
        System.out.println("Day 03 | Part 02: " + sum);
    }

    private static int getRatio(char[][] input, int i, int j) {
        int ratio = 1;
        int count = 0;
        for (int a = Math.max(i-1,0); a <= Math.min(i+1, input.length - 1); a++) {
            StringBuilder s = new StringBuilder();
            for (int b = Math.max(j-1, 0); b <= Math.min(j+1, input[a].length - 1); b++) {
                if (Character.isDigit(input[a][b])) {
                    s.append(input[a][b]);
                    count++;
                    int x = b - 1;
                    while (x>= 0 && Character.isDigit(input[a][x])) {
                        s.insert(0, input[a][x]);
                        x--;
                    }
                    while (++b < input[a].length && Character.isDigit(input[a][b])) {
                        s.append(input[a][b]);
                    }
                    ratio *= Integer.parseInt(s.toString());
                    s = new StringBuilder();
                }
            }
        }
        return count == 2 ? ratio : 0;
    }
}
