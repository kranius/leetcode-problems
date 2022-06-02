public class Main {

    public static int addDigits(int num) {
        while (10 < num) { // one digit number is smaller than 10
            num = sumOfDigits(num);
        }

        return num;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;

        while (0 < num) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(11));
    }
}
