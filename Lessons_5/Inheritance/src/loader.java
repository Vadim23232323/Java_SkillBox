import figures.Square;
import figures.Rectangle;


public class loader {

    public static void main(String[] args) {
        Square square = new Square(40);
        System.out.println("������� ��������: " + square.getSquare());

        Rectangle rectangle = new Rectangle(30,40);
        System.out.println("������� ��������������: " + rectangle.getSquare());

    }
}
