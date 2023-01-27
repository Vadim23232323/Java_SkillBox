public class Alphabet {

    //Вывод латинских букв и соответствие кодов каждой букве
    public void getAlphabet () {
        char ch;
        for (ch = 'A'; ch <= 'z'; ch++) {
            System.out.println(ch + " (" + ((int) ch) + ")");
        }
    }
    }
