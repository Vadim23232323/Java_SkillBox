import java.io.PrintWriter;

public class NumberGenerator implements Runnable{
    private final int startRegionCode;
    private final int endRegionCode;
    private final char[] letters;
    private final int maxNumber;
    private final String outputFileName;

    public NumberGenerator(int startRegionCode, int endRegionCode, char[] letters, int maxNumber, String outputFileName) {
        this.startRegionCode = startRegionCode;
        this.endRegionCode = endRegionCode;
        this.letters = letters;
        this.maxNumber = maxNumber;
        this.outputFileName = outputFileName;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (int regionCode = startRegionCode; regionCode <= endRegionCode; regionCode++) {
                for (int number = 1; number <= maxNumber; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                StringBuilder builder = new StringBuilder();
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode, 2));
                                builder.append("\n");

                                writer.write(builder.toString());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}
