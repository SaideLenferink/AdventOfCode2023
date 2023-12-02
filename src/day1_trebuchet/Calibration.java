package day1_trebuchet;

public class Calibration {

    private String calibrationText;
    private int firstDigit;
    private int secondDigit;
    private int calibrationValue;

    public Calibration(String calibrationText) {
        this.calibrationText = calibrationText;
        firstDigit = findFirstDigit();
        secondDigit = findSecondDigit();
        calibrationValue = calibrateValue();
    }

    @Override
    public String toString() {
        return "Calibration value from " + calibrationText + " was found: " + calibrationValue;
    }

    public int getCalibrationValue() {
        return calibrationValue;
    }

    private int findFirstDigit() {
        boolean digitFound = false;
        while (!digitFound) {
            for(int i = 0; i < calibrationText.length(); i++) {
                char j = calibrationText.charAt(i);
                if (j >= 49 && j <= 57) {
                    firstDigit = Integer.parseInt(Character.toString(j));
                    digitFound = true;
                    //System.out.println("The second digit was found: " + j);
                    break;
                }
            }
        }
        return firstDigit;
    }

    private int findSecondDigit() {
        boolean digitFound = false;
        while (!digitFound) {
            for(int i = calibrationText.length() -1; i >= 0; i--) {
                char j = calibrationText.charAt(i);
                if (j >= 49 && j <= 57) {
                    secondDigit = Integer.parseInt(Character.toString(j));
                    digitFound = true;
                    //System.out.println("The first digit was found: " + j);
                    break;
                }
            }
        }
        return secondDigit;
    }

    private int calibrateValue() {
        String calibration = String.valueOf(firstDigit) +  String.valueOf(secondDigit);
        return calibrationValue = Integer.parseInt(calibration);
    }

}
