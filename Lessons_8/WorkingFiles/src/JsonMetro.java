import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonMetro {
    private ArrayList<JsonLine> lines;
    private  Map<String, List<String>> stationsMetro;

    public JsonMetro(ArrayList<JsonLine> lines, Map<String, List<String>> stationsMetro) {
        this.lines = lines;
        this.stationsMetro = stationsMetro;
    }
    public ArrayList<JsonLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<JsonLine> lines) {
        this.lines = lines;
    }

    public Map<String, List<String>> getStationsMetro() {
        return stationsMetro;
    }

    public void setStationsMetro(Map<String, List<String>> stationsMetro) {
        this.stationsMetro = stationsMetro;
    }


}
