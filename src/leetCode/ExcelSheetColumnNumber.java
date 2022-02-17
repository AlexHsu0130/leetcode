package leetCode;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        // "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf("A");
        titleToNumber("ZY");

    }

    public static int titleToNumber(String columnTitle) {
        String[] table = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] parseStr = columnTitle.toCharArray();
        int a = parseStr.length;
        int signel = 0;
        int result = 0;
        for (int i = 0; i < a; i++) {
            signel = (int) Math.pow(26, str.indexOf(String.valueOf(parseStr[i])));
            result = signel + str.indexOf(String.valueOf(parseStr[i])) + result;
        }
        return result;
    }
}
