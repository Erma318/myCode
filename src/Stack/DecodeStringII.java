package Stack;

import java.util.LinkedList;

public class DecodeStringII {
    public String decodeStringII(String s) {
        String res = "";
        LinkedList<String> resStack  = new LinkedList<>();
        LinkedList<Integer> countStack = new LinkedList<>();
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
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeStringII here = new DecodeStringII();
        System.out.println(here.decodeStringII("a[b]2c[de[fg]2def]2ab[c]3"));

    }
}
