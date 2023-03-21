import java.util.Objects;

public class JsonLine
{
    private String nameLine;
    private String numberLine;

    public JsonLine(String numberLine, String nameLine) {
        this.numberLine = numberLine;
        this.nameLine = nameLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameStation) {
        this.nameLine = nameStation;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberStation) {
        this.numberLine = numberStation;
    }


}
