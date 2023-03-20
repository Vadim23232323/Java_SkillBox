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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonLine line = (JsonLine) o;
        return Objects.equals(numberLine, line.numberLine) &&
                Objects.equals(nameLine, line.nameLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine, nameLine);
    }



}
