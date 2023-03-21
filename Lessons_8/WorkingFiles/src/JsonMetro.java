import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonMetro {

    private TreeMap<String, List<String>> stations;
    private ArrayList<JsonLine> lines ;


    public JsonMetro(TreeMap<String, List<String>> stations, ArrayList<JsonLine> lines) {
        this.stations = stations;
        this.lines = lines;
    }

    public Map<String, List<String>> getStations() {
        return stations;
    }

    public void setStations(TreeMap<String, List<String>> stations) {
        this.stations = stations;
    }

    public ArrayList<JsonLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<JsonLine> lines) {
        this.lines = lines;
    }

}
