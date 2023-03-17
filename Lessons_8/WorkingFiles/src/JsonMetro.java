import java.util.ArrayList;

public class JsonMetro {
    private ArrayList<JsonLine> lines;
    private ArrayList<JsonStation> stations;

    public JsonMetro(ArrayList<JsonLine> lines, ArrayList<JsonStation> stations) {
        this.lines = lines;
        this.stations = stations;
    }

    public ArrayList<JsonLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<JsonLine> lines) {
        this.lines = lines;
    }

    public ArrayList<JsonStation> getStations() {
        return stations;
    }

    public void setStations(ArrayList<JsonStation> stations) {
        this.stations = stations;
    }
}
