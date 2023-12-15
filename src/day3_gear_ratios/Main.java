package day3_gear_ratios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String file = "puzzle_input/day3.csv";

//        String example = "puzzle_input/day3_example.csv";
//
//        List<String> exampleList;
//        GondolaEngine exampleEngine = new GondolaEngine(exampleList = importCSV(example));
//        exampleEngine.getValidPartNumber(exampleList);


        List<String> engineList;
        engineList = importCSV(file);

        GondolaEngine myEngine = new GondolaEngine(engineList);

        myEngine.getValidPartNumber(engineList);
        myEngine.getGearRatios(engineList);

    }

    private static List<String> importCSV(String file) {
        List<String> myList = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(file));
            csvReader.useDelimiter(",");
            while(csvReader.hasNext()) {
                String newLine = csvReader.nextLine();
                myList.add(newLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error was found in the file path.");
        }
        return myList;
    }
}
