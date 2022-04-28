import java.util.List;

public class PascalTest {

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        Misc misc = new Misc();

        printList(misc.getRow(3));
    }
}
