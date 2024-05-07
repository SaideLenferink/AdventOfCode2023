package day5_fertilizer_almanac;

public class Map {

    private long destination;
    private long source;
    private long range;

    public Map(String destination, String source, String range){
        this.destination = Long.parseLong(destination);
        this.source = Long.parseLong(source);
        this.range = Long.parseLong(range);
    }

    public long getDestination() {
        return destination;
    }

    public long getSource() {
        return source;
    }

    public long getRange() {
        return range;
    }
}
