package day5_fertilizer_almanac;

import java.util.ArrayList;
import java.util.List;

public class Seed {

    // seed -> soil -> fertilizer -> water -> light -> temperature -> humidity -> location

    private long seedNumber;
    private long soil;
    private long fertilizer;
    private long water;
    private long light;
    private long temperature;
    private long humidity;
    private long location;

    public Seed (long seedNumber){
        this.seedNumber = seedNumber;
    }

    @Override
    public String toString() {
        return "\nSeed{" +
                "seedNumber=" + seedNumber +
                ", soil=" + soil +
                ", fertilizer=" + fertilizer +
                ", water=" + water +
                ", light=" + light +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", location=" + location +
                '}';
    }

    public void calculateLocation(List<String> sourceList) {

        soil = calculateElement(sourceList, 3, 30, seedNumber);
        fertilizer = calculateElement(sourceList, 33, 42, soil);
        water = calculateElement(sourceList,45,53, fertilizer);
        light = calculateElement(sourceList, 56,78, water);
        temperature = calculateElement(sourceList, 81, 112, light);
        humidity = calculateElement(sourceList, 115, 159, temperature);
        location = calculateElement(sourceList, 162,210, humidity);

        // seed -> soil[3][30] -> fertilizer[33][42] -> water[45][53] -> light[56][78] -> temperature[81][112] -> humidity[115][159] -> location[162][210]
    }

    private long calculateElement(List<String> sourceList, int startRange, int endRange, long sourceElement) {
        List<Map> seedToElement = new ArrayList<>();
        for (int i = startRange; i <= endRange; i++) {
            String string = sourceList.get(i);
            String[] array = string.split(" ");
            seedToElement.add(new Map(array[0], array[1], array[2]));
        }
        long elementValue = calculateElementValue(seedToElement, sourceElement);
        if (elementValue == 0) {
            return sourceElement;
        } else {
            return elementValue;
        }
    }

    private long calculateElementValue(List<Map> seedToElement, long sourceElement){
        long elementValue = 0;
        for (Map map : seedToElement) {
            long startNumber = map.getSource();
            if ((sourceElement >= startNumber) && (sourceElement <= (startNumber + map.getRange()-1))) {
                long difference = (sourceElement - startNumber);
                elementValue = difference + map.getDestination();
            }
        }
        return elementValue;
    }


    public long getLocation() {
        return location;
    }

}
