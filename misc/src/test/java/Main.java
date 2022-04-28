public class Main {
    public static void main(String[] args) {
        Misc misc = new Misc();

        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "0P";
        String test3 = "race a car";
        String test4 = "a.b,.";

        System.out.println(misc.cleanString(test4));
    }
}
