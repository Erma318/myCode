package Sort;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int p = nums.length - k; // to find kth largest is to find pth smallest.
        return findKthLargest(nums, p, 0, nums.length - 1);

    }

    private int findKthLargest(int[] nums, int p, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int pivot = createPivot(left, right);
        int pivotVal = nums[pivot];
        swap(nums, right, pivot);
        int i = left;
        int j = right - 1;
        while (i <= j) { // stop condition
            if (nums[i] < pivotVal) {
                i++;
            } else if (nums[j] >= pivotVal) {
                j--;
            } else if (nums[i] >= pivotVal && nums[j] < pivotVal) {
                swap(nums, i++, j--);
            }
        }
        swap(nums, i, right);
        if (i == p) {
            return nums[p];
        } else if (i < p) {
            return findKthLargest(nums, p, i + 1, right);
        } else {
            return findKthLargest(nums, p, left, i - 1);
        }

    }

    private void swap(int[] nums, int i,  int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int createPivot(int left, int right) {
        return left + (int) Math.random() * (right - left + 1); // the use int cast
    }

    public static void main(String[] args) {
        KthLargestElementinanArray here = new KthLargestElementinanArray();
        int[] input = {3,2,1,5,6,4};
        System.out.println(here.findKthLargest(input, 2));
    }
}
