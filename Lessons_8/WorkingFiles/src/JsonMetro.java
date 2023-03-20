import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonMetro {
    private ArrayList<JsonLine> lines;
    private TreeMap<String, List<String>> stations;

    public JsonMetro(TreeMap<String, List<String>> stations, ArrayList<JsonLine> lines) {
        this.lines = lines;
        this.stations = stations;
    }
    public ArrayList<JsonLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<JsonLine> lines) {
        this.lines = lines;
    }

    public Map<String, List<String>> getStations() {
        return stations;
    }

    public void setStations(TreeMap<String, List<String>> stations) {
        this.stations = stations;
    }


}
