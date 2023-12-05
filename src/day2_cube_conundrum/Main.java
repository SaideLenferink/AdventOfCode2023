package day2_cube_conundrum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String file = "puzzle_input/day2.csv";

/*
 manual testing of my logic before importing the input to fit
        Hand firstHand = new Hand(4,3,0);
        Hand secondHand = new Hand(0,6,2);
        Hand thirdHand = new Hand(0,0,2);

        List<Hand> setOfHands = new ArrayList<>();
        setOfHands.add(firstHand);
        setOfHands.add(secondHand);
        setOfHands.add(thirdHand);

        Game game1 = new Game(1, setOfHands);

        System.out.println(game1);

        game1.findImpossibleGames(12,14,12);
*/
        List<Game> myList = new ArrayList<>(importCSV(file));

        calculateValidGames(myList);
        calculatePower(myList);

    }

    private static void calculateValidGames(List<Game> list) {

        int sum = 0;
        for (Game g : list) {
            sum += g.findImpossibleGames(12, 14, 13);
        }
        System.out.println("-".repeat(20));
        System.out.println("The sum of possible gameIds is: " + sum);
    }

    private static void calculatePower(List<Game> list) {

        int power = 0;
        for (Game g : list) {
            power += g.findPower();
        }
        System.out.println("-".repeat(20));
        System.out.println("The sum of total power is: " + power);
    }

    private static List<Game> importCSV(String file) {

        int gameId = 0;
        List<Game> allGames = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(file));
            csvReader.useDelimiter(",");

            while (csvReader.hasNext()) {
                String s = csvReader.nextLine();
                String gameInput = s.substring(s.indexOf(":") + 2); // extract everything for the game
                gameId++;                                                    // set gameId

                String[] hands = gameInput.split(";");
                List<Hand> allHands = new ArrayList<>();


                for (String s2 : hands) {
                    String[] cubes = s2.split(",");
                    int greenCube = 0;
                    int blueCube = 0;
                    int redCube = 0;

                    for (String s3 : cubes) {
                        if (s3.contains("green")) {
                            greenCube = Integer.parseInt(s3.replaceAll("\\D+", ""));
                        } else if (s3.contains("blue")) {
                            blueCube = Integer.parseInt(s3.replaceAll("\\D+", ""));
                        } else if (s3.contains("red")) {
                            redCube = Integer.parseInt(s3.replaceAll("\\D+", ""));
                        }
                    }
                    allHands.add(new Hand(redCube, blueCube, greenCube));
                }
                Game newGame = new Game(gameId, allHands);
                allGames.add(newGame);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error was found in the file name");
        }
        return allGames;
    }
}
