package DFS;

import java.util.ArrayList;
import java.util.List;

public class FindAllConbinationOfSubString {
    public static void main(String[] args) {
        String input = "115373";
        FindAllConbinationOfSubString myTest = new FindAllConbinationOfSubString();
        System.out.println(myTest.findAllConbinationOfSubString(input));
    }

    public List<List<String>> findAllConbinationOfSubString(String input) {
        List<List<String>> res = new ArrayList<>();
        for (int numOfParts = 1; numOfParts <= input.length(); numOfParts++) {
            List<List<String>> singleRes = find(input, numOfParts);
            for (List<String> x : singleRes) {
                res.add(x);
            }
        }
        return res;
    }

    public List<List<String>> find(String input, int numOfParts) {
        List<List<String>> res = new ArrayList<>();
        List<String> curRes = new ArrayList<>();
        for (int i = 1; i <= input.length() - (numOfParts - 1); i++) {
            dfs(res, curRes, 0, i, 1, numOfParts, input);
        }
        return res;
    }

    private void dfs(List<List<String>> res, List<String> curRes, int start, int end, int level, int numOfParts, String input) {
        if (level == numOfParts) {
            if (end == input.length()) {
                String sub = input.substring(start, end);
                if (ifPrime(Integer.parseInt(sub))) {
                    curRes.add(input.substring(start, end));
                    List<String> newRes = new ArrayList<>();
                    for (String x : curRes) {
                        newRes.add(x);
                    }
                    res.add(newRes);
                    curRes.remove(curRes.size() - 1);
                }
            }
            return;
        }

        curRes.add(input.substring(start, end));
        for (int i = end + 1; i <= input.length() - (numOfParts - (level + 1)); i++) {
            if (ifPrime(Integer.parseInt(input.substring(end, i)))) {
                dfs(res, curRes, end, i, level + 1, numOfParts, input);
            } else {
                curRes.remove(curRes.size() - 1);
                return;
            }
        }
        curRes.remove(curRes.size() - 1);
    }

    private boolean ifPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
