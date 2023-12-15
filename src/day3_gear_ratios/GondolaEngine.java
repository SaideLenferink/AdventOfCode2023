package day3_gear_ratios;

import java.util.List;

public class GondolaEngine {

    private final List<String> engineInput;

    private long sum;

    private long gearRatio;

    public GondolaEngine(List<String> engineInput) {
        this.engineInput = engineInput;
    }

    @Override
    public String toString() {
        return "" + engineInput;
    }

    public void getValidPartNumber(List<String> engineInput) {

        for (int i = 0; i < engineInput.size(); i++) {
            // get the current line of the engineInput
            String currentLine = engineInput.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                // loop through the line character by character
                char c = currentLine.charAt(j);
                if (c != '.' && !Character.isDigit(c)) {
                    // symbol found
                    findSurroundingNumbers(engineInput, i, j);
                }
            }
        }
        System.out.println("The total sum of all Parts is " + sum);
    }

    private void findSurroundingNumbers(List<String> engineInput, int i, int j) {

        // in row i the symbol is found on position j
        // if there's a number on the same row, row below, or row above which is on the same position outlines -1 or +1, the number should be counted

        if (i > 0) {
            // search the row above
            searchNumbers(engineInput, i - 1, j);
        }
        if (i < engineInput.size() - 1) {
            // search the row below
            searchNumbers(engineInput, i + 1, j);
        }
        searchNumbers(engineInput, i, j);

    }


    private void searchNumbers(List<String> engineInput, int searchRow, int symbolPosition) {

        String s = engineInput.get(searchRow);
        StringBuilder number = new StringBuilder();

        for (int k = 0; k <= s.length(); k++) {
            if (k < s.length() && Character.isDigit(s.charAt(k))) {
                number.append(s.charAt(k));
            } else if (!number.isEmpty()) {
                // check if any digit in the number is within one position of the symbol
                for (int digitPosition = 0; digitPosition < number.length(); digitPosition++) {
                    if (Math.abs((k - number.length() + digitPosition) - symbolPosition) <= 1) {
                        // If any digit is within one position of the symbol, consider the entire number
                        sum += Long.parseLong(number.toString());
                        number.setLength(0);
                        break;
                    }
                }
                number.setLength(0);
            }
        }
    }

    public void getGearRatios(List<String> engineInput) {

        for (int i = 0; i < engineInput.size(); i++) {
            // get the current line of the engineInput
            String currentLine = engineInput.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                // loop through the line character by character
                char c = currentLine.charAt(j);
                if (c == '*') {
                    // symbol found
                    searchGear(engineInput, i, j);
                }
            }
        }
        System.out.println("The total gear ratio is " + gearRatio);
    }

    private void searchGear(List<String> engineInput, int searchRow, int symbolPosition) {

        int amount = 0;
        long firstGear = 0;
        long secondGear = 0;

        StringBuilder number = new StringBuilder();

        if (searchRow > 0) {
            // search the row above
            String s = engineInput.get(searchRow - 1);
            for (int k = 0; k <= s.length(); k++) {
                if (k < s.length() && Character.isDigit(s.charAt(k))) {
                    number.append(s.charAt(k));
                } else if (!number.isEmpty()) {
                    // check if any digit in the number is within one position of the symbol
                    for (int digitPosition = 0; digitPosition < number.length(); digitPosition++) {
                        if (Math.abs((k - number.length() + digitPosition) - symbolPosition) <= 1) {
                            switch (amount) {
                                case 0 -> {
                                    firstGear = Long.parseLong(number.toString());
                                    amount++;
                                }
                                case 1 -> secondGear = Long.parseLong(number.toString());
                            }
                            if (firstGear != 0 && secondGear != 0) {
                                gearRatio += (firstGear * secondGear);
                            }
                            number.setLength(0);
                            break;
                        }
                    }
                    number.setLength(0);
                }
            }
        }
        if (searchRow < engineInput.size() - 1) {
            // search the row below
            String s = engineInput.get(searchRow + 1);
            for (int k = 0; k <= s.length(); k++) {
                if (k < s.length() && Character.isDigit(s.charAt(k))) {
                    number.append(s.charAt(k));
                } else if (!number.isEmpty()) {
                    // check if any digit in the number is within one position of the symbol
                    for (int digitPosition = 0; digitPosition < number.length(); digitPosition++) {
                        if (Math.abs((k - number.length() + digitPosition) - symbolPosition) <= 1) {
                            switch (amount) {
                                case 0 -> {
                                    firstGear = Long.parseLong(number.toString());
                                    amount++;
                                }
                                case 1 -> secondGear = Long.parseLong(number.toString());
                            }
                            if (firstGear != 0 && secondGear != 0) {
                                gearRatio += (firstGear * secondGear);
                            }
                            number.setLength(0);
                            break;
                        }
                    }
                    number.setLength(0);
                }
            }
        }
        String s = engineInput.get(searchRow);
        for (int k = 0; k <= s.length(); k++) {
            if (k < s.length() && Character.isDigit(s.charAt(k))) {
                number.append(s.charAt(k));
            } else if (!number.isEmpty()) {
                // check if any digit in the number is within one position of the symbol
                for (int digitPosition = 0; digitPosition < number.length(); digitPosition++) {
                    if (Math.abs((k - number.length() + digitPosition) - symbolPosition) <= 1) {
                        switch (amount) {
                            case 0 -> {
                                firstGear = Long.parseLong(number.toString());
                                amount++;
                            }
                            case 1 -> secondGear = Long.parseLong(number.toString());
                        }
                        if (firstGear != 0 && secondGear != 0) {
                            gearRatio += (firstGear * secondGear);
                        }
                        number.setLength(0);
                        break;
                    }
                }
                number.setLength(0);
            }
        }
    }
}

