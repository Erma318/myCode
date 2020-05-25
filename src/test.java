import java.util.*;

public class test {
    public String decompress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        return decodeLong(decodeShort(input));
    }
    private int getDigit(char c) {
        return c - '0';
    }

    private String decodeShort(String input) {
        char[] in = input.toCharArray();
        int end = 0;
        for (int i = 0; i < in.length; i+=2) {
            int digit = getDigit(in[i + 1]);
            if (digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    in[end++] = in[i];
                }
            } else {
                in[end++] = in[i];
                in[end++] = in[i + 1];
            }
        }
        return new String(in, 0, end);
    }

    private String decodeLong(String input) {
        char[] in = input.toCharArray();
        int count = in.length;
        for (int i = 0; i < in.length; i++) {
            int digit = getDigit(in[i]);
            if (digit >= 3 && digit <= 9) {
                count += digit - 2;
            }
        }
        char[] newString = new char[count];
        int end = count - 1;
        for (int i = in.length - 1; i >= 0; i--) {
            int digit = getDigit(in[i]);
            if (digit >= 3 && digit <= 9) {
                for (int j = 0; j < digit; j++) {
                    newString[end--] = in[i - 1];
                }
                i--;
            } else {
                newString[end--] = in[i];
            }
        }
        return new String(newString);
    }


    public static void main(String[] args) {
        test here = new test();
        System.out.println(here.decompress("o3r2t2a3"));
    }
}
