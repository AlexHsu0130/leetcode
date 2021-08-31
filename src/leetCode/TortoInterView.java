package leetCode;

public class TortoInterView {

    public static void main(String[] args) {
        System.out.println(sum(1));
        // System.out.println(rand());
        System.out.println(sumTailRec(1));
        System.out.println(division(1));
        // System.out.println(tailRec(4));
    }

    // 1-2+3-4+5-6+7-8+9-10
    private static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum = sum - i;
            } else {
                sum = sum + i;
            }
        }
        return sum;
    }

    private static String rand() {
        String gift = null;
        int ran = (int) (Math.random() * 5) + 1;
        switch (ran) {
        case 1:
            gift = "1";
            break;
        case 2:
            gift = "2";
            break;
        case 3:
            gift = "3";
            break;
        case 4:
            gift = "4";
            break;
        case 5:
            gift = "5";
            break;
        default:
            break;
        }
        return gift;
    }

    private static int tailRec(int n) {
        if (n == 0) {
            // System.out.println("tailRec : " + n);
            return 1;
        } else {
            System.out.println(n + " * " + tailRec(n - 1));
            return n * tailRec(n - 1);
        }
    }

    private static int sumTailRec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return sumTailRec(n - 1) - n;
        } else {
            return sumTailRec(n - 1) + n;
        }
    }

    private static int division(int n) {
        if (n % 2 == 0) {
            return -n / 2;
        } else {
            return (n / 2) + 1;
        }
    }
}
