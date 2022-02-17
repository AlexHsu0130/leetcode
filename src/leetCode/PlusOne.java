package leetCode;

public class PlusOne {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] > 9) {
                digits[i] = 0;
            } else {
                break;
            }
        }
        if (digits[0] == 0) {
            int[] intArrs = new int[digits.length + 1];
            intArrs[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                intArrs[i + 1] = digits[i];
            }
            return intArrs;
        }

        return digits;
    }

}
