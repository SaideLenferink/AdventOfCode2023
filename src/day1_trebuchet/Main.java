package day1_trebuchet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filepath = "puzzle_input/day1.csv";
        calibrateValues(filepath);

    }

    private static void calibrateValues(String filepath) {

        List<Calibration> myList = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(filepath));
            csvReader.useDelimiter(",");
            while (csvReader.hasNext()) {
                String s = csvReader.nextLine();
                myList.add(new Calibration(s));
            }
            csvReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.printf("Error: file '%s' was not found.", filepath);
        }

        int sum = 0;
        for(Calibration s : myList) {
            sum += s.getCalibrationValue();
            // System.out.println(sum);
        }
        System.out.println("The total calibration value is " + sum);
    }
}
