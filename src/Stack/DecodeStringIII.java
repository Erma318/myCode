package Stack;

import java.util.LinkedList;

public class DecodeStringIII {
    public String decodeStringIII(String s) {
        String res = "";
        LinkedList<String> resStack  = new LinkedList<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                resStack.offerFirst(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                i++;
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                String temp = resStack.pollFirst();
                for (int j = 0; j < count; j++) {
                    temp += res;
                }
                res = temp;
            } else if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                String temp = res.substring(0, res.length() - 1);
                for (int j = 0; j < count; j++) {
                    temp += res.charAt(res.length() - 1);
                }
                res = temp;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeStringIII here = new DecodeStringIII();
        System.out.println(here.decodeStringIII("ab2c[de[fg]2def]2abc3"));

    }
}
