import java.util.*;

public class test {
    public String replace(String input, String source, String target) {
        // Write your solution here
        char[] in = input.toCharArray();
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        String res;
        if (s.length < t.length) {
            res = replaceLong(in, s, t);

        } else {
            res = replaceShort(in, s, t);
        }
        return res;
    }

    private String replaceLong(char[] input, char[] source, char[] target) {
        List<Integer> occur = findOccur(input, source);
        int newLength = input.length + (target.length - source.length) * occur.size();
        char[] res = new char[newLength];
        int occurTimes = occur.size() - 1;
        int fast = res.length - 1;
        int slow = input.length - 1;
        while (slow >= 0) {
            if (slow == occur.get(occurTimes)) {
                copyString(res, fast - target.length + 1, target);
                slow -= source.length;
                fast -= target.length;
                occurTimes--;
            } else {
                res[fast--] = input[slow--];
            }
        }
        return new String(res);
    }

    private List<Integer> findOccur(char[] input, char[] source) {
        List<Integer> res= new ArrayList<>();
        for (int i = 0; i <= input.length - source.length; i++) {
            if (isEqual(input, source, i)) {
                res.add(i + source.length - 1);
                i = i + source.length - 1;
            }
        }
        return res;
    }

    private String replaceShort(char[] input, char[] source, char[] target) {
        int end = 0;
        for (int i = 0; i <= input.length - source.length; i++) {
            if (isEqual(input, source, i)) {
                copyString(input, end, target);
                end = end + target.length;
                i = i + source.length - 1;
            } else {
                input[end++] = input[i];
            }
        }
        return new String(input, 0 , end);
    }

    private boolean isEqual(char[] input, char[] source, int index) {
        for (int i = 0; i < source.length; i++) {
            if (input[index + i] != source[i]) {
                return false;
            }
        }
        return true;
    }

    private void copyString(char[] input, int index, char[] target) {
        for (int i = 0; i < target.length; i++) {
            input[index + i] = target[i];
        }
    }

    public static void main(String[] args) {
        test here = new test();
        System.out.println(here.replace("helloabchello", "hello", "tessst"));
    }
}
