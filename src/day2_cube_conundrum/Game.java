package day2_cube_conundrum;

import java.util.List;

public class Game {

    private final int gameId;
    private final List<Hand> hands;

    public Game(int gameId, List<Hand> hands) {
        this.gameId = gameId;
        this.hands = hands;
    }

    @Override
    public String toString() {
        return "Game " + gameId + ": " + hands;
    }

    public int findImpossibleGames(int maxRed, int maxBlue, int maxGreen) {

        boolean hasInvalidHand = false;

        for (Hand h : hands) {
            int amountRed = h.redCube();
            int amountBlue = h.blueCube();
            int amountGreen = h.greenCube();

            if ((amountRed > maxRed) || (amountBlue > maxBlue) || (amountGreen > maxGreen)) {
                hasInvalidHand = true;
                break;
            }
        }
        if (hasInvalidHand) {
            System.out.println("Game " + gameId + " contains at least one invalid hand");
            return 0;
        }
        System.out.println("Game " + gameId + " is valid");
        return gameId;
    }

    public int findPower() {

        int maxRed = 0;
        int maxBlue = 0;
        int maxGreen = 0;

        for (Hand h : hands) {
            if (h.redCube() > maxRed) {
                maxRed = h.redCube();
            }
            if (h.blueCube() > maxBlue) {
                maxBlue = h.blueCube();
            }
            if (h.greenCube() > maxGreen) {
                maxGreen = h.greenCube();
            }
        }
        return (maxRed * maxBlue * maxGreen);
    }

}
