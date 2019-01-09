package Sort;
// this question can be taken as the extension of the mergesort
public class StringShuffle {
    public String shuffle(String s) {
        char[] mychar = s.toCharArray();
        shuffle(mychar, 0, s.length() - 1);
        return new String(mychar);
    }

    private void shuffle(char[] mychar, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int leftmid = left + (right - left + 1) / 4;
        int mid = left + (right - left+ 1) / 2;
        int rightmid = mid + (right - left + 1) / 4;
        reverse(mychar, leftmid, mid - 1);
        reverse(mychar, mid, rightmid - 1);
        reverse(mychar, leftmid, rightmid - 1);

        shuffle(mychar, left, left + 2 * (leftmid - left) - 1);
        shuffle(mychar, left + 2 * (leftmid - left), right);
    }

    private void reverse(char[] mychar, int start, int end) {
        while (start < end) {
            swap(mychar, start++, end--);
        }
    }

    private void swap(char[] mychar, int i, int j) {
        char temp = mychar[i];
        mychar[i] = mychar[j];
        mychar[j] = temp;
    }

    public static void main(String[] args) {
        StringShuffle here = new StringShuffle();
        System.out.println(here.shuffle("ABCDE12345"));
    }
}

