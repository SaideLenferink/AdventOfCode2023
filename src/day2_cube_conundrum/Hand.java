package day2_cube_conundrum;

public record Hand(int redCube, int blueCube, int greenCube) {

    @Override
    public String toString() {
        return redCube + " red - " + blueCube + " blue - " + greenCube + " green";
    }

}
