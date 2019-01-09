package Stack;

import java.util.*;

public class CalculatorI_II_III {
    public int calculate(String s) {
        Deque<Long> nums = new LinkedList<>();
        Deque<Character> opes = new LinkedList<>();
        char[] mychar = s.toCharArray();
        for (int i = 0; i < mychar.length; i++) {
            if (mychar[i] == ' ')
                continue;
            if (Character.isDigit(mychar[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < mychar.length && Character.isDigit(mychar[i])) {
                    sb.append(mychar[i]);
                    i++;
                }
                i--;
                nums.offerFirst(Long.valueOf(sb.toString()));
            } else if (mychar[i] == ')') { // do the cal until (, don't forget to pop (
                while (opes.peek() != '(') {
                    nums.offerFirst(cal(opes.pollFirst(), nums.pollFirst(), nums.pollFirst()));
                }
                opes.pollFirst();
            } else if (mychar[i] == '+' || mychar[i] == '-' || mychar[i] == '*' || mychar[i] == '/') {
                while (!opes.isEmpty() && doCalOrNot(opes.peekFirst(), mychar[i])) {
                    nums.offerFirst(cal(opes.pollFirst(), nums.pollFirst(), nums.pollFirst()));
                }
                opes.offerFirst(mychar[i]);
            } else {
                opes.offerFirst(mychar[i]);
            }
        }
        while (!opes.isEmpty()) {
            nums.offerFirst(cal(opes.pollFirst(), nums.pollFirst(), nums.pollFirst()));
        }
        long res = nums.pollFirst();
        return (int) res;
    }

    private boolean doCalOrNot(char prev, char cur) {
        if (prev == '(' )
            return false;
        if ((cur == '*' || cur == '/') && (prev == '+' || prev == '-')) //当前优先级高的话不算
            return false;
        return true;
    }

    private long cal(char ope, long b, long a) {
        switch (ope) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/' :
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        CalculatorI_II_III here = new CalculatorI_II_III();
        System.out.println(here.calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
