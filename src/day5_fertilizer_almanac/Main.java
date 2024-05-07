package day5_fertilizer_almanac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String file = "puzzle_input/day5.csv";
        List<String> importedList = importFile(file);

        List<Seed> initialSeeds = splitOffSeeds(importedList);

        findLowestLocation(initialSeeds, importedList);

//        System.out.println(initialSeeds);
    }

    private static List<String> importFile(String filepath) {

        List<String> myList = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(filepath));
            csvReader.useDelimiter(",");
            while (csvReader.hasNext()) {
                String newLine = csvReader.nextLine();
                myList.add(newLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error was found in the file path.");
        }
        return myList;

    }

    private static List<Seed> splitOffSeeds(List<String> importedList) {

        List<Seed> seedList = new ArrayList<>();

        String s = importedList.get(0).substring(8);
        for (String string : s.split(" ")) {
            seedList.add(new Seed(Long.parseLong(string)));
        }

        return seedList;

    }

    private static void findLowestLocation(List<Seed> seeds, List<String> sourceList) {
//        What is the lowest location number that corresponds to any of the initial seed numbers?
        long lowest = 0;
        for (Seed seed : seeds) {
            seed.calculateLocation(sourceList);
            if (lowest == 0) {
                lowest = seed.getLocation();
            } else if (seed.getLocation() < lowest) {
                lowest = seed.getLocation();
            }
        }
        System.out.println("The lowest possible location number is " + lowest);
    }
}
