package de.christian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day06 {
    public static void run() throws FileNotFoundException {
        ArrayList<DataPair> list = new ArrayList<DataPair>();
        list.add(new DataPair(58819676.0,434104122191218.0));
        part1(list);
        part2();
    }

    private static void part1(ArrayList<DataPair> list) {
        double product = 1;
        for (DataPair dp: list) {
            double[] option = new double[(int)dp.time];
            int count = 0;
            for (int i = 0; i < dp.time; i++) {
                option[i] = (dp.time - (i+1)) * (i + 1);
                if (option[i] > dp.distance)
                    count++;
            }
            product *= count;
        }
        System.out.println("Day 06 | Part 01: " + (int)product);
    }

    private static void part2() {
        System.out.println("Day 06 | Part 02: ");
    }
}

class DataPair {
    double time;
    double distance;

    public DataPair(double time, double distance) {
        this.time = time;
        this.distance = distance;
    }
}
