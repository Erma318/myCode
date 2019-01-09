package Integer;

public class StringToInteger {
    public int myAtoi(String str) {
        int res = 0;
        char[] mychar = str.toCharArray();
        int i = 0;
        boolean positive = true;
        for (; i < mychar.length; i++) {
            if (mychar[i] != ' ') {
                break;
            }
        }
        if (i == mychar.length) {
            return 0;
        } else {
            if (mychar[i] == '-') {
                positive = false;
                i++;
            } else if (mychar[i] == '+') {
                i++;
            } else if (!Character.isDigit(mychar[i])) {
                return 0;
            }
        }
        for (; i < mychar.length && Character.isDigit(mychar[i]); i++) {
            if (positive) {
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Character.getNumericValue(mychar[i]) > 7)) {
                    return Integer.MAX_VALUE;
                } else {
                    res = 10 * res + Character.getNumericValue(mychar[i]);
                }
            } else {
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -Character.getNumericValue(mychar[i]) < -8)) {
                    return Integer.MIN_VALUE;
                } else {
                    res = 10 * res - Character.getNumericValue(mychar[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringToInteger here = new StringToInteger();
        System.out.println(here.myAtoi("-2147483649"));
    }
}
