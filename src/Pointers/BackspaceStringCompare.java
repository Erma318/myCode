package Pointers;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0, skipT = 0;
        int upS = 0, upT = 0; // even means lower case, odd means upper case
        for (int k = 0; k < S.length();k++) {
            if (S.charAt(k) == '*') {
                upS++;
            }
        }
        for (int k = 0; k < T.length(); k++) {
            if (T.charAt(k) == '*') {
                upT++;
            }
        }
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || skipS > 0)) {
                if (S.charAt(i) == '#') {
                    skipS++;
                } else {
                    skipS--;
                }
                i--;
            }
            while (j >= 0 && (T.charAt(j) == '#' || skipT > 0)) {
                if (T.charAt(j) == '#') {
                    skipT++;
                } else {
                    skipT--;
                }
                j--;
            }
            while (i >= 0 && S.charAt(i) == '*') {
                upS--;
                i--;
            }
            while (j >= 0 && T.charAt(j) == '*') {
                upT--;
                j--;
            }
            if (i >=0 && j >= 0) {
                int s, t;
                if (upS % 2 == 1) {
                    s = (int) S.charAt(i) - 32;
                } else {
                    s = (int) S.charAt(i);
                }
                if (upT % 2 == 1) {
                    t = (int) T.charAt(j) - 32;
                } else {
                    t = (int) T.charAt(j);
                }
                if (s == t) {
                    i--;
                    j--;
                } else {
                    return false;
                }
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare here = new BackspaceStringCompare();
        System.out.println(here.backspaceCompare("abc*ac#", "abcA"));
    }

}
