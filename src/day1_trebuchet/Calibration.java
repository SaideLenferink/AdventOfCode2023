package day1_trebuchet;

public class Calibration {

    private String calibrationText;
    private int firstDigit;
    private int secondDigit;
    private int calibrationValue;

    public Calibration(String calibrationText) {
        this.calibrationText = calibrationText;
    }

    @Override
    public String toString() {
        return "Calibration value from " + calibrationText + " was found: " + calibrationValue;
    }

    public int getCalibrationValue(int method) {
        return calibrateValue(method);
    }


    private int calibrateValue(int method) {
        switch (method) {
            case 1 -> {
                boolean firstDigitFound = false;
                while (!firstDigitFound) {
                    for (int i = 0; i < calibrationText.length(); i++) {
                        char j = calibrationText.charAt(i);
                        if (j >= 49 && j <= 57) {
                            firstDigit = Integer.parseInt(Character.toString(j));
                            firstDigitFound = true;
                            //System.out.println("The second digit was found: " + j);
                            break;
                        }
                    }
                }
                boolean secondDigitFound = false;
                while (!secondDigitFound) {
                    for (int i = calibrationText.length() - 1; i >= 0; i--) {
                        char j = calibrationText.charAt(i);
                        if (j >= 49 && j <= 57) {
                            secondDigit = Integer.parseInt(Character.toString(j));
                            secondDigitFound = true;
                            //System.out.println("The first digit was found: " + j);
                            break;
                        }
                    }
                }
                String calibration = String.valueOf(firstDigit) + String.valueOf(secondDigit);
                calibrationValue = Integer.parseInt(calibration);
            }
            case 2 -> {
                calibrationText =
                        calibrationText.replace("one", "one1one")
                                .replace("two", "two2two")
                                .replace("three", "three3three")
                                .replace("four", "four4four")
                                .replace("five", "five5five")
                                .replace("six", "six6six")
                                .replace("seven", "seven7seven")
                                .replace("eight", "eight8eight")
                                .replace("nine", "nine9nine");
                boolean firstDigitFound = false;
                while (!firstDigitFound) {
                    for (int i = 0; i < calibrationText.length(); i++) {
                        char j = calibrationText.charAt(i);
                        if (j >= 49 && j <= 57) {
                            firstDigit = Integer.parseInt(Character.toString(j));
                            firstDigitFound = true;
                            //System.out.println("The second digit was found: " + j);
                            break;
                        }
                    }
                }
                boolean secondDigitFound = false;
                while (!secondDigitFound) {
                    for (int i = calibrationText.length() - 1; i >= 0; i--) {
                        char j = calibrationText.charAt(i);
                        if (j >= 49 && j <= 57) {
                            secondDigit = Integer.parseInt(Character.toString(j));
                            secondDigitFound = true;
                            //System.out.println("The first digit was found: " + j);
                            break;
                        }
                    }
                }
                String calibration = String.valueOf(firstDigit) + String.valueOf(secondDigit);
                calibrationValue = Integer.parseInt(calibration);
            }
        }
        return calibrationValue;
    }

}
