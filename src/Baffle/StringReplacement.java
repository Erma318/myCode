package Baffle;

public class StringReplacement {
    public String replace(String input, String r, String t) {
        char[] array = input.toCharArray();
        int i = array.length - 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (checkSame(array, j, r)) {
                copy(array, i, t);
                i = i - t.length();
                j = j - (r.length() - 1);
            } else {
                array[i--] = array[j];
            }
        }
        return new String(array, i + 1, array.length - 1- i);
    }

    private boolean checkSame(char[] array , int j, String r) {
        if (array[j] == r.charAt(r.length() - 1)) {
            for (int i = r.length() - 1; i >= 0; i--) {
                if (array[j - (r.length() - 1 - i)] !=r.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private void copy(char[] array, int i, String t) {
        for (int k = t.length() - 1; k >= 0; k--) {
            array[i - (t.length() - 1 - k)] = t.charAt(k);
        }
    }

    public static void main(String[] args) {
        StringReplacement here = new StringReplacement();
        System.out.println(here.replace("studentdent", "den", "XX"));
    }
}
