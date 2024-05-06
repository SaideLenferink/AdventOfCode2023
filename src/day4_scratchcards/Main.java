package day4_scratchcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String file = "puzzle_input/day4.csv";
        List<String> importedList = importFile(file);

        List<String> winningNumbers = splitList(importedList, "winning");
        List<String> scratchNumbers = splitList(importedList, "scratch");

        calculateWinnings(winningNumbers, scratchNumbers);

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

    private static List<String> splitList(List<String> myList, String returningNumbers) {
        String winningNumbers;
        String scratchNumbers;

        List<String> winningList = new ArrayList<>();
        List<String> scratchList = new ArrayList<>();

        for (String s : myList) {
            String numbersOnly = s.substring(9);
            String splitNumbers = Arrays.toString(numbersOnly.split("\\|"));

            scratchNumbers = splitNumbers.substring((splitNumbers.indexOf(',') + 1), (splitNumbers.length() - 1));
            scratchList.add(scratchNumbers);

            winningNumbers = splitNumbers.substring(1, (splitNumbers.indexOf(',')));
            winningList.add(winningNumbers);
        }

        if (Objects.equals(returningNumbers, "winning")) {
            return winningList;
        } else if (Objects.equals(returningNumbers, "scratch")) {
            return scratchList;
        } else {
            System.out.println("An invalid list was requested");
            return myList;
        }
    }

    private static void calculateWinnings(List<String> winningNumbers, List<String> scratchNumbers) {
        int lineNumber;
        int matchPerLine = 0;
        int totalScore = 0;

        List<Card> cardList = new ArrayList<>();
        int totalNumber;

        StringBuilder scratch = new StringBuilder();
        StringBuilder winning = new StringBuilder();

        for (int i = 0; i < scratchNumbers.size(); i++) {
            String scratchLine = scratchNumbers.get(i);
            // set the line number so the scratch numbers and winning numbers use the same line
            lineNumber = i;
            // loop through the line of scratch-numbers and find matches in the winning-numbers
            for (int j = 0; j <= scratchLine.length(); j++) {
                if (j < scratchLine.length() && Character.isDigit(scratchLine.charAt(j))) {
                    scratch.append(scratchLine.charAt(j));
                } else if (!scratch.isEmpty()) {
                    String winningLine = winningNumbers.get(lineNumber);
                    for (int k = 0; k < winningLine.length(); k++) {
                        if (k < winningLine.length() && Character.isDigit(winningLine.charAt(k))) {
                            winning.append(winningLine.charAt(k));
                        } else if (!winning.isEmpty()) {
                            if (scratch.toString().equals(winning.toString())) {
                                // a match is found
                                matchPerLine++;
                            }
                            winning.setLength(0);
                        }
                    }
                    scratch.setLength(0);
                }
            }
            // at the end of looping through the scratch numbers, calculate the score for Part2
            cardList.add(new Card(i + 1, matchPerLine));

            // at the end of looping through the scratch numbers, calculate the score for Part1
            totalScore += scorePart1(matchPerLine);
            matchPerLine = 0;
        }

        // totalScore for Part1
        System.out.println("The total score is " + totalScore);

        //totalNumber for Part2
        totalNumber = scorePart2(cardList);
        System.out.println("The total number of cards is " + totalNumber);
    }

    private static int scorePart1(int matchPerLine) {
        int totalScore = 0;
        if (matchPerLine > 1) {
            int matchScore = (int) Math.pow(2, (matchPerLine - 1));
            totalScore += matchScore;
        } else {
            totalScore += matchPerLine;
        }
        return totalScore;
    }

    private static int scorePart2(List<Card> list) {
        int totalNumber = 0;

        for (int i = 0; i < list.size(); i++) {
            int duplicates = list.get(i).getNumberOfDuplicates();
            int matches = list.get(i).getNumberOfMatches();
            if (matches > 0) {
                for (int j = i + 1; j < list.size() && matches > 0; j++) {
                    Card card = list.get(j);
                    card.setNumberOfDuplicates(card.getNumberOfDuplicates() + duplicates);
                    matches--;
                }
            }
        }

        for (Card card : list) {
            totalNumber += card.getNumberOfDuplicates();
        }

        return totalNumber;
    }

}

class Card {
    int cardNumber;
    int numberOfMatches;
    int numberOfDuplicates = 1;

    public Card(int cardNumber, int numberOfMatches) {
        this.cardNumber = cardNumber;
        this.numberOfMatches = numberOfMatches;
    }

    public void setNumberOfDuplicates(int numberOfDuplicates) {
        this.numberOfDuplicates = numberOfDuplicates;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getNumberOfDuplicates() {
        return numberOfDuplicates;
    }
}
